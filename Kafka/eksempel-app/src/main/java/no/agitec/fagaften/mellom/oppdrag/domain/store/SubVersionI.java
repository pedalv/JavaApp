package no.agitec.fagaften.mellom.oppdrag.domain.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "SubVersion_Gen", sequenceName = "SubVersion_Gen",  initialValue = 1)
public class SubVersionI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SubVersion_Gen")
    private Long id;

    private String code;

    //Many SubVersionI has a version
    @ManyToOne(fetch = FetchType.EAGER)
    private Version version;
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