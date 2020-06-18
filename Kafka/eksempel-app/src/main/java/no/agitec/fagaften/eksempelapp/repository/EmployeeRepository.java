package no.agitec.fagaften.eksempelapp.repository;

import no.agitec.fagaften.eksempelapp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
