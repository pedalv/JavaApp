package no.agitec.fagaften.mellom.oppdrag.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Partner_Gen", sequenceName = "Partner_Gen",  initialValue = 1)
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Partner_Gen")
    private Long id;

    private String name;

    public Partner(String firstName) {
        this.name = firstName;
    }
}
