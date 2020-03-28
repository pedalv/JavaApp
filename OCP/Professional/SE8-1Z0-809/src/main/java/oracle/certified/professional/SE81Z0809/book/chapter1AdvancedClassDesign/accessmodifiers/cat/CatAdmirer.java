package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.accessmodifiers.cat;

public class CatAdmirer {

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

}
