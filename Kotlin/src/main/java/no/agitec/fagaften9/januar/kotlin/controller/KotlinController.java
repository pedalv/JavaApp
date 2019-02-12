package no.agitec.fagaften9.januar.kotlin.controller;

import no.agitec.fagaften9.januar.kotlin.help.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KotlinController {

    @GetMapping("/kotlin")
    public String home() {

        return Message.x();

    }


}
