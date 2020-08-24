package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // One Post has many Comments
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true //To remove child also
    )
    //@JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<>();


    //Many Posts has many Tags
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(name = "PostTag",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "tagId")
    )
    private Set<Tag> tags = new HashSet<>();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }

    /* USE SAME SOLUTION FOR COMMENTS
    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getPosts().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }
    */

/*
    @Override
    public final String toString() {
        long ID = this.getId();
        //String CONTENT = this.getContent(); //Method threw 'org.hibernate.LazyInitializationException' exception.
        //List<Comment> COMMENTS = this.getComments(); //Method threw 'org.hibernate.LazyInitializationException' exception.

        String str = "";
        for (Comment pc : this.getComments()) {
            str += "Comment(id="+pc.getId()+", review="+pc.getReview()+", post="+pc.getPost()+")";
            System.out.println(str);
        }

        return "Post(id=" + this.getId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", comments=[["+str+"]])";
        //return "Post(id="+this.id+", title="+"this.content"+", comments=[["+ "this.getComments()" +"]])";
        //return "Post(id="+this.id+", title="+"this.content"+", comments=["+ "this.getComments()"+"])";
        //return "PEDRO-Post";

        //return "Post(id=1, title=title, content=content, comments=[Comment(id=1, review=review1, post=null),Comment(id=2, review=review2, post=null)])";
    }
 */
}

/*
OneToMany   - Post          - @OneToMany: One Post has many Comments
ManyToOne   - Comment   - @ManyToOne: Many Comments has one Post
OneToOne    - Detail    - @OneToOne: One Detail has one Post - save in database automatic Post, Comment n
ManyToMany  - Tag           - @ManyToMany: Many Tags has many Posts
            - Post          - @ManyToMany: Many Posts has many Tags

Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
 */


/*
one-to-many is the most common relationship, and it associates a row from a parent table (Post) to multiple rows in a child table (Comment).
    //Post - @OneToMany: One Post has many Comments
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true //To remove child also
    )
    //@JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<>();


one-to-one requires the child table Primary Key (Detail) to be associated via a Foreign Key with the parent table Primary Key column (Post).
    //Detail - @OneToOne: One Detail has one Post - save in database automatic Post, Comment n
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "id")
    private Post post;

many-to-many requires a link table containing two Foreign Key columns that reference the two different parent tables.
    //PostTag - @ManyToMany: Many PostTag has many Post (Post can belong to same TAG)
    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "tagposts")
    @ElementCollection
    private Set<Post> posts = new HashSet<>();

    //Role - @ManyToMany: Many users has many roles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    List<Role> roles;

 */