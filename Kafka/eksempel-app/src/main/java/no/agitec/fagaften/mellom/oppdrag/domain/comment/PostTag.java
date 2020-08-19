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

    @NaturalId
    private String name;

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

}

/*
OneToMany   - Post          - @OneToMany: One Post has many PostComments
ManyToOne   - PostComment   - @ManyToOne: Many PostComments has one Post
OneToOne    - PostDetail    - @OneToOne: One PostDetail has one Post - save in database automatic Post, PostComment n
ManyToMany  - PostTag       - @ManyToMany: Many PostTag has many Post (Post can belong to same TAG)

Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations

 */