package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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

    private String content;

    // One Post has many PostComments
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostComment> comments = new ArrayList<>();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addComment(PostComment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }

/*
    @Override
    public final String toString() {
        long ID = this.getId();
        //String CONTENT = this.getContent(); //Method threw 'org.hibernate.LazyInitializationException' exception.
        //List<PostComment> COMMENTS = this.getComments(); //Method threw 'org.hibernate.LazyInitializationException' exception.

        String str = "";
        for (PostComment pc : this.getComments()) {
            str += "PostComment(id="+pc.getId()+", review="+pc.getReview()+", post="+pc.getPost()+")";
            System.out.println(str);
        }

        return "Post(id=" + this.getId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", comments=[["+str+"]])";
        //return "Post(id="+this.id+", title="+"this.content"+", comments=[["+ "this.getComments()" +"]])";
        //return "Post(id="+this.id+", title="+"this.content"+", comments=["+ "this.getComments()"+"])";
        //return "PEDRO-Post";

        //return "Post(id=1, title=title, content=content, comments=[PostComment(id=1, review=review1, post=null),PostComment(id=2, review=review2, post=null)])";
    }
 */
}

/*
OneToMany   - Post          - @OneToMany: One Post has many PostComments
ManyToOne   - PostComment   - @ManyToOne: Many PostComments has one Post
OneToOne    - PostDetail    - @OneToOne: One PostDetail has one Post - save in database automatic Post, PostComment n
ManyToMany  - PostTag       - @ManyToMany: Many PostTag has many Post (Post can belong to same TAG)

Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations

 */