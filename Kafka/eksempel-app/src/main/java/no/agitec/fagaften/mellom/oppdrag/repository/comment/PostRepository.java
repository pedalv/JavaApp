package no.agitec.fagaften.mellom.oppdrag.repository.comment;

import no.agitec.fagaften.mellom.oppdrag.domain.comment.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
