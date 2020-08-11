package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //System.out.println("**** configure");
        http
                .httpBasic(withDefaults())
                .authorizeRequests()
                .antMatchers(
                        //"/css/**",
                        "/",
                        "/home",
                        "/hello",
                        "/greeting",
                        "/person",
                        //"/partner",
                        "/customer",
                        "/employee",
                        "/kafka/sample1/send/foo/*",
                        "/kafka/sample1/send/foo2/*",
                        "/kafka/sample2/send/foo/*",
                        "/kafka/sample2/send/bar/*",
                        "/kafka/sample2/send/unknown/*",
                        "/kafka/sample3/send/foos/*",
                        "/javainuse-kafka/producer").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //.failureUrl("/login-error")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //System.out.println("**** userDetailsService");
        //Spring Security, OAuth2 Clinet, OAuth2 Resource Server, Apring LDAP, Okta


        UserDetails user =
                User.withDefaultPasswordEncoder()
                        //User.builder()
                        .username("user")
                        .password("password")
                        //.password(CreatePassword.bCryptPasswordEncoder("password"))
                        //BCryptPasswordEncoder: password => $2a$16$ahqFCpOXttJlTd9cq8of6uc7tr/Ak8kcDqOfDY/W.cPxOUL1Cfl9K
                        .roles("USER")
                        .build();

        log.info(user.toString());

        UserDetails admin = User.builder()
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();

        log.info(admin.toString());

        return new InMemoryUserDetailsManager(user, admin);
        //return new InMemoryUserDetailsManager(user);
    }

}
