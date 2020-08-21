package no.agitec.fagaften.mellom.oppdrag.web.controller;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ModelAttribute
    public void addEmployeeModel(Model model) {
        log.info("== addEmployeeModel");
        //model.addAttribute("employees", new ArrayList<Employee>());
        model.addAttribute("employees", employeeService.all());
        model.addAttribute("name", "Employee");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainEmployee() {
        return "employee";
    }

}
