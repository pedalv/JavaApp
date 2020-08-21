package no.agitec.fagaften.mellom.oppdrag.service;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.domain.Role;
import no.agitec.fagaften.mellom.oppdrag.domain.User;
import no.agitec.fagaften.mellom.oppdrag.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * ROLE_ADMIN ⇒ ROLE_STAFF ⇒ ROLE_USER ⇒ ROLE_GUEST.
     * A user who is authenticated with ROLE_ADMIN, will behave as if they have all four roles
     *
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //List<User> usersList = userRepository.findUser(userName); //Roler is USER
        //List<User> usersList = userRepository.findAdmin(userName); //Roler is ADMIN
        Set<User> usersList = userRepository.findByUsername(userName); //Get user from database
        usersList.forEach( u -> log.info(u.toString())  );
        //User(userId=1, username=user, password=password, enable=true, disabled=false, accountNonExpired=true, accountExpired=false, credentialsNonExpired=true, credentialsExpired=false, accountNonLocked=true, accountLocked=false, roles=[Role(roleId=1, roleName=USER)])
        //Username: user; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_USER,ROLE_dro,ROLE_pe
        //TODO: Encode password in database on Server and Client side. See passwordDBBase64Str() method in CreatePassword class

        if (usersList != null && !usersList.isEmpty()) {
            User user = usersList.iterator().next();

            List<String> roleList = new ArrayList<>();
            for (Role role : user.getRoles()) {
                roleList.add(role.getRoleName());
            }

            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(user.getUsername())
                    .password( bCryptPasswordEncoder.encode(user.getPassword()) ) //password value store in database
//TODO: How compare password web and db? Implement in Spring Segurity inside index action.
// The generated password are salted and therefore different.
                    .disabled(!user.getEnable())
                    .accountExpired(!user.getAccountNonExpired())
                    .accountLocked(!user.getAccountNonLocked())
                    .credentialsExpired(!user.getCredentialsNonExpired())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }

}
