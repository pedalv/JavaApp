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

/*
 @RequestMapping(method = RequestMethod.GET, value = "/" , path = "/", name = "", produces = "", consumes = "", headers = "" , params = )

public @interface RequestMapping {
    java.lang.String name() default "";

    - value === path
    @org.springframework.core.annotation.AliasFor("path")
    java.lang.String[] value() default {};

    @org.springframework.core.annotation.AliasFor("value")
    java.lang.String[] path() default {};


    org.springframework.web.bind.annotation.RequestMethod[] method() default {};

    java.lang.String[] params() default {};

    java.lang.String[] headers() default {};

    - accept application/json ( @Consumes ) and
    java.lang.String[] consumes() default {};

    - return text/plain ( @Produces )
    java.lang.String[] produces() default {};
}
 */