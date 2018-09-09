package no.book.chapter1AdvancedClassDesign.reviewquestions.q07;


public class IceCream {

    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY
    }

    public static void main(String[] args) {

        Flavors f = Flavors.STRAWBERRY;

        /*
        In fact, if you were to type case Flavors.VANILLA..., it would not compile.
        Keep in mind that an enum type is not an int.
        Flavors int - NO NO NO
         */

        /*
        switch (f) {
            case 0 : System.out.println("vanilla");
            // Error: java: an enum switch case label must be the unqualified name of an enumeration constant
            case 1: System.out.println("chocolate");
            // Error: java: an enum switch case label must be the unqualified name of an enumeration constant
            // Error: java: duplicate case label
            case 2: System.out.println("strawberry");
                break;
            // Error: java: an enum switch case label must be the unqualified name of an enumeration constant
            // Error: java: duplicate case label
            default: System.out.println("missing flavor");
        }
        */

        /*
        final int zero = 0;

        switch (f) {
            case zero : System.out.println("vanilla");
            // Error:(32, 18) java: an enum switch case label must be the unqualified name of an enumeration constant
            default: System.out.println("missing flavor");
        }
        */

        /*
        int int - OKAY
        */
        final int zero = 0;
        switch (0) {
            case zero : System.out.println("int int - OKAY");
                // Error:(32, 18) java: an enum switch case label must be the unqualified name of an enumeration constant
            default: System.out.println("int int - Example");
        }


        /*
        Notice that we just typed the value of the enum rather than writing Flavors.VANILLA...
        The reason is that Java already knows that the only possible matches can be enum values.
        Java treats the enum type as implied.
        Flavors Flavors - OKAY
         */
        switch (f) {
            case VANILLA : System.out.println("vanilla");
            case CHOCOLATE: System.out.println("chocolate");
            case STRAWBERRY: System.out.println("strawberry");
                break;
            default: System.out.println("missing flavor");
        }
    }

}

/*
What is the result of the following code? (Choose all that apply.)

    A. vanilla
    B. chocolate
        C. strawberry
    D. missing flavor
E. The code does not compile.
    F. An exception is thrown.

ANSWER
E
After fix
C

switch can only work with primitives, enum values and (since Java 7) strings.
 */
