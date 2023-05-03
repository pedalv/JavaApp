package no.dfo.application;

import org.apache.commons.lang3.StringUtils;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String output = StringUtils.leftPad("Leftpad FTW!", 20);
        System.out.println(output);
    }
}