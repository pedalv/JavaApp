package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 *  Tutorial Relationship in JPA:
 *  https://www.baeldung.com/jpa-many-to-many
 *  https://vladmihalcea.com/database-table-relationships/
 *  https://stackoverflow.com/questions/3113885/difference-between-one-to-many-many-to-one-and-many-to-many
 *
 *
 *
 *  Note:
 *  A Set is a collection of well defined and distinct objects.
 *  HashSet (unordered)
 *  LinkedHashSet (ordered)
 *  TreeSet (sorted by natural order or by provided comparator)
 *
 *  A List is an ordered sequence of elements whereas
 *  ArrayList
 *  LinkedList
 *
 *  -
 *  HashMap (key,value) - Duplicate keys are not allowed - no maintains order
 *  TreeMap                --//--                        - maintains order
 *
 *  http://javainfinite.com/java/hashmap-hashset-hashtable/
 */
@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "PostTag_Gen", sequenceName = "PostTag_Gen",  initialValue = 1)
public class PostTag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "PostTag_Gen")
    private Long id;

    private Long postId;

    private Long tagId;

    public PostTag(Long postId, Long tagId) {
        this.postId = postId;
        this.tagId = tagId;
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




/* OLD SOLUTION
    //Many PostTag has many Post
    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "tagposts")
    @ElementCollection
    private Set<Post> posts = new HashSet<>();
    //private Set<Post> posts2 = new LinkedHashSet<>();

    public PostTag(String name, Set<Post> posts) {
        this.name = name;
        this.posts = posts;
    }
*/
