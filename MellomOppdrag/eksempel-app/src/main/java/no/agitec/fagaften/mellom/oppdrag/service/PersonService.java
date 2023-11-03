package no.agitec.fagaften.mellom.oppdrag.service;

import no.agitec.fagaften.mellom.oppdrag.domain.Person;
import no.agitec.fagaften.mellom.oppdrag.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public List<Person> hentPersons(){
        List<Person> result = new ArrayList<>();
        personRepository.findAll().forEach(result::add);
        return result;
    }

    @Transactional
    public Person createPerson(Person p){
        return personRepository.save(p);
    }

}
