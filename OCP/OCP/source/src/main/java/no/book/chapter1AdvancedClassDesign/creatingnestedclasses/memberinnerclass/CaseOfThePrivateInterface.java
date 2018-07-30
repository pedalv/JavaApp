package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass;

public class CaseOfThePrivateInterface {

    /*
    The rule that all methods in an interface are public still applies.

    The interface itself does not have to be public, though.
    Just like any inner class, an inner interface can be private.
    This means that the interface can only be referred to within the current outer class.
     */
    private interface Secret {
        public void shh();
    }

    /*
    A class that implements the interface must define that method as public.
     */
    class DontTell implements Secret {
        public void shh() { }
    }

}
