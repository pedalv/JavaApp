package no.agitec.fagaften.eksempelapp.web.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.eksempelapp.common.EmployeeResponseEntityBuilder;
import no.agitec.fagaften.eksempelapp.domain.Employee;
import no.agitec.fagaften.eksempelapp.exception.EmployeeNotFoundException;
import no.agitec.fagaften.eksempelapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employee")
@Slf4j
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController( EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    // All items

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<?>  all() {
        List<Employee> employees = employeeService.all();
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(employees));
        } catch (JsonProcessingException e) {
            return new EmployeeResponseEntityBuilder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("An error occurred while retrieving all employees about " + e.getMessage())
                    .build();
        }
    }

    // Add item

    @PostMapping(path = "/created", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<?> create(@RequestBody Employee newEmployee) {

        //Check mandatory parameters

        Employee saved = employeeService.create(newEmployee);
        if(null == saved) {
            return new EmployeeResponseEntityBuilder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Feil to create employee")
                    .build();
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(saved, responseHeaders, HttpStatus.CREATED);
    }

    // Single item

    @GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<?> fetch(@PathVariable Long id) {

        if(id == null || id <= 0) {
            return new EmployeeResponseEntityBuilder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message("ID must have a value")
                    .build();
        }

        Optional<Employee> employee = employeeService.fetch(id);
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
    }

    // Update item

    @PutMapping("/employees/{id}")
    public  ResponseEntity<?> replaceEmployee(
            @PathVariable Long id,
            @RequestHeader(value = "exempel-version") Long version,
            @RequestBody Employee replaceEmployee) {

        //If Employee not exist will create

        Employee replaced = employeeService.replace(id, version, replaceEmployee);
        if(null == replaced) {
            return new EmployeeResponseEntityBuilder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Feil replaced employee ID " + id)
                    .build();
        }

        return ResponseEntity.noContent().build();
    }

    //Delete item

    @DeleteMapping("/employees/{id}")
    public Boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.hasDelete(id);
    }
}


/*
    The @RestController annotation was introduced in Spring 4.0 to simplify the creation of RESTful web services.
        It's a convenience annotation that combines @Controller and @ResponseBody
        – which eliminates the need to annotate every request handling method of the controller class
            with the @ResponseBody annotation.


    PUT overwrites the entire entity if it already exists, and creates a new resource if it doesn’t exist.

    PATCH need only required data to update.
 */