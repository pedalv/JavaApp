package no.book.chapter1AdvancedClassDesign.cat.species;

import no.book.chapter1AdvancedClassDesign.cat.BigCat;

public class Lynx extends BigCat {

    public static void main(String ... args) {

        BigCat cat = new BigCat();
        System.out.println(cat.name);
        //System. out .println(cat.hasFur); // Does not compile
        // Error: java: hasFur has protected access in no.book.chapter1AdvancedClassDesign.cat.BigCat
        //System. out .println(cat.hasPaws); // Does not compile
        // Error: java: hasPaws is not public in no.book.chapter1AdvancedClassDesign.cat.BigCat; cannot be accessed from outside package
        //System. out .println(cat.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.cat.BigCat


        Lynx cat2 = new Lynx();
        System.out.println(cat2.name);
        System. out .println(cat2.hasFur);
        //System. out .println(cat2.hasPaws); // Does not compile
        // Error: java: hasPaws is not public in no.book.chapter1AdvancedClassDesign.cat.BigCat; cannot be accessed from outside package
        //System. out .println(cat2.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.cat.BigCat


        BigCat cat3 = new Lynx();
        System.out.println(cat3.name);
        //System. out .println(cat3.hasFur); // Does not compile
        // Error: java: hasFur has protected access in no.book.chapter1AdvancedClassDesign.cat.BigCat
        //System. out .println(cat3.hasPaws); // Does not compile
        // Error: java: hasPaws is not public in no.book.chapter1AdvancedClassDesign.cat.BigCat; cannot be accessed from outside package
        //System. out .println(cat3.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.cat.BigCat


        //Lynx cat4 = new BigCat(); // Does not compile
        // Error:(39, 21) java: incompatible types: no.book.chapter1AdvancedClassDesign.cat.BigCat cannot be converted to no.book.chapter1AdvancedClassDesign.cat.species.Lynx

    }
}
