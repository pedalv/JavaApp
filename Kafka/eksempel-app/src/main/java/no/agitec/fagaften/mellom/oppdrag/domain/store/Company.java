package no.agitec.fagaften.mellom.oppdrag.domain.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Tutorial Relationship in JPA:
 * https://vladmihalcea.com/hibernate-facts-the-importance-of-fetch-strategy/
 * https://github.com/vladmihalcea/vladmihalcea.wordpress.com/tree/master/hibernate-facts
 * https://github.com/vladmihalcea/vladmihalcea.wordpress.com/tree/master/hibernate-facts/src/main/java/com/vladmihalcea/hibernate/model/store
 *
 *
 *
 */
@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Company_Gen", sequenceName = "Company_Gen",  initialValue = 1)
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Company_Gen")
    private Long id;

    @Column(unique = true, updatable = false)
    private String name;

    public Company(String name) {
        this.name = name;
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
