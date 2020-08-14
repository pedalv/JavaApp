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

    private int quantity;

    /**
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotations
     */
    @OneToOne(fetch = FetchType.LAZY)
    //@OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Product product;

}
