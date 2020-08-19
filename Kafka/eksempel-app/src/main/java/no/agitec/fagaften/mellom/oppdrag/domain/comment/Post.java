package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Post_Gen", sequenceName = "Post_Gen",  initialValue = 1)
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Post_Gen")
    private Long id;

    private String title;

    // One Post has many PostComments
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostComment> comments = new ArrayList<>();


    public Post(String title) {
        this.title = title;
    }

    public void addComment(PostComment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }

}

/*
OneToMany   - Post          - @OneToMany: One Post has many PostComments
ManyToOne   - PostComment   - @ManyToOne: Many PostComments has one Post
OneToOne    - PostDetail    - @OneToOne: One PostDetail has one Post - save in database automatic Post, PostComment n
ManyToMany  - PostTag       - @ManyToMany: Many PostTag has many Post (Post can belong to same TAG)

Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations

 */