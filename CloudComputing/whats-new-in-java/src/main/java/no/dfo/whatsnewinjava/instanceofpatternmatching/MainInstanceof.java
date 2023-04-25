package no.dfo.whatsnewinjava.instanceofpatternmatching;

import java.math.BigDecimal;

public class MainInstanceof {

    public static void main(String... args) {
        Object object = new BigDecimal(2);
        //Before Pattern Matching
        if(object instanceof BigDecimal) {
            BigDecimal b = (BigDecimal) object;
            int precision = b.precision();
        }
        //Pattern Matching
        if(object instanceof BigDecimal b) {
            int precision = b.precision();
        }

        //---------------

        //Pattern Matching: Future
        /*
        Object object = new BigDecimal(2);
        int value = switch(object) {
            case BigDecimal b -> b.intValue();
            case String s -> Integer.parseInt(s);
            case Integer i -> i;
            default -> throw new IllegalArgumentException("bla bla");
        };
         */




        //-----------------


        String o2 = new String();
        //Before Pattern Matching
        if(o2 instanceof String) {
            String s = (String) o2;
            int len = s.length();
        }

        //Case 1: condition is always true
        /*
        //after Pattern Matching
        //Type of o must not be subtype of pattern type!
        //error: expression type String is a subtype of pattern type String
        if(o instanceof String s) { //the type pattern
            int len = s.length();
        }

        //Flow scoping: s is only in scope where pattern match succeeded
        //error: expression type String is a subtype of pattern type String
        if(!(o instanceof String s)) { //the flow scoping pattern
            int len = 0; //or thrown a exception
        } else {
            int len = s.length();
        }

       */


        //Case 2: condition is always true

        /*
        Person o = new Person("Sander"); //expression type Person is a subtype of pattern type Person

        //error: expression type Person is a subtype of pattern type Person
        if(o instanceof Person p) {
            System.out.println(p.name());
        }

        Record o = new Person("Sander"); //OKAY
        */


    }

}
