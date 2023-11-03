package no.the.core.platform.formatingregularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    a       -match the letter a
    xyz     -match the sequence xys
    \w+     -match 1+ word charecters (letter, digit, underscore)
    \b      -match word breaks
    replaceFirst, replaceAll
    split
    match

    https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

    https://docs.oracle.com/javase/tutorial/essential/regex/

    https://regex101.com/
 */
public class RegularExpressionss {

    public static void regexmethods(){

        String s1 =  "apple, apple and orange please";
        String s2 = s1.replaceAll("ple", "ricot");
        String s3 =  s1.replaceAll("ple\\b", "ricot");
        String [] parts = s1.split("\\b");

        for(String thePart: parts) {
            if(thePart.matches("\\w+"))
                System.out.println(thePart);
        }


        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s1);
        while (matcher.find())
            System.out.println(matcher.group());



    }




}
