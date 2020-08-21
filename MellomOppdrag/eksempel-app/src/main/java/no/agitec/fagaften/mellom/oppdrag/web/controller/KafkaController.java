package no.agitec.fagaften.mellom.oppdrag.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class KafkaController {

    @GetMapping("/greeting")
    public String greeting( @RequestParam(name="name", required = false, defaultValue = "Kafka") String name,
                            Model model) {

        log.info("== KafkaController greeting");
        model.addAttribute("name", name);
        return "greeting";
    }

}
