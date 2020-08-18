package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Employee_Gen", sequenceName = "Employee_Gen",  initialValue = 1)
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "Employee_Gen")
    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    public Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

}
