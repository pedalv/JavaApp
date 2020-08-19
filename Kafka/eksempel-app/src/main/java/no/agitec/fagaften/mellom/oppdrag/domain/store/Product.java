package no.agitec.fagaften.mellom.oppdrag.domain.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Version;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Product_Gen", sequenceName = "Product_Gen",  initialValue = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Product_Gen")
    private Long id;

    private String name;

    @Column(updatable = false)
    private String code;

    private Integer quantity;

    @Version
    private Integer version;
    //private int version;

    //Many Products has a company
    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @ManyToOne(fetch = FetchType.EAGER)
    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false) //company_id
    private Company company;

    // One Product has a warehouseProductInfo
    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "product",
            optional = false)
    private WarehouseProductInfo warehouseProductInfo;

    //Many Products has a importer
    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "importer_id") //importer_id
    private Importer importer;

    //One Product has many images
    /**
     * Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
     * Most of the associations are marked as LAZY because there is no need to fetch all of them every time we load a Product.
     * The warehouse is only needed when displaying the stock information.
     * The Importer is used in certain displays only, and we will fetch it when necessary.
     * The images are lazy since not all views require displaying those images.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    @OrderBy("index")
    private Set<Image> images = new LinkedHashSet<Image>();

    /**
     * Caused by: org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: NULL not allowed for column "COMPANY_ID"; SQL statement:
     * insert into product (code, company_id, importer_id, name, quantity, version, id) values (?, ?, ?, ?, ?, ?, ?) [23502-200]
     */
    public Product(String code, Company company, Importer importer, String name, int quantity, int version) {
        this.code = code;
        this.company = company;
        this.importer = importer;
        this.name = name;
        this.quantity = quantity;
        this.version = version;
    }

    public Product(String code) {
        this.code = code;
    }

    public Product(String code, String name, int quantity, int version) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.version = version;
    }

    public void addImage(Image image) {
        images.add(image);
        image.setProduct(this);
    }

    public void removeImage(Image image) {
        images.remove(image);
        image.setProduct(null);
    }

    public void addWarehouse(WarehouseProductInfo warehouseProductInfo) {
        warehouseProductInfo.setProduct(this);
        this.setWarehouseProductInfo(warehouseProductInfo);
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
