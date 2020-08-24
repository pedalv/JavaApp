package no.agitec.fagaften.mellom.oppdrag.repository.comment;

import no.agitec.fagaften.mellom.oppdrag.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>  {

}
