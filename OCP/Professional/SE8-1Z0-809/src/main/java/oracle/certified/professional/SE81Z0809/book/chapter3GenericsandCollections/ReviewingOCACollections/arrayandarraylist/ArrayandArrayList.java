package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.ReviewingOCACollections.arrayandarraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayandArrayList {

    public static void main(String ... args) {

        /*
        An ArrayList is an object that contains other objects.
        An ArrayList cannot contain primitives.
        An array is a built-in data structure that contains other objects or primitives.
         */

        List<String> list = new ArrayList<>(); // empty list
        list.add("Fluffy"); // [Fluffy]
        list.add("Webby"); // [Fluffy, Webby]

        String[] array = new String[list.size()]; // empty array
        array[0] = list.get(1); // [Webby]
        array[1] = list.get(0); // [Webby, Fluffy]

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "-");

        /*
        The output is Webby–Fluffy–.
        This code reminds us that Java counts starting with 0 for indexes.
        It also reminds us that we access elements in ArrayLists with get(),
            and we check the number of elements with size().

        By contrast,
            we access elements in arrays using brackets
            and check the number of elements with the length variable.
         */

        String[] array2 = { "gerbil", "mouse" }; // [gerbil, mouse]
        List<String> list2 = Arrays.asList(array); // returns fixed size list // line 5
        /*
        Line 5 converts an array to a List.
        It happens to be an implementation of List that is not an ArrayList.
        Remember that a List is like a resizable array.
        It makes sense to convert an array to a List.
        It doesn’t make sense to convert an array to a Set.
        You still can do so,
            however,
            although it takes an extra step.
        You’d have to convert the array to a List
            and then the List to a Set.
         */
        list2.set(1, "test"); // [gerbil, test]
        array2[0] = "new"; // [new, test] // Line 7
        /*
        Lines 6 and 7 show that you can change the elements
            in either the array or the List.
        Changes are reflected in both,
            since they are backed by the same data.
        Implementations of List are allowed to add their own behavior.
        The implementation used when calling asList()
            has the added feature of not being resizable
            but honoring all of the other methods in the interface.
         */

        //String[] array22 = list2.toArray(); // [new, test]
        /*
        Error: java: incompatible types: java.lang.Object[] cannot be converted to java.lang.String[]
         */
        String[] array22 = (String[]) list2.toArray(); // [new, test] // Line 8
        /*
        Line 8 converts the List back to an array.
         */

        list2.remove(1); // throws UnsupportedOperationException // Line 9
        /*
        Exception in thread "main" java.lang.UnsupportedOperationException
	        at java.util.AbstractList.remove(AbstractList.java:161)
	        at no.book.chapter3GenericsandCollections.Program.ArrayandArrayListExample(Program.java:85)
	        at no.book.chapter3GenericsandCollections.Program.main(Program.java:48)
         */
        /*
        Finally,
            line 9 shows that list is not resizable
            because it is backed by the underlying array.
         */

    }

}
