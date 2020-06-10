package no.agitec.fagaften.eksempelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Kafka {

    @GetMapping("/greeting")
    public String greeting( @RequestParam(name="name", required = false, defaultValue = "World") String name,
                            Model model) {

        model.addAttribute("name", name);
        return "greeting";
    }

    /*
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
*/
}
