package no.book.chapter1AdvancedClassDesign;

import no.book.chapter1AdvancedClassDesign.cat.BigCat;

public class AccessModifiers {

    /*
    the access modifiers public, protected, and private and default access.

    Remember that there was a default keyword introduced in Java 8 for
        interfaces. That keyword is not an access modifier.
     */

    public static void main(String ... args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        //System. out .println(cat.hasFur); // Does not compile
        // Error: java: hasFur has protected access in no.book.chapter1AdvancedClassDesign.cat.BigCat
        //System. out .println(cat.hasPaws); // Does not compile
        // Error: java: hasPaws is not public in no.book.chapter1AdvancedClassDesign.cat.BigCat; cannot be accessed from outside package
        //System. out .println(cat.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.cat.BigCat
    }

    protected void main(String args) {

    }

    private static void main(String s, Integer i) {

    }

    static void main(String s, Integer i, Float f) {

    }

}
