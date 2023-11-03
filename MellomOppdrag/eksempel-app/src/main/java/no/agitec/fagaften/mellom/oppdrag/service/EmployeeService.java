package no.agitec.fagaften.mellom.oppdrag.service;

import no.agitec.fagaften.mellom.oppdrag.domain.Employee;
import no.agitec.fagaften.mellom.oppdrag.exception.EmployeeNotFoundException;
import no.agitec.fagaften.mellom.oppdrag.repository.EmployeeRepository;
import no.agitec.fagaften.mellom.oppdrag.exception.OptimisticLeasingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public List<Employee> all(){
        List<Employee> result = new ArrayList<>(employeeRepository.findAll());
        return result;
    }

    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Transactional
    public Optional<Employee> fetch(Long id) {

        return Optional.ofNullable(
                employeeRepository
                        .findById(id)
                        .orElseThrow(() -> new EmployeeNotFoundException(id))
        );

    }

    @Transactional
    public Boolean hasDelete(Long id) {
        employeeRepository.deleteById(id);

        Optional<Employee> deleted = employeeRepository.findById(id);
        return deleted.isEmpty();
    }

    @Transactional
    public Employee replace(Long id, Employee replaceEmployee) {

        //OutputType result = yourOptional.map(yourConsumer).orElseGet(yourRunnable);
        Employee replaced = employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(replaceEmployee.getFirstName());
                    employee.setLastName(replaceEmployee.getLastName());
                    employee.setRole(replaceEmployee.getRole());
                    return employee;
                })
                .orElseGet(() -> {
                    replaceEmployee.setId(id);
                    return replaceEmployee;
                });

        return employeeRepository.save(replaced);
    }

    @Transactional
    public Employee replace(Long id, Long version, Employee replaceEmployee) {

        //OutputType result = yourOptional.map(yourConsumer).orElseGet(yourRunnable);
        Employee replaced = employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(replaceEmployee.getFirstName());
                    employee.setLastName(replaceEmployee.getLastName());
                    employee.setRole(replaceEmployee.getRole());
                    return employee;
                })
                .orElseGet(() -> {
                    replaceEmployee.setId(id);
                    return replaceEmployee;
                });

        if (!version.equals(replaced.getId())) {
            throw new OptimisticLeasingException("Det var oppgitt version " + version + ", men gjeldende version på employee er " + replaced.getId());
        }

        return employeeRepository.save(replaced);
    }

}
