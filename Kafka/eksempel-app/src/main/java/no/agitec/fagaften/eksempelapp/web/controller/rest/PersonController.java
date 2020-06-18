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

//@RestController
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
    public /*ResponseEntity<List<Person>>*/ List<Person> hentPersons() {
        return personService.hentPersons();
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Person> createPerson( @RequestParam String name,
                                                @RequestParam int age) {
        Person p = new Person(name, age);
        p = personService.createPerson(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

}


 /*
     - "/save/id" -> @PathVariable(value = "id") long id
     public @interface RequestParam {
        value === name
        @org.springframework.core.annotation.AliasFor("name")
        java.lang.String value() default "";

        @org.springframework.core.annotation.AliasFor("value")
        java.lang.String name() default "";

        boolean required() default true;

        java.lang.String defaultValue() default "\n\t\t\n\t\t\n\uE000\uE001\uE002\n\t\t\t\t\n";
    }

    - "/save/id?name=name" -> @RequestParam(value = "name", defaultValue = "Pedro") String name
    public @interface RequestParam {
        value === name
        @org.springframework.core.annotation.AliasFor("name")
        java.lang.String value() default "";

        @org.springframework.core.annotation.AliasFor("value")
        java.lang.String name() default "";

        boolean required() default true;

        java.lang.String defaultValue() default "\n\t\t\n\t\t\n\uE000\uE001\uE002\n\t\t\t\t\n";
    }

    -  @ResponseBody -> This returns a JSON or XML with the persons

    - ResponseEntity<Person> -> Hypermedia-Driven RESTful Web Service
    Hypermedia as the Engine of Application State (HATEOAS)
        is a component of the REST application architecture
        that distinguishes it from other network application architectures.
    REST client (URL, Mediatype) needs little to no prior knowledge about how to interact
        with an application or server beyond a generic understanding of hypermedia.
    Clients and servers in CORBA interact through a fixed interface
        shared through documentation or an interface description language (IDL).

    - accept application/json ( @Consumes ) and
    - return text/plain ( @Produces )
 */
