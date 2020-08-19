package no.agitec.fagaften.mellom.oppdrag.domain.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "WarehouseProductInfo_Gen", sequenceName = "WarehouseProductInfo_Gen",  initialValue = 1)
public class WarehouseProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "WarehouseProductInfo_Gen")
    private Long id;

    private Integer quantity;

    // One WarehouseProductInfos has a product
    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    //Caused by: org.hibernate.LazyInitializationException: could not initialize proxy [no.agitec.fagaften.mellom.oppdrag.store.WarehouseProductInfo#0] - no Session
    //@OneToOne(fetch = FetchType.LAZY)
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Product product;


    public WarehouseProductInfo(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public WarehouseProductInfo(Integer quantity) {
        this.quantity = quantity;
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
