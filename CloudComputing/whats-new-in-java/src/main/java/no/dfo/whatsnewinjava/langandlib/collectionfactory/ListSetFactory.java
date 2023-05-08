package no.dfo.whatsnewinjava.langandlib.collectionfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListSetFactory {

    public static void main(String... args) {
        List<String> books = new ArrayList<>() {{
            add("Java 9 Modularity");
            add("Java 9 Modularity");
        }}; //not recommended


        // Execute following lines in JShell to reproduce demo

        //From Java 9+
        List<Integer> ints = List.of(1, 2, 3); //Immutable Collections, no changes allowed

        ints.add(4); // UnsupportedOperationException, immutable! Unfortunately there's no ImmutableList interface to prevent these calls.

        ints.getClass(); // java.util.ImmutableCollections$ListN

        List.of(1).getClass(); // java.util.ImmutableCollections$List1 -> super-optimized version of List for one/two elems

        Set.of("first", "second");

        Set.of(null); // NullPointerException, same happens for List.of

        Set.of("a", "a"); // IllegalArgumentException: sets must consist of unique elements

        //Set
        //- unique elements === no duplicates
        //- no nulls
        //- Iteration order not guaranteed
        //- for guaranteed order use List
    }
}
