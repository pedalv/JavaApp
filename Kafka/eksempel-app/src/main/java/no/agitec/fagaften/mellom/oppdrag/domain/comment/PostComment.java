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

    private String review;

    // Many PostComments has one Post
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public PostComment(String review, Post post) {
        this.review = review;
        this.post = post;
    }

    public PostComment(String review) {
        this.review = review;
    }

}

/*
OneToMany   - Post
ManyToOne   - PostComment
OneToOne    - PostDetail
ManyToMany  - PostTag

Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations

 */