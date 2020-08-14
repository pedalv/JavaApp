package no.agitec.fagaften.mellom.oppdrag.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Product_Gen", sequenceName = "Product_Gen",  initialValue = 0)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Product_Gen")
    private Long id;

    private String name;

    @Column(updatable = false)
    private String code;

    private Integer quantity;

    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @ManyToOne(fetch = FetchType.EAGER)
    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", optional = false)
    private WarehouseProductInfo warehouseProductInfo;

    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "importer_id")
    private Importer importer;

    /**
     * Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    @OrderBy("index")
    private Set<Image> images = new LinkedHashSet<Image>();

    @Version
    private int version;

}








/*

    public Product(String name, String code, Integer quantity, Company company, WarehouseProductInfo warehouseProductInfo, Importer importer, Set<Image> images, int version) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.company = company;
        this.warehouseProductInfo = warehouseProductInfo;
        this.importer = importer;
        this.images = images;
        this.version = version;
    }

*/