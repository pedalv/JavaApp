package no.space.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by p on 19/11/2017.
 */
@RestController
public class HomeController {


    @RequestMapping("/")
    public String home() {

        return "Case coffee machine project for Spring Boot";

    }

}

