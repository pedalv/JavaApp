package no.book.chapter3GenericsandCollections.workingwithgenerics;

import java.util.ArrayList;
import java.util.List;

public class WorkingwithGenerics {

    /*
    Why do we need generics?
        Well,
            remember when we said that we had to hope the caller didn’t put something in the list that we didn’t expect?

    The following does just that:
     */

    static void printNames(List list) { // Line 14
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // class cast exception here // Line 16
            /*
            However,
                line 16 is written to expect a specific class to be in there.
            It casts to a String,
                reflecting this assumption.
            Since the assumption is incorrect,
                the code throws a ClassCastException that java.lang.StringBuilder cannot be cast to java.lang.String.
             */
            /*
            Exception in thread "main" java.lang.ClassCastException: java.lang.StringBuilder cannot be cast to java.lang.String
	            at no.book.chapter3GenericsandCollections.workingwithgenerics.WorkingwithGenerics.printNames
	            at no.book.chapter3GenericsandCollections.workingwithgenerics.WorkingwithGenerics.main
             */
            System.out.println(name);
        }
    }

    public static void main(String[] args) { // Line 20
        List names = new ArrayList();
        names.add(new StringBuilder("Webby")); // Line 22
        /*
        Line 22 adds a StringBuilder to list.
        This is legal because a non-generic list can contain anything.
         */
        /*
        Generics fix this by allowing you to write and use parameterized types.
        You specify that you want an ArrayList of String objects.
        Now the compiler has enough information to prevent you from causing this problem in the first place:
        */
        List<String> namesGenerics = new ArrayList<String>();
        //namesGenerics.add(new StringBuilder("Webby")); // DOES NOT COMPILE
        /*
        Error: java: no suitable method found for add(java.lang.StringBuilder)
            method java.util.Collection.add(java.lang.String) is not applicable
            (argument mismatch; java.lang.StringBuilder cannot be converted to java.lang.String)
            method java.util.List.add(java.lang.String) is not applicable
            (argument mismatch; java.lang.StringBuilder cannot be converted to java.lang.String)
         */
        /*
        Getting a compiler error is good.
        You’ll know right away that something is wrong rather than hoping to discover it later.
         */



        printNames(names);
    }





}
