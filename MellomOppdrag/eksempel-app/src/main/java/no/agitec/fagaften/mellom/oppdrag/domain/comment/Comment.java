package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Comment_Gen", sequenceName = "Comment_Gen",  initialValue = 1)
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Comment_Gen")
    private Long id;

    private String review;

    //private Long postId;

    // Many Comments has one Post
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Comment(String review, Post post) {
        this.review = review;
        this.post = post;
    }

    public Comment(String review) {
        this.review = review;
    }
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
