package no.agitec.fagaften.eksempelapp.web.controller.rest;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
}


/*
    The @RestController annotation was introduced in Spring 4.0 to simplify the creation of RESTful web services.
        It's a convenience annotation that combines @Controller and @ResponseBody
        – which eliminates the need to annotate every request handling method of the controller class
            with the @ResponseBody annotation.
 */