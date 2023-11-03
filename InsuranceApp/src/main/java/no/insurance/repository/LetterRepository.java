package no.insurance.repository;

import no.insurance.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by p on 29/10/2016.
 */
public interface LetterRepository extends JpaRepository<Letter, Long> {

}
