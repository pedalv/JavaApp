package no.dfo.whatsnewinjava.switchexpressions;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;

/**
 * javac --enable-preview --release 12 MainSwitch.java
 * java --enable-preview MainSwitch
 */
@Slf4j
public class MainSwitch {

    public static void main(String ...args) {
        int monthNumber = 3;

        String monthName;

        //Old
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

        //new
        String monthName2 = switch(monthNumber) {
            case 1 -> {
                String month = "January";
                yield month;
            }
            case 2 -> {
                String month = "February";
                yield month;
            }
            case 3 -> "MARS";

            // rest of cases omitted
            default ->  "Unknown";
        };
        log.info(String.format("switch-new: %s", monthName2));


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

    }

}
