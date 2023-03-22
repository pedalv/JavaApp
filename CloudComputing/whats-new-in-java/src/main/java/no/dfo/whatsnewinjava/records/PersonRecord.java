package no.dfo.whatsnewinjava.records;

import java.util.Objects;

/**
 * https://www.baeldung.com/java-record-keyword
 * - Records are immutable data classes that require only the type and name of fields.
 */
public record PersonRecord(String name, String address) {

    public static String UNKNOWN_ADDRESS = "Unknown";

    public PersonRecord {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }

    public PersonRecord(String name) {
        this(name, "Unknown");
    }

}
