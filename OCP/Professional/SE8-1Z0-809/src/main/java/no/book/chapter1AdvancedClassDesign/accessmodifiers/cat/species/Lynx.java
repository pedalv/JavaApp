package no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.species;

import no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat;

public class Lynx extends BigCat {

    public static void main(String ... args) {

        BigCat cat = new BigCat();
        System.out.println(cat.name);
        //System. out .println(cat.hasFur); // Does not compile
        // Error: java: hasFur has protected access in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat
        //System. out .println(cat.hasPaws); // Does not compile
        // Error: java: hasPaws is not public in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat;
        // cannot be accessed from outside package
        //System. out .println(cat.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat

        cat.publicMethod();
        //cat.protectedMethod(); // Does not compile
        // Error: java: protectedMethod() has protected access in
        // no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat
        //cat.defaultMethod(); // Does not compile
        // Error: java: defaultMethod() is not public in
        // no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat;
        // cannot be accessed from outside package
        //cat.privateMethod(); // Does not compile
        // Error: java: privateMethod() has private access in
        // no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat



        Lynx cat2 = new Lynx();
        System.out.println(cat2.name);
        System. out .println(cat2.hasFur);
        //System. out .println(cat2.hasPaws); // Does not compile
        // Error: java: hasPaws is not public in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat;
        // cannot be accessed from outside package
        //System. out .println(cat2.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat

        cat2.publicMethod();
        cat2.protectedMethod();
        // cat2.defaultMethod(); // Does not compile
        // Error: java: cannot find symbol
        //  symbol:   method defaultMethod()
        //  location: variable cat2 of type no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.species.Lynx
        // cat2.privateMethod(); // Does not compile
        //Error: java: cannot find symbol
        //symbol:   method privateMethod()
        //location: variable cat2 of type no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.species.Lynx



        BigCat cat3 = new Lynx();
        System.out.println(cat3.name);
        //System. out .println(cat3.hasFur); // Does not compile
        // Error: java: hasFur has protected access in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat
        //System. out .println(cat3.hasPaws); // Does not compile
        // Error: java: hasPaws is not public in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat;
        // cannot be accessed from outside package
        //System. out .println(cat3.id); // Does not compile
        // Error: java: id has private access in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat

        cat3.publicMethod();
        //cat3.protectedMethod(); // Does not compile
        // Method/fiel in a class (that is not a superclass) in a different package) IMPORTANT IMPORTANT IMPORTANT
        // Error: java: protectedMethod() has protected access
        // in no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat
        //cat3.defaultMethod(); // Does not compile
        // Error: java: cannot find symbol
        //  symbol:   method defaultMethod()
        //  location: variable cat2 of type no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.species.Lynx
        //cat3.privateMethod(); // Does not compile
        //Error: java: cannot find symbol
        //symbol:   method privateMethod()
        //location: variable cat2 of type no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.species.Lynx


        //Lynx cat4 = new BigCat(); // Does not compile
        // Error:(39, 21) java: incompatible types: no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.BigCat
        // cannot be converted to no.book.chapter1AdvancedClassDesign.accessmodifiers.cat.species.Lynx



    }
}
