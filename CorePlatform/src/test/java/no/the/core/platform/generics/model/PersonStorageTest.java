package no.the.core.platform.generics.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// JUnit 4.12
public class PersonStorageTest {

    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner bertCooper = new Partner("Bert Cooper", 100);
    private Employee peggyOlson = new Employee("Peggy Olson", 65);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Test
    public void cannotLoadFromEmptyFile() throws Exception
    {
        PersonLoader loader = new PersonLoader(file);

        assertNull(loader.load());
    }

    @Test
    public void savesAndLoadsPerson() throws Exception
    {
        PersonSaver saver = new PersonSaver(file);
        PersonLoader loader = new PersonLoader(file);

        saver.save(donDraper);

        assertEquals(donDraper, loader.load());
    }

    @Test
    public void savesAndLoadsTwoPeople() throws Exception
    {
        saver.save(donDraper);
        saver.save(peggyOlson);

        assertEquals(donDraper, loader.load());
        assertEquals(peggyOlson, loader.load());
    }

    @Test
    public void savesArraysOfPeople() throws Exception
    {
        /*
        Employee[] employees = new Employee[2];
        Person[] people = employees;
        // - employee is not a partner => ArrayStoreException exception
        // - employee is a person
        */
        Partner[] people = new Partner[2];
        people[0] = donDraper;
        people[1] = bertCooper;

        saver.saveAll(people);

        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @Test
    public void savesListsOfPeople() throws Exception
    {
        /*
            - UpperBounded: List<? extends cls>

            try solve problem above about
            ArrayStoreException exception
                with list*/

        List<Partner> people = new ArrayList<>();
        /*
         - parnter is a people
         - parntner is not a employee
         - people do not know nothing about partner and employee
                so <? extends Person>
         */
        people.add(donDraper);
        people.add(bertCooper);
        //people.add(peggyOlson); //parntner is not a employee

        saver.saveAll(people);

        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @Test
    public void loadsListsOfPeople() throws Exception
    {
        //  - Lower Bounded: List<? super cls>

        saver.save(donDraper);
        saver.save(bertCooper);
        saver.save(peggyOlson);
        //saver.save(new Object());

        //List<Person> people = new ArrayList<>();
        /* List<Partner> people = new ArrayList<>();
        Error:(114, 24) java: incompatible types: java.util.List<no.the.core.platform.generics.model.Partner>
        cannot be converted to java.util.List<? super no.the.core.platform.generics.model.Person>*/
        List<Object> people = new ArrayList<>();
        loader.loadAll(people);

        assertEquals(donDraper, people.get(0));
        assertEquals(bertCooper, people.get(1));
        assertEquals(peggyOlson, people.get(2));
        assertEquals(asList(donDraper, bertCooper, peggyOlson), people);
    }

    @Before
    public void setUp() throws Exception
    {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    @After
    public void tearDown()
    {
        if (file.exists())
        {
            file.delete();
        }
    }


}