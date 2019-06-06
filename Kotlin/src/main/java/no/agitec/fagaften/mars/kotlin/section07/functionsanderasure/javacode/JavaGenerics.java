package no.agitec.fagaften.mars.kotlin.section07.functionsanderasure.javacode;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        //strings.add(new BigDecimal(10.5));
        /*
        java: incompatible types: java.math.BigDecimal cannot be converted to java.lang.String
        */

        //boolean b_error = strings instanceof List<String>;
        /*
        java: illegal generic type for instanceof
         */


        boolean b = strings instanceof List;
        System.out.println("new ArrayList<>() instanceof List: " + b );
        //new ArrayList<>() instanceof List: true
    }

}
