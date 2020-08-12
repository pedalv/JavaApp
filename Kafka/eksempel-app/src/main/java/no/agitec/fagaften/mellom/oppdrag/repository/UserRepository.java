package no.agitec.fagaften.mellom.oppdrag.repository;

import no.agitec.fagaften.mellom.oppdrag.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
