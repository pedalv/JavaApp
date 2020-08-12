package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {

    //Username: user;
    // Password: [PROTECTED];
    // Enabled: true;
    // AccountNonExpired: true;
    // credentialsNonExpired: true;
    // AccountNonLocked: true;
    // Granted Authorities: ROLE_USER,ROLE_dro,ROLE_pe

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;

    private String username;

    private String password;

    private Boolean enable;

    private Boolean accountNonExpired;

    private Boolean credentialsNonExpired;

    private Boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserRole",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enable = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
    }

}
