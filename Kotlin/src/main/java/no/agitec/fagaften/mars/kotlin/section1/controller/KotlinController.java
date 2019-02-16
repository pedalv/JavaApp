package no.agitec.fagaften.mars.kotlin.section1.controller;

import no.agitec.fagaften.mars.kotlin.section1.help.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KotlinController {

    @GetMapping("/kotlin")
    public String home() {

        return Message.x();

    }


}
