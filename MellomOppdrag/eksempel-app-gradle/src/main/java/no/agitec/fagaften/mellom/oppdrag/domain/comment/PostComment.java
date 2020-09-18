package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "PostComment_Gen", sequenceName = "PostComment_Gen",  initialValue = 1)
public class PostComment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "PostComment_Gen")
    private Long id;

    private Long postId;

    private Long commentId;

    public PostComment(Long postId, Long commentId) {
        this.postId = postId;
        this.commentId = commentId;
    }

}

/*
OneToOne    - Detail    - @OneToOne: One Detail has one Post - save in database automatic Post, Comment n
OneToMany   - Post      - @OneToMany: One Post has many Comments
ManyToMany  - Post      - @ManyToMany: Many Posts has many Tags


Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
 */
