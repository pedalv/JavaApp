package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode;

/*
Autoboxing has a different problem:
 */
public class LegacyAutoboxing {

    public static void main(String[] args) {
        java.util.List numbers = new java.util.ArrayList(); // Line 3
        numbers.add(5); // Line 4
        //int result = numbers.get(0); // DOES NOT COMPILE // Line 5
        /*
        Error:java: incompatible types: java.lang.Object cannot be converted to int

        Information:java: Some input files use unchecked or unsafe operations.
        Information:java: Recompile with -Xlint:unchecked for details.
         */
        /*
        The good news is that unboxing fails with a compiler error rather than a runtime error.
        On line 3,
            we create a raw list.
        On line 4,
            we try to add an int to the list.
        This works because Java automatically autoboxes to an Integer.
        On line 5,
            we have a problem.
        Since we aren’t using generics,
            Java doesn’t know that the list contains an Integer.
        It just knows that we have an Object.
        And an Object can’t be unboxed into an int.
         */
    }

}


/*
To review,
    the lesson is to be careful when you see code that doesn’t use generics.

Pay special attention to looking for
    compiler warnings,
    ClassCastExceptions,
    and compiler errors.
 */
