package no.agitec.fagaften.mellom.oppdrag.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Image_Gen", sequenceName = "Image_Gen",  initialValue = 1)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Image_Gen")
    private Long id;

    @Column(updatable = false)
    private String name;

    /**
     * public @interface Column {
     *     java.lang.String name() default "";
     *
     *     boolean unique() default false;
     *
     *     boolean nullable() default true;
     *
     *     boolean insertable() default true;
     *
     *     boolean updatable() default true;
     *
     *     java.lang.String columnDefinition() default "";
     *
     *     java.lang.String table() default "";
     *
     *     int length() default 255;
     *
     *     int precision() default 0;
     *
     *     int scale() default 0;
     * }
     */
    @Column(unique = true)
    private Integer index;

    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    //Caused by: org.hibernate.MappingException: Could not determine type for: javax.persistence.Version, at table: image_versions, for columns: [org.hibernate.mapping.Column(versions)]
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "image", orphanRemoval = true)
    //@ElementCollection
    //@OrderBy("type")
    //private Set<Version> versions = new LinkedHashSet<Version>();

    // https://stackoverflow.com/questions/6164123/org-hibernate-mappingexception-could-not-determine-type-for-java-util-set
    // https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/order-by-annotation.html
    // http://www.mauda.com.br/?p=1438 // Caused by: org.hibernate.AnnotationException: Use of @OneToMany or @ManyToMany targeting an unmapped class
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "image", orphanRemoval = true)
    @ElementCollection
    @OrderBy
    private Set<Long> versions = new LinkedHashSet<>();

    public Image(String name, int index, Product product, Set<Long> versions) {
        this.name = name;
        this.index = index;
        this.product = product;
        this.versions = versions;
    }
}



