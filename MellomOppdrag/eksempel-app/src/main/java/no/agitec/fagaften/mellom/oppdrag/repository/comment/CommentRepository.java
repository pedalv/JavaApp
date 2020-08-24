package no.agitec.fagaften.mellom.oppdrag.repository.comment;

import no.agitec.fagaften.mellom.oppdrag.domain.comment.Comment;
import no.agitec.fagaften.mellom.oppdrag.domain.comment.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long>  {


    Optional<Comment> findByPost(Post post);

    @Query("select c from Comment c " +
            "where c.post.id = :id ")
    List<Comment> findQueryPostId(@Param("id") Long id);


}
