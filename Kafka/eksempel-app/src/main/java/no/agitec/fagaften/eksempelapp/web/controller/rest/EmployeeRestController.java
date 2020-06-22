package no.agitec.fagaften.eksempelapp.web.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.eksempelapp.common.EmployeeResponseEntityBuilder;
import no.agitec.fagaften.eksempelapp.domain.Employee;
import no.agitec.fagaften.eksempelapp.repository.EmployeeRepository;
import no.agitec.fagaften.eksempelapp.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TODO Service, PRoduct , objectreturn

@RestController
@RequestMapping("api/employee")
@Slf4j
public class EmployeeRestController {

    private final EmployeeRepository repository;
    private final ObjectMapper objectMapper;


    public EmployeeRestController(EmployeeRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    // Aggregate root

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<Employee>> /*List<Employee>*/ all() {
        List<Employee> employees = repository.findAll(); //TODO SERVICE
        return new ResponseEntity<>(employees, HttpStatus.OK);
        //return repository.findAll();
    }

    @PostMapping("/created")
    public  ResponseEntity<?> /*Employee*/ create(@RequestBody Employee newEmployee) {
        Employee saved = repository.save(newEmployee); //TODO SERVICE
        if(null == saved) {
            return new EmployeeResponseEntityBuilder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Feil create employee")
                    .build();
            //return new ResponseEntity<>("Feil create employee", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

        //return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    public  ResponseEntity<?>  /*Employee*/ fetchEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = repository.findById(id); //TODO SERVICE
        if(employee.isPresent()) {
            try {
                return ResponseEntity.ok(objectMapper.writeValueAsString(employee.get()));
            } catch (JsonProcessingException e) {
                return new EmployeeResponseEntityBuilder()
                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message("An error occurred while retrieving employee with ID " + id + " about " + e.getMessage())
                        .build();
            }
        }

        return new EmployeeResponseEntityBuilder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(new EmployeeNotFoundException(id).getMessage())
                .build();

        //return repository.findById(id)
        //      .orElseThrow(() -> new EmployeeNotFoundException(id));

    }

    @PutMapping("/employees/{id}")
    public  ResponseEntity<?> /*Employee*/ replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        Employee replaced = repository.findById(id) //TODO SERVICE
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });

        if(null == replaced) {
            return new EmployeeResponseEntityBuilder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Feil replaced employee")
                    .build();
            //return new ResponseEntity<>("Feil replaced employee", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(replaced, HttpStatus.OK);

        //return replaced;
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}


/*
    The @RestController annotation was introduced in Spring 4.0 to simplify the creation of RESTful web services.
        It's a convenience annotation that combines @Controller and @ResponseBody
        – which eliminates the need to annotate every request handling method of the controller class
            with the @ResponseBody annotation.
 */