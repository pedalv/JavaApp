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
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "version", orphanRemoval = true)
    private Set<SubVersion> subVersions = new LinkedHashSet<SubVersion>();

    public void addSubVersion(SubVersion subVersion) {
        subVersions.add(subVersion);
        //subVersion.setVersion(this);
    }

    public void removeSubVersion(SubVersion subVersion) {
        subVersions.remove(subVersion);
        //subVersion.setVersion(null);
    }

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
