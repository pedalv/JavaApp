package no.agitec.fagaften.mellom.oppdrag.domain.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Version_Gen", sequenceName = "Version_Gen",  initialValue = 1)
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Version_Gen")
    private Long id;

    @Column
    private String type;

    // Many Versions has one image
    @ManyToOne(fetch = FetchType.EAGER)
    private Image image;

    //One Version has many SubVersions
    @OneToMany(
            fetch = FetchType.EAGER, //LAZY: Unable to evaluate the expression Method threw 'org.hibernate.LazyInitializationException' exception.
            cascade = CascadeType.ALL,
            mappedBy = "version",
            orphanRemoval = true)
    //@JoinColumn(name = "version_id")
    private Set<SubVersion> subVersions = new LinkedHashSet<SubVersion>();

    public void addSubVersion(SubVersion subVersion) {
        subVersions.add(subVersion);
        //subVersion.setVersion(this);
    }

    public void removeSubVersion(SubVersion subVersion) {
        subVersions.remove(subVersion);
        //subVersion.setVersion(null);
    }
/*
    @Override
    public final String toString() {
        long p1 = this.getId();
        Image p2 = this.getImage(); //Method threw 'org.hibernate.LazyInitializationException' exception.
        Set<SubVersion> p3 = this.getSubVersions(); //Method threw 'org.hibernate.LazyInitializationException' exception.
        String p4 = this.getType(); //Method threw 'org.hibernate.LazyInitializationException' exception

        return "Pedro-Version";
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


/*
https://docs.jboss.org/hibernate/jpa/2.2/api/javax/persistence/OneToMany.html

CascadeType[]
cascade
(Optional) The operations that must be cascaded to the target of the association.

FetchType
fetch
(Optional) Whether the association should be lazily loaded or must be eagerly fetched.

mappedBy
The field that owns the relationship.
java.lang.String

boolean
orphanRemoval
(Optional) Whether to apply the remove operation to entities that have been removed from the relationship and to cascade the remove operation to those entities.

targetEntity
(Optional) The entity class that is the target of the association.
java.lang.Class

Defines the set of cascadable operations that are propagated to the associated entity.
The value cascade=ALL is equivalent to cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH}.
*/