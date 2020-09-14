package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * org.springframework.security.core.userdetails.User
 *  Username: user;
 *  Password: [PROTECTED];
 *  Enabled: true;
 *  AccountNonExpired: true;
 *  credentialsNonExpired: true;
 *  AccountNonLocked: true;
 *  Granted Authorities: ROLE_USER,ROLE_dro,ROLE_pe
 *
 * org.springframework.security.core.userdetails.User.UserBuilder
 *  username;
 *  password;
 *  authorities;
 *  accountExpired;
 *  accountLocked;
 *  credentialsExpired;
 *  disabled;
 *  passwordEncoder;
 *
 *  Users = User + UserBuilder
 */
@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "User_Gen", sequenceName = "User_Gen",  initialValue = 1)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "User_Gen")
    private Long userId;

    private String username;

    private String password;

    private Boolean enabled;
    private boolean disabled;

    private Boolean accountNonExpired;
    private boolean accountExpired;

    private Boolean credentialsNonExpired;
    private boolean credentialsExpired;

    private Boolean accountNonLocked;
    private boolean accountLocked;

    /**
     * https://www.baeldung.com/jpa-many-to-many
     *
     * Store package for exemple:
     * https://vladmihalcea.com/hibernate-facts-the-importance-of-fetch-strategy/
     * https://vladmihalcea.com/n-plus-1-query-problem/
     * https://github.com/vladmihalcea/vladmihalcea.wordpress.com/tree/master/hibernate-facts
     *
     * https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api
     *
     * LAZY = fetch when needed - To load it on-demand
     *      = does not retrieve data if session is disconnected (after session.close() statement).
     *      = All that can be made by hibernate proxy.
     * EAGER = fetch immediately - To load it together with the rest of the fields
     *       = All data is fetched when session is connected.
     *       = Eager strategy lets data to be still available after closing session.
     *
     * Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
     *
     * The default fetch policy of persistent collection and map fields is FetchType.LAZY
     * The default for non collection and map references is FetchType.EAGER, indicating that the retrieval operation is cascaded through the field.
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     * (currently ObjectDB does not distinguish between the two) excludes the field from participating in retrieval cascading through the field.
     * @OneToOne(cascade=CascadeType.REFRESH)
     *
     *
     * By default, the JPA @ManyToOne and @OneToOne annotations are fetched EAGERly, while the @OneToMany and @ManyToMany relationships are considered LAZY
     * - When JPA loads an entity, it also loads all the EAGER or “join fetch” associations too.
     * As long as the persistence context is opened, navigating the LAZY association results in fetching those as well, through additionally executed queries.
     *
     * While some @ManyToOne or @OneToOne associations make sense to always be fetched eagerly, most of the time, they aren’t needed for every fetching operation.
     * For children associations, it’s always safer to mark them LAZY and only “join fetch” them when needed, because those can easily generate large SQL result sets, with unneeded joins.
     *
     * Having most of the associations defined as LAZY requires us to use the “join fetch” JPQL operator and retrieve only the associations we need to fulfill a given request.
     *
     * FetchType.LAZY === Caused by: org.hibernate.LazyInitializationException:
     * failed to lazily initialize a collection of role:
     * no.agitec.fagaften.mellom.oppdrag.domain.User.roles,
     * could not initialize proxy - no Session
     *
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    List<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
    }

}
