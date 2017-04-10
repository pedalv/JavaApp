package no.firma.oppgave.helpers;

/**
 * Created by p on 23/01/2017.
 */
public class CreateTime {

    private static long secondsInMilli = 1000;

    public static long minutes(int m) {

        return secondsInMilli * 60 * m;

    }

    public static long hours(int h) {

        return secondsInMilli * 60 * 60 * h;

    }

    public static long days(int d) {

        return secondsInMilli * 60 * 60 * 24 * d;

    }

}