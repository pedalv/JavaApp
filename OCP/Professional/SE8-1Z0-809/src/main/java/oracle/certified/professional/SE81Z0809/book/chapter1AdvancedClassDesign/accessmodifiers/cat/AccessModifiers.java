package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.accessmodifiers.cat;

public class AccessModifiers {

    /*
    the access modifiers public, protected, and private and default access.

    Remember that there was a default keyword introduced in Java 8 for
        interfaces. That keyword is not an access modifier.
     */

    public static void main(String ... args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        System. out .println(cat.hasFur);
        System. out .println(cat.hasPaws);
        //System. out .println(cat.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat

        cat.publicMethod();
        cat.protectedMethod();
        cat.defaultMethod();
        //cat.privateMethod(); // Does not compile
        // Error: java: privateMethod() has private access in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat


    }

    protected void main(String args) {

    }

    private static void main(String s, Integer i) {

    }

    static void main(String s, Integer i, Float f) {

    }

}
