package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.workingwithgenerics.genericmethods;

import oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.workingwithgenerics.genericclasses.Crate;

/*
This is often useful for static methods since they aren’t part of an instance that can declare the type.
However, it is also allowed on non-static methods as well.
 */
public class GenericMethods {

    /**
     *
     * @param t
     * @param <T> The method parameter is the generic type T
     * @return The return type is a Crate<T>. Before the return type,
     * we declare the formal type parameter of <T>.
     */
    public static <T> Crate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }

    /*
    Unless a method is obtaining the generic formal type parameter from the class/interface,
        it is specified immediately before the return type of the method.
        This can lead to some interesting-looking code!
     */

    public static <T> void sink(T t) { } // Line 3
    // Line 3 shows the formal parameter type immediately before the return type of void.
    public static <T> T identity(T t) { return t; } //  Line 4
    // Line 4 shows the return type being the formal parameter type.
    // It looks weird, but it is correct.

    //public static T noGood(T t) { return t; } // DOES NOT COMPILE // Line 5
    // Line 5 omits the formal parameter type, and therefore it does not compile.
    /*
    Error:java: cannot find symbol
    symbol:   class T
    location: class no.book.chapter3GenericsandCollections.workingwithgenerics.genericmethods.GenericMethods
     */

    //public static <T> noGood(T t) { return t; }
    /*
    Error:java: invalid method declaration; return type required // DOES NOT COMPILE
     */



    public static <T> T Good(T t) { return t; } // Line 3
    public static  <T> T Good2(T t) { return t; } // Line 4
    public static  <T> void Good3(T t) { } // Line
    //public static  <parameterType> returnType Good4(parameters) { return returnType;}

}
