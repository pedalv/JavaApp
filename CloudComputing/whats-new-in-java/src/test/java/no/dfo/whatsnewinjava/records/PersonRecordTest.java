package no.dfo.whatsnewinjava.records;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonRecordTest {

    @Test
    public void givenValidNameAndAddress_whenGetNameAndAddress_thenExpectedValuesReturned() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        PersonRecord person = new PersonRecord(name, address);

        assertEquals(name, person.name());
        assertEquals(address, person.address());
    }

    @Test
    public void givenSameNameAndAddress_whenEquals_thenPersonsEqual() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        PersonRecord person1 = new PersonRecord(name, address);
        PersonRecord person2 = new PersonRecord(name, address);

        assertTrue(person1.equals(person2));
    }

    @Test
    public void givenSameNameAndAddress_whenHashCode_thenPersonsEqual() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        PersonRecord person1 = new PersonRecord(name, address);
        PersonRecord person2 = new PersonRecord(name, address);

        assertEquals(person1.hashCode(), person2.hashCode());
    }


}