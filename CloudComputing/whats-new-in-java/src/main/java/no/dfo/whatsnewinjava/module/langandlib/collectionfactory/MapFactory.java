package no.dfo.whatsnewinjava.module.langandlib.collectionfactory;

import java.util.Map;

public class MapFactory {

    public static void main(String... args) {

        // Execute following lines in JShell to reproduce demo

        Map.of("Key1", 1, "Key2", 2); // Up to ten key/values

        // Map.of("Key1", 1, "Key2", 2, "Key3"); // Won't compile

        Map.ofEntries(Map.entry("Key1", true), Map.entry("Key2", false)); // Unbounded number of entries (varargs)

        Map.of("a", 1, "a", 2); // IllegalArgumentException

        //Map
        //- no nulls for keys or values
        //- no duplicates keys
        //- Iteration order not guaranteed
        //- for guaranteed order use List

    }
}
