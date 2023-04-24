package no.dfo.whatsnewinjava.records;

import java.util.Objects;

/**
 * https://www.baeldung.com/java-record-keyword
 * - Records are immutable data classes that require only the type and name of fields.
 *
 * Records and Reflection
 * - isRecord()
 * - getRecordComponents()
 *
 */
public record PersonRecord(String name, String address) {

    public static String UNKNOWN_ADDRESS = "Unknown";

    //Compat constructor
    public PersonRecord {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }

    //Canonical constructor is always present
    /*
    public PersonRecord(String name, String address) {
        this.name = name;
        this.address = address;
    }
    */

    //Non-canonical Record Constructors must always delegate
    public PersonRecord(String name) {
        this(name, "Unknown");
        // Not allowed:
        //this.name = name;
        //this.address = address;
    }

}
