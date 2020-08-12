package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "User_Gen", sequenceName = "User_Gen",  initialValue = 0)
public class User {

    //Username: user;
    // Password: [PROTECTED];
    // Enabled: true;
    // AccountNonExpired: true;
    // credentialsNonExpired: true;
    // AccountNonLocked: true;
    // Granted Authorities: ROLE_USER,ROLE_dro,ROLE_pe

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "User_Gen")
    private Long userId;

    private String username;

    private String password;

    private Boolean enable;

    private Boolean accountNonExpired;

    private Boolean credentialsNonExpired;

    private Boolean accountNonLocked;


    //https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    List<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enable = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
    }

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.enable = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
    }

}
