package no.agitec.fagaften.eksempelapp.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Employee with id " + id + " was not found!");
    }

}
