package no.agitec.fagaften.mellom.oppdrag.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Company_Gen", sequenceName = "Company_Gen",  initialValue = 0)
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Company_Gen")
    private Long id;

    @Column(unique = true, updatable = false)
    private String name;

}
