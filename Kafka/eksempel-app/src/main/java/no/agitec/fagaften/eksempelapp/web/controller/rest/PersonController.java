package no.agitec.fagaften.eksempelapp.web.controller.rest;

import no.agitec.fagaften.eksempelapp.domain.Person;
import no.agitec.fagaften.eksempelapp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        model.addAttribute("persons", personService.hentPersons());
        model.addAttribute("name", "Pedro");
    }

    @GetMapping()
    public String mainPerson() {
        return "person";
    }

    @GetMapping(path = "/hentPerson")
    @ResponseBody
    public /*ResponseEntity<Person>*/ List<Person> hentPersoner() {
        return personService.hentPersons();
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        p = personService.createPerson(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

}

 /*
    - accept application/json ( @Consumes ) and
    - return text/plain ( @Produces )
 */
