package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode;

import java.util.List;

/*
It shouldn’t be a surprise that you can get a ClassCastException in the other direction either,
    for example:
 */
public class LegacyUnicorns { //Line 1

    public static void main(String[] args) { // Line 2

        java.util.List<Unicorn> unicorns = new java.util.ArrayList<>(); // Line 3
        addUnicorn(unicorns); // Line 4
        Unicorn unicorn = unicorns.get(0); // ClassCastException // Line 5
        /*
        Exception in thread "main"
            java.lang.ClassCastException: no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode.Dragon
            cannot be cast to
            no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode.Unicorn
	        at no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode.LegacyUnicorns.main(LegacyUnicorns.java:15)
         */
        /*
        The main() method correctly uses generics.
        The problem is that it calls a legacy method that claims to add a Unicorn to the list.
        But this method does not actually work as advertised and adds a Dragon on line 8 instead.
        Then when line 5 tries to put that Dragon in a Unicorn reference,
            a ClassCastException occurs.
        Of course,
            this code has compiler warnings in it as well.
        This problem is fairly straightforward.
        If the legacy code doesn’t use the right types,
            the generics code will still fail at runtime.
         */
    }

    private static void addUnicorn(List unicorn) { // Line 7
        unicorn.add(new Dragon()); // Line 8
    }
}


