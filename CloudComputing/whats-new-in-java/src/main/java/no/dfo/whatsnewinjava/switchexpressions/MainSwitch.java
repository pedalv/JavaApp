package no.dfo.whatsnewinjava.switchexpressions;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.util.Locale;

/**
 * javac --enable-preview --release 12 MainSwitch.java
 * java --enable-preview MainSwitch
 *
 * Switch Statement
 * Switch Expressions
 */
@Slf4j
public class MainSwitch {

    public static void main(String ...args) {
        int monthNumber = 3;

        String monthName;

        //Old - Switch Statement
        switch(monthNumber) {
            case 1: {
                monthName = "January";
                break;
            }
            case 2: {
                monthName = "February";
                break;
            }
            default: {
                monthName = "Unknown";
            }
        }
        log.info(String.format("switch-old: %s", monthName));

        //new - Switch Expressions
        String monthName2 = switch(monthNumber) {
            case 1 -> {
                String month = "January";
                yield month;
            }
            case 2 -> "February";

            case 3, 4, 5 -> "Spring months";


            // rest of cases omitted
            default ->  "Unknown";
        };
        log.info(String.format("switch-new: %s", monthName2));

        //Mixing Old and New
        //Switch expressions
        String monthName3 = switch(monthNumber) {
            case 1 : yield "January";
            case 2 : yield "February";
            default : yield  "Unknown";
        };

        //switch statements
        switch(monthNumber) {
            case 1 -> monthName = "January";
            case 2 -> monthName = "February";
        }

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





        DayOfWeek day = DayOfWeek.SATURDAY;
        String activity = switch (day) {
            case SATURDAY, SUNDAY -> "Relax";
            case MONDAY -> "Try to Work";
            default -> "Work";
        };
        log.info(activity); // Relax





        String food = "cheese";

        Locale locale;
        switch(food) {
            case "burger":
            case "donut": locale = Locale.US;
                break;
            case "cheese": locale = Locale.forLanguageTag("nl");
                break;
            case "maple syrup": locale = Locale.CANADA;
                break;
            default: locale = Locale.getDefault();
        }
        System.out.println(locale);

        locale = switch(food) {
            case "burger":
            case "donut": yield Locale.US;
            case "cheese": yield Locale.forLanguageTag("nl");
            case "maple syrup": yield Locale.CANADA;
            default: yield Locale.getDefault();
        };
        System.out.println(locale);

        locale = switch(food) {
            case "burger", "donut": yield Locale.US;
            case "cheese": yield Locale.forLanguageTag("nl");
            case "maple syrup": yield Locale.CANADA;
            default: yield Locale.getDefault();
        };
        System.out.println(locale);

        locale = switch(food) {
            case "burger", "donut"-> Locale.US;
            case "cheese" -> Locale.forLanguageTag("nl");
            case "maple syrup" -> Locale.CANADA;
            default -> Locale.getDefault();
        };
        System.out.println(locale);




    }

}
