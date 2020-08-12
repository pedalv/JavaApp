package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Customer_Gen", sequenceName = "Customer_Gen",  initialValue = 0)
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
