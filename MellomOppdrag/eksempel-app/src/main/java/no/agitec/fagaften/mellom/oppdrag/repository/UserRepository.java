package no.agitec.fagaften.mellom.oppdrag.repository;

import no.agitec.fagaften.mellom.oppdrag.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * Note:
 * A Set is a collection of well defined and distinct objects.
 *  HashSet (unordered)
 *  LinkedHashSet (ordered)
 *  TreeSet (sorted by natural order or by provided comparator)
 *
 * A List is an ordered sequence of elements whereas
 *  ArrayList
 *  LinkedList
 *
 * Having most of the associations defined as LAZY requires us to use the “join fetch” JPQL operator
 *  and retrieve only the associations we need to fulfill a given request.
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {


    Set<User> findByUsername(String username);

    Set<User> findByEnable(Boolean enable);

    Set<User> findByAccountNonExpired(Boolean accountNonExpired);

    Set<User> findByEnableAndAccountNonExpired(Boolean enable, Boolean accountNonExpired);

    @Query("select u from User u " +
            "where u.enable = :enable " +
            "and u.accountNonExpired = :accountNonExpired ")
    Set<User> findQueryEnableAndAccountNonExpired(@Param("enable") Boolean enable, @Param("accountNonExpired") Boolean accountNonExpired);

    /**
     * for test:
     * https://www.w3schools.com/sql/sql_join.asp
     * https://www.dofactory.com/sql/join
     *
     * @param username
     * @return
     */
    @Query("SELECT u FROM User u " +
            "join fetch UserRole ur " + //2 for admin og 1 for user
            //"join UserRole ur " + //2 for admin og 1 for user
            //"INNER JOIN UserRole ur " + //2 for admin og 1 for user
            //"LEFT JOIN UserRole ur " + //2 for admin og 1 for user
            //"RIGHT JOIN UserRole ur " + //2 for admin og 1 for user
            "on u.userId=ur.userId " +
            "WHERE u.username=:username " +
            //"and ur.roleName='USER' " +
            "")
    public Set<User> findUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u join u.roles r WHERE u.username = :username and r.roleName='USER'")
    public List<User> findUser(@Param("username") String username);

    @Query("SELECT u FROM User u join u.roles r WHERE u.username = :username and r.roleName='ADMIN'")
    public List<User> findAdmin(@Param("username") String username);

}
