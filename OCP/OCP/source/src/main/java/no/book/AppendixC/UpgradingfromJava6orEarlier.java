package no.book.AppendixC;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpgradingfromJava6orEarlier {

    public static void main(String ... args) {

        usingtheDiamondOperator();
        creatingLiterals();
        makingDecisionswithSwitch();
        FormattingandParsing();

    }

    private static void FormattingandParsing() {
        //TODO
    }

    private static void makingDecisionswithSwitch() {

        // switch statements.

        /*
        Data types supported by switch statements include the following:
        ■■ int and Integer
        ■■ byte and Byte
        ■■ short and Short
        ■■ char and Character
        ■■ String
        ■■ enum values
         */

        /*
        Note that
        ■■ boolean
        ■■ and long
        ■■ and their associated wrapper classes are not supported by switch statements.
         */

        /*
        The values in each case statement must be compile-time constant values of the same
        data type as the switch value. This means that you can use only literals, enum constants,
        or final constant variables of the same data type. By final constant, we mean that the
        variable must be marked with the final modifier and initialized with a literal value in the
        same expression in which it is declared.
         */


        // Let’s look at a simple example using the day of the week, with 0 for Sunday, 1 for
        //Monday, and so on:

        int dayOfWeek = 5;
        switch(dayOfWeek) {
            default:
                System.out.println("Weekday");
                break;
            case 0_0: // In this example, we use the numeric literal 0_0 , which the compiler interprets as 0
                System.out.println("Sunday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
        }

        // With a dayOfWeek value of 5 , this code will output
        //Weekday

        switch(dayOfWeek) {}

        switch(dayOfWeek) {
            case 0_0:
                System.out.println("Sunday");
            default:
                System.out.println("Weekday");
            case 6:
                System.out.println("Saturday");
        }
        // With a dayOfWeek value of 5 , this code will output
        //Weekday
        //Saturday

        // With a dayOfWeek value of 6 , this code will output
        //Saturday

        // With a dayOfWeek value of 0 , this code will output
        //Sunday
        //Weekday
        //Saturday

    }

    private int getSortOrder(String firstName, final String lastName) {
        String middleName = "Patricia";
        final String suffix = "JR";
        int id = 0;
        switch(firstName) {
            /*
            The first case statement, "Test", compiles without issue using a String literal, and it is
            a good example of how a return statement, like a break statement, can be used to exit the
            switch statement early.
             */
            case "Test":
                return 52;

            /*
            case middleName: // DOES NOT COMPILE
                //The second case statement, middleName, does not compile because
                //middleName is not a final variable, despite having a known value at this particular line of
                //execution.
                id = 5;
                break;
            */

            case suffix:
                /*
                The third case statement, suffix, compiles without issue because suffix is a
                final constant variable.
                 */
                id = 0;
                break;

            /*
            case lastName: // DOES NOT COMPILE
                //The fourth case statement, lastName, does not compile, as the final variable is a
                //method argument that can change at runtime.
                id = 8;
                break;
            */

            /*
            //Finally, the last three case statements don’t
            //compile because none of them have a matching type of String, with the last one being an
            //enum value.
            case 5: // DOES NOT COMPILE
                id = 7;
                break;
            case 'J': // DOES NOT COMPILE
                id = 10;
                break;
            case Month.JANUARY: // DOES NOT COMPILE
                id=15;
                break;
            */
        }
        return id;
    }

    private static void creatingLiterals() {

        // new formats for literals

        /*
        When a number is present in the code, it is a type of literal.
        By default, Java assumes that you are defining an int value with a literal.
         */

        //long max = 3123456789; // DOES NOT COMPILE
        //Error:(30, 20) java: integer number too large: 3123456789

        long max = 3123456789L; // now Java knows it is a long



        /*
        The decimal number system or base 10 since there are 10 numbers.

        Java allows you to specify digits in several other formats:
        -> Decimal (Digits 0-9), for example, 2018
        -> Octal (Digits 0–7) This format uses the number 0 as a prefix, for example, 017.
        -> Hexadecimal (Digits 0–9 and Letters A–F) This format uses the number 0 followed by x
        or X as a prefix, for example, 0xFF.
        -> Binary (Digits 0–1) This format uses the number 0 followed by b or B as a prefix, for
        example, 0b10.
         */

        // Literals with Underscore Characters

        int million1 = 1000000;
        int million2 = 1_000_000; // We’d rather be reading the latter example because the zeroes don’t run together.

        // You can add underscores anywhere except at the beginning of a literal,
        // the end of a literal, right
        //before a decimal point,
        // or right after a decimal point.
        // Let’s look at a few examples:
        //double notAtStart = _1000.00; // DOES NOT COMPILE
        //double notAtEnd = 1000.00_; // DOES NOT COMPILE
        //double notByDecimal = 1000_.00; // DOES NOT COMPILE
        //double annoyingButLegal = 1_00_0.0_0; // this one compiles

    }

    private static void usingtheDiamondOperator() {

        // the diamond operator <>

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<>();

        // the diamond operator <> is that it can be used for
        //embedded collection types.

        Map<Map<String,Integer>,List<Double>> map1
                = new HashMap<Map<String,Integer>, List<Double>>();
        Map<Map<String,Integer>,List<Double>> map2 = new HashMap<>();

        /*
        Map<Map<String,Integer>,List<Double>> map3
                = new HashMap<<>,<>>(); // DOES NOT COMPILE

        List<> list1 = new ArrayList<String>(); // DOES NOT COMPILE
        */

    }

}
