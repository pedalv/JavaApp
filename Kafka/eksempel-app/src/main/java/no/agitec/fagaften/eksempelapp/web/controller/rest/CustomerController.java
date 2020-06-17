package no.agitec.fagaften.eksempelapp.web.controller.rest;

import no.agitec.fagaften.eksempelapp.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ModelAttribute
    public void addCustomerModel(Model model) {
        model.addAttribute("customers", customerService.hentCustomer());
        model.addAttribute("name", "NAV");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainCustomer() {
        return "customer";
    }

}
