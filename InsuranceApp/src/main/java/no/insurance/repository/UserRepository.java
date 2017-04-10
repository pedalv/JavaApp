package no.insurance.repository;

import no.insurance.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by p on 22/10/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
