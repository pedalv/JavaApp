package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "PostDetail_Gen", sequenceName = "PostDetail_Gen",  initialValue = 1)
public class PostDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "PostDetail_Gen")
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private String createdBy;

    //One PostDetail has one Post
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Post post;

    public PostDetail(String createdBy) {
        createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
    }

    public PostDetail(String createdBy, Post post) {
        this.createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
        this.post = post;
    }


    /*
    @Override
    public final String toString() {
        return "PEDRO-PostDetail";
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