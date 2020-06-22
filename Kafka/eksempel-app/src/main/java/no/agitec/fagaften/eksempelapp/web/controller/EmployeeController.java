package no.agitec.fagaften.eksempelapp.web.controller;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.eksempelapp.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @ModelAttribute
    public void addEmployeeModel(Model model) {
        log.info("== addEmployeeModel");
        model.addAttribute("employees", new ArrayList<Employee>()); //TODO SERVICE
        model.addAttribute("name", "Employee");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainEmployee() {
        return "employee";
    }

}
