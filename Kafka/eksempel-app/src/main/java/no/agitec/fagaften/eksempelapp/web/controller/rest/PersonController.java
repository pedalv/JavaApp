package no.agitec.fagaften.eksempelapp.web.controller.rest;

import no.agitec.fagaften.eksempelapp.domain.Person;
import no.agitec.fagaften.eksempelapp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/person")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ModelAttribute
    public void addPersonModel(Model model) {
        model.addAttribute("persons", personService.hentPersoner());
        model.addAttribute("name", "Pedro");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPerson() {
        return "person";
    }

    @RequestMapping(value = "/hent", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> hentPersoner() {
        return personService.hentPersoner();
    }

}
