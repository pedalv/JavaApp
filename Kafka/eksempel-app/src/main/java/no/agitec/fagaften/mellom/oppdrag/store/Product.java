package no.agitec.fagaften.mellom.oppdrag.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import no.agitec.fagaften.mellom.oppdrag.domain.Role;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * https://vladmihalcea.com/hibernate-facts-the-importance-of-fetch-strategy/
 */
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

    @Version
    private Integer version;

    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @ManyToOne(fetch = FetchType.EAGER)
    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false) //company_id
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
    @JoinColumn(name = "importer_id") //importer_id
    private Importer importer;

    /**
     * Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
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


    public Product(String code, String name, int quantity, int version) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.version = version;
    }

}
