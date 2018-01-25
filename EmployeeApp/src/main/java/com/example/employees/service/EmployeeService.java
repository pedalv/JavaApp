package com.example.employees.service;

import com.example.employees.model.Employee;
import com.example.employees.model.EmployeeList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by p on 08/09/2016.
 */
public class EmployeeService {

    List<Employee> employeeList = EmployeeList.getInstance();

    //Get all employees.
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    //Get all employees whose Name or Last Name match the searchParam, order by name and last name.
    public List<Employee> searchEmployeesByName(String searchParam) {

        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getLastName);

        List<Employee> result = employeeList
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(searchParam) ||
                        e.getLastName().equalsIgnoreCase(searchParam))
                .sorted(groupByComparator)
                .collect(Collectors.toList());

        return result;
    }

    //Get the employee by id
    public Employee getEmployee(long id) throws Exception {

        Optional<Employee> match = employeeList
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Employee id " + id + " not found");
        }
    }

    //Add employee
    public long addEmployee(Employee employee) {

        employeeList.add(employee);
        return employee.getId();

    }

    //Update employee
    public boolean updateEmployee(Employee customer) {

        int matchIdx = 0;

        Optional<Employee> match = employeeList
                .stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();

        if (match.isPresent()) {
            matchIdx = employeeList.indexOf(match.get());
            employeeList.set(matchIdx, customer);
            return true;
        } else {
            return false;
        }
    }

    //Delete employee
    public boolean deleteEmployee(long id) {

        Predicate<Employee> employee = e -> e.getId() == id;

        if (employeeList.removeIf(employee)) {
            return true;
        } else {
            return false;
        }
    }

}
