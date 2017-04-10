package no.das.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by p on 12/09/2016.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {

        return "Das Boot, reporting for duty!";
    }
}
