package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Detail_Gen", sequenceName = "Detail_Gen",  initialValue = 1)
public class Detail {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Detail_Gen")
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private String createdBy;

    //One Detail has one Post
    @OneToOne(fetch = FetchType.EAGER) // .LAZY: //Method threw 'org.hibernate.LazyInitializationException' exception. Cannot evaluate no.agitec.fagaften.mellom.oppdrag.domain.comment.Detail.toString()
    @MapsId
    @JoinColumn(name = "id")
    private Post post;

    public Detail(String createdBy) {
        createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
    }

    public Detail(String createdBy, Post post) {
        this.createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
        this.post = post;
    }


    /*
    @Override
    public final String toString() {
        return "PEDRO-Detail";
    }
     */

}

/*
OneToOne    - Detail    - @OneToOne: One Detail has one Post - save in database automatic Post, Comment n
OneToMany   - Post      - @OneToMany: One Post has many Comments
ManyToMany  - Post      - @ManyToMany: Many Posts has many Tags


Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
 */

