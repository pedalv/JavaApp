package no.the.core.platform.formatingregularexpressions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.StringJoiner;

public class Formating {

    public static String emptyDelimiterStringJoiner() {

        StringJoiner sj = new StringJoiner(", ");
        System.out.println("delimeter: , :" + sj.toString());
        sj.setEmptyValue("EMPTY");
        System.out.println("delimeter: , :" + sj.toString());
        sj.add("");
        System.out.println("delimeter: , :" + sj.toString());
        sj.add("   ");
        System.out.println("delimeter: , :" + sj.toString());

        String theResult = sj.toString();

        return theResult;
    }

    public static String delimiterStringJoiner() {

        StringJoiner sj = new StringJoiner(", ");
        System.out.println("delimeter: , :" + sj.toString());
        sj.add("alpha");
        System.out.println("delimeter: , :" + sj.toString());
        sj.add("theta");
        System.out.println("delimeter: , :" + sj.toString());
        sj.add("gama");
        System.out.println("delimeter: , :" + sj.toString());

        String theResult = sj.toString();

        return theResult;
    }

    public static String emptyDelimiterPrefixSufixStringJoiner() {

        StringJoiner sj = new StringJoiner(", ", "{", "}");
        System.out.println("-delimeter: , -profix: { -sufix: } :" + sj.toString());
        sj.setEmptyValue("EMPTY");
        System.out.println("-delimeter: , -profix: { -sufix: } :" + sj.toString());
        sj.add("");
        System.out.println("delimeter: , :" + sj.toString());
        sj.add(" ");
        System.out.println("delimeter: , :" + sj.toString());
        String theResult = sj.toString();

        return theResult;
    }

    public static String delimiterPrefixSufixStringJoiner() {

        StringJoiner sj = new StringJoiner(", ", "{", "}");
        System.out.println("-delimeter: , -profix: { -sufix: } :" + sj.toString());
        sj.add("alpha");
        System.out.println("-delimeter: , -profix: { -sufix: } :" + sj.toString());
        sj.add("theta");
        System.out.println("-delimeter: , -profix: { -sufix: } :" + sj.toString());
        sj.add("gama");
        System.out.println("-delimeter: , -profix: { -sufix: } :" + sj.toString());

        String theResult = sj.toString();

        return theResult;
    }


    public static void concatenationFormatting(){
        int david = 13,
            dawson = 11,
            dillon = 4,
            gordon = 2;

        double avdiff = ( (david-dawson) +  (dawson-dillon) + (dillon-gordon))/3.0d;

        String s1 = "My nephews are " + david + ", " + dawson + ", " + dillon + ", and " + gordon + " years old";
        //System.out.println(s1);

        String s2 = String.format("My nephews are %d, %d, %d, and %d years old", david, dawson, dillon, gordon);
        //System.out.println(s2);

        //System.out.println("the average age between each is " + avdiff + " years");
        String s3 = String.format("the average age between each is %.1f years", avdiff);
        //System.out.println(s3);

        /*
            Format Flags
            #               include radix
            0               Zero-padding
            -               Left justify
            ,               Include grouping separator
            space           Leave space for positive numbers
            +               Always shown sign
            (               Enclose negative values in parenthesis
            Not specified   Corresponds sequentially to argument
            $index          index of argument to use
            <               Corresponds to same argument as previous format specifier
         */
        String s4 = String.format("%d", 32);
        String s5 = String.format("%o", 32);
        String s6 = String.format("%x", 32);
        String s7 = String.format("%#o", 32);
        String s8 = String.format("%#x", 32);
        String s9 = String.format("%#X", 32);
        //System.out.println(s4 + " " + s5 + " "+ s6 + " "+ s7 + " "+ s8 + " "+ s9);


        String s10 = String.format("W:%d X:%d", 5, 235);
        String s11 = String.format("Y:%d Z:%d", 4812, 12);

        String s12 = String.format("W:%4d X:%4d", 5, 235);
        String s13 = String.format("Y:%4d Z:%4d", 4812, 12);

        String s14 = String.format("W:%04d X:%04d", 5, 235);
        String s15 = String.format("Y:%04d Z:%04d", 4812, 12);

        String s16 = String.format("W:%-4d X:%-4d", 5, 235);
        String s17 = String.format("Y:%-4d Z:%-4d", 4812, 12);
/*
        System.out.println(s10);
        System.out.println(s11);
        System.out.println(s12);
        System.out.println(s13);
        System.out.println(s14);
        System.out.println(s15);
        System.out.println(s16);
        System.out.println(s17);
*/

        String s18 = String.format("%d", 1234567);
        String s19 = String.format("%,d", 1234567);
        String s20 = String.format("%,.7f", 1234567.009);
        //System.out.println(s18);
        //System.out.println(s19);
        //System.out.println(s20);

        String s21 = String.format("%d", 123);
        String s22 = String.format("%d", -456);

        String s23 = String.format("% d", 123);
        String s24 = String.format("% d", -456);

        String s25 = String.format("%+d", 123);
        String s26 = String.format("%+d", -456);

        String s27 = String.format("%(d", 123);
        String s28 = String.format("%(d", -456);
        String s29 = String.format("% (d", 123);
/*
        System.out.println(s21);
        System.out.println(s22);
        System.out.println(s23);
        System.out.println(s24);
        System.out.println(s25);
        System.out.println(s26);
        System.out.println(s27);
        System.out.println(s28);
        System.out.println(s29);
*/

        String s30 = String.format("%d %d %d", 100, 200, 300);
        //String s31 = String.format("%$3d %$1d %$2d", 100, 200, 300);
        //String s32 = String.format("%$2d %<04d %$1d", 100, 200, 300);
        System.out.println(s30);
        //System.out.println(s31);
        //System.out.println(s32);

    }


    /*
        https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
     */
    public static void doWrite(int david, int dawson, int dillon, int gordon, double avdiff) throws IOException {

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("myFile.txt"));

        try (Formatter f = new Formatter(writer)) {
            f.format("My nephews are %d, %d, %d, and %d years old. ", david, dawson, dillon, gordon);

            f.format("The average age between each is %.1f years.", avdiff);
        }

    }

}
