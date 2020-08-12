package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "Role_Gen", sequenceName = "Role_Gen",  initialValue = 0)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Role_Gen")
    private Long roleId;

    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

}
