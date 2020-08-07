package no.agitec.fagaften.mellom.oppdrag.repository;

import no.agitec.fagaften.mellom.oppdrag.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
