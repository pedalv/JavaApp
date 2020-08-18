package no.agitec.fagaften.mellom.oppdrag.repository.comment;

import no.agitec.fagaften.mellom.oppdrag.domain.comment.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long>  {

}
