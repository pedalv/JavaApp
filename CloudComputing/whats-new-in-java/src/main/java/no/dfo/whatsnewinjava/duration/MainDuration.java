package no.dfo.whatsnewinjava.duration;

import java.time.Duration;

public class MainDuration {

    public static void main(String... args) {
        var duration = Duration.ofSeconds(10);

        var hourBack = Duration.ofHours(-1);

        //Java 17
        boolean isNegative = hourBack.isNegative();
        //boolean isPositive = hourBack.isPositive();
        //MainDuration.java:13: error: cannot find symbol

    }

}
