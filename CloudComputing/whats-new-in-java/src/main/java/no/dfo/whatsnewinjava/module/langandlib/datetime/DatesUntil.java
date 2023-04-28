package no.dfo.whatsnewinjava.module.langandlib.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.stream.Stream;

/**
 * Invert the previous behaviour === Return to Java 8
 * java.locale.providers=COMPAT,CLDR,...
 *
 * java.time
 * Duration:
 * - long divideBy(Duration divisor)
 * - Duration truncatedTo(TemporalUnit unit)
 * Clock:
 * - static Clock systemUTC()
 * LocalDate.datesUntil
 *
 * Demo jshell
 * import java.time.*
 */
public class DatesUntil {

    public static void main(String... args) {
        LocalDate start = LocalDate.of(2017, 12, 1);
        Stream<LocalDate> dates = start.datesUntil(start.plusDays(7));
        dates.forEach(System.out::println);


        LocalDate birthday = LocalDate.of(1983, 12, 6);

        long leapYears = birthday
                .datesUntil(LocalDate.now(), Period.ofYears(1))
                .map(d -> Year.of(d.getYear()))
                .filter(Year::isLeap) //365 or 366 days
                .count();

        System.out.printf("%d leap years since Sander was born on %s", leapYears, birthday);
    }
}
