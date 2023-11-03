package no.agitec.fagaften.mellom.oppdrag.domain.store;

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
    //private int index;

    //Many Image has a product
    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    //One Image has many versions
    @OneToMany(
            fetch = FetchType.EAGER, //.LAZY: Unable to evaluate the expression Method threw 'org.hibernate.LazyInitializationException' exception.
            cascade = CascadeType.ALL,
            mappedBy = "image",
            orphanRemoval = true)
    @ElementCollection
    @OrderBy("type")
    //@JoinColumn(name = "image_id")
    private Set<Version> versions = new LinkedHashSet<Version>();

    public Image(String name, int index, Product product, Set<Version> versions) {
        this.name = name;
        this.index = index;
        this.product = product;
        this.versions = versions;
    }

    public Image(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public void addVersion(Version version) {
        versions.add(version);
        //version.setImage(this);
    }

    public void removeVersion(Version version) {
        versions.remove(version);
        //version.setImage(null);
    }

/*
    @Override
    public final String toString() {
        long p1 = this.getId();
        Product p2 = this.getProduct();
        String p3 = this.getName();
        Integer p4 = this.getIndex();
        Set<Version> p5 = this.getVersions(); //Method threw 'org.hibernate.LazyInitializationException' exception.

        return "Pedro-Image";
    }
*/
}

/*
OneToMany   - Product               - @OneToMany: One Product has many images
            - Image                 - @OneToMany: One Image has many versions
            - VersionI              - OneToMany: One Version has many SubVersions
ManyToOne   - Product               - @ManyToOne: Many Products has a company
                                    - @ManyToOne: Many Products has a importer
            - Image                 - @ManyToOne: Many Images has a product
            - SubVersionI           - @ManyToOne: Many SubVersionI has a version
            - VersionI              - @ManyToOne: Many Versions has one image
OneToOne    - Product               - @OneToOne: One Product has a warehouseProductInfo
            - WarehouseProductInfo  - @OneToOne: One WarehouseProductInfos has a product
ManyToMany  - none

Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation

Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations

 */



