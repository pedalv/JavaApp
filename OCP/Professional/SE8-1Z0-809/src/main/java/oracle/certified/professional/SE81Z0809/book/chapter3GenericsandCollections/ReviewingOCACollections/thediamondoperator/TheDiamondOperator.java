package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.ReviewingOCACollections.thediamondoperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheDiamondOperator {


    public static void main(String ... args) {

        /*
        Before Java 5 came out,
            you had to write code like the following
            and hope that programmers remembered that you wanted only String objects in there:
         */
        List namesBeforJava5 = new ArrayList();


        /*
        In Java 5,
            you could actually document this assumption in code through a new feature called generics!
        The compiler even helps enforce this assumption for you:
         */
        List<String> namesJava5 = new ArrayList<String>();


        /*
        Java 7 lets you shorten it a bit:
         */
        List<String> namesJava7 = new ArrayList<>(); // The shortened form uses the diamond operator.

        HashMap<String, HashMap<String, String>> map1 =
                new HashMap<String, HashMap<String, String>>();

        HashMap<String, HashMap<String, String>> map2 = new HashMap<>();

    }

}

class Doggies {
    List<String> names;

    Doggies() {
        names = new ArrayList<>(); // matches instance variable declaration
    }

    public void copyNames() {
        ArrayList<String> copyOfNames;
        copyOfNames = new ArrayList<>(); // matches local variable declaration
    }
}
