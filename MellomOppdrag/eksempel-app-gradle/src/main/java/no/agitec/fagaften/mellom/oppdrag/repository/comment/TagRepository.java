package no.agitec.fagaften.mellom.oppdrag.repository.comment;

import no.agitec.fagaften.mellom.oppdrag.domain.comment.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

}
