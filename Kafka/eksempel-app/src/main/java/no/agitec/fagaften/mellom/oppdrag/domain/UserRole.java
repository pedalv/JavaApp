package no.agitec.fagaften.mellom.oppdrag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "UserRole_Gen", sequenceName = "UserRole_Gen",  initialValue = 0)
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "UserRole_Gen")
    private Long id = 0L;

    private Long userId = 0L;

    private Long roleId = 0L;

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

}
