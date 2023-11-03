package no.agitec.fagaften.mars.kotlin.section07.generics.javacode;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        //list.add(new BigDecimal(10.5));
        /*
        java: incompatible types: java.math.BigDecimal cannot be converted to java.lang.String
         */
        list.get(0).toUpperCase();

        List anotherList = new ArrayList<>();
        list.add("goodbye");
    }

}
