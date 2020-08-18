package no.agitec.fagaften.mellom.oppdrag.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "WarehouseProductInfo_Gen", sequenceName = "WarehouseProductInfo_Gen",  initialValue = 0)
public class WarehouseProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "WarehouseProductInfo_Gen")
    private Long id;

    private Integer quantity;

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

}
