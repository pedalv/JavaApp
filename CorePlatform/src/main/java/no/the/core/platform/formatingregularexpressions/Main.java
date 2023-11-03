package no.the.core.platform.formatingregularexpressions;

import java.io.IOException;

import static no.the.core.platform.formatingregularexpressions.Formating.doWrite;
import static no.the.core.platform.formatingregularexpressions.RegularExpressionss.regexmethods;

public class Main {

    public static void main(String[] args) {
        formating();
    }

    private static void formating() {
        //emptyDelimiterStringJoiner();
        //delimiterStringJoiner();
        //emptyDelimiterPrefixSufixStringJoiner();
        //delimiterPrefixSufixStringJoiner();
        //concatenationFormatting();
        try {
            doWrite(13, 11, 4, 2, 3.33333);
        } catch (IOException e) {
            e.printStackTrace();
        }
        regexmethods();
    }

}
