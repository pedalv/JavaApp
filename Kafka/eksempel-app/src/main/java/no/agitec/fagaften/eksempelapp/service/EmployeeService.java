package no.agitec.fagaften.eksempelapp.service;

import no.agitec.fagaften.eksempelapp.domain.Employee;
import no.agitec.fagaften.eksempelapp.exception.EmployeeNotFoundException;
import no.agitec.fagaften.eksempelapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import no.agitec.fagaften.eksempelapp.exception.OptimisticLeasingException;

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
        return employeeRepository.save(employee);
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
