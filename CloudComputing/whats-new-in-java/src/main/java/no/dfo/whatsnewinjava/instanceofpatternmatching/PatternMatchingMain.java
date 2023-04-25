package no.dfo.whatsnewinjava.instanceofpatternmatching;

public class PatternMatchingMain {

    public static void main(String... args) {
        Record o = new Person("Sander");

        if(o instanceof Person p && p.name().startsWith("S")) {
            System.out.println(p.name());
        }

        /*
        // error: cannot find symbol with ||
        if(o instanceof Person p || p.name().startsWith("S")) {
            System.out.println(p.name());
        }
        */

        //Person p = null; //error: variable p is already defined in method main(String...)
        if(!(o instanceof Person p)) {
            System.out.println("Not a person!");
        } else {
            System.out.println(p.name());
        }

    }

}
