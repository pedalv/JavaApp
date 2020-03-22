package no.book.chapter3GenericsandCollections.ReviewingOCACollections.wrapperclassesandautoboxing;

import java.util.ArrayList;
import java.util.List;

/*
Autoboxing automatically converts
    a primitive to the corresponding wrapper classes when needed if the generic type is specified in the declaration.
Unsurprisingly,
    unboxing automatically converts a wrapper class back to a primitive.

Primitive type      Wrapper class       Example of initializing
boolean             Boolean             new Boolean(true)
byte                Byte                new Byte((byte) 1)
short               Short               new Short((short) 1)
int                 Integer             new Integer(1)
long                Long                new Long(1)
float               Float               new Float(1.0)
double              Double              new Double(1.0)
char                Character           new Character('c')
 */
public class WrapperClassesandAutoboxing {

    public static void main(String ... args) {
        List<Integer> numbers = new ArrayList<Integer>(); // Line 3
        numbers.add(1);
        numbers.add(new Integer(3)); // Line 5
        numbers.add(new Integer(5));
        /*
        On lines 4 through 6,
            we add three Integer objects to numbers.
        The one on line 4 relies on autoboxing to do so,
            but it gets added just fine.
        At this point, numbers contains [1, 3, 5].
         */
        numbers.remove(1); // Line 7
        /*
        Line 7 contains the trick.
        The remove() method is overloaded.
        One signature takes an int as the index of the element to remove.
        The other takes an Object that should be removed.
        On line 7,
            Java sees a matching signature for int,
            so it doesn’t need to autobox the call to the method.
        Now numbers contains [1, 5].
         */
        numbers.remove(new Integer(5));
        /*
        Line 8 calls the other remove() method,
            and it removes the matching object, which leaves us with just [1].
         */
        System.out.println(numbers); // Line 9 // [1]
        /*
        Java also converts the wrapper classes to primitives via unboxing:
            int num = numbers.get(0);
         */
    }

}
