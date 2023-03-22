package no.dfo.whatsnewinjava.switchexpressions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainSwitch {

    public static void main(String ...args) {
        int monthNumber = 1;

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

            // rest of cases omitted
            default ->  "Unknown";
        };
        log.info(String.format("switch-new: %s", monthName2));
    }

}
