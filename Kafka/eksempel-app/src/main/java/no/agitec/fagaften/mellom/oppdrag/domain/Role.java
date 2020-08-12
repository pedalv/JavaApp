package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long roleId;

    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

}
