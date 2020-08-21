package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Customer_Gen", sequenceName = "Customer_Gen",  initialValue = 1)
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Customer_Gen")
    private Long id;

    private String name;

    private String project;

    public Customer(String name, String project) {
        this.name = name;
        this.project = project;
    }

}
