package no.agitec.fagaften.mellom.oppdrag.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "posts")
    @ElementCollection
    //private Set<Post> posts = new HashSet<>();
    private Set<Post> posts = new LinkedHashSet<>();

    public PostTag(String name, Set<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

}
