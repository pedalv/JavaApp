package no.agitec.fagaften.mellom.oppdrag.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Importer_Gen", sequenceName = "Importer_Gen",  initialValue = 1)
public class Importer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Importer_Gen")
    private Long id;

    private String name;

    public Importer(String name) {
        this.name = name;
    }
}
