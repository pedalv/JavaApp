package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Tag_Gen", sequenceName = "Tag_Gen",  initialValue = 1)

public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Tag_Gen")
    private Long id;

    @NaturalId
    private String name;

    //USE THIS SOLUTION TO SHOW COMMENTS (post_id)
    //Many Tags has many Posts
    //@ManyToMany(mappedBy = "tags")
    //private Set<Post> posts = new HashSet<>();

    public Tag(String name) {
        this.name = name;
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
