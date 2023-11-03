package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.assessmentTest.q18;

import java.util.Set;
import java.util.TreeSet;

public class ExempleRuntimeException {

    public static void main(String ... args) {

        /*
         * @see Collection
         * @see List
         * @see SortedSet
         * @see HashSet
         * @see TreeSet
         * @see AbstractSet
         * @see Collections#singleton(java.lang.Object)
         * @see Collections#EMPTY_SET
         */
        Set<? extends RuntimeException> set = null;

        //set = new HashSet<? extends RuntimeException>();
        /*
        Error: java: unexpected type
          required: class or interface without bounds
          found:    ? extends java.lang.RuntimeException
         */
        //set = new HashSet<Exception>();
        /*
        Error: java: incompatible types: java.util.HashSet<java.lang.Exception>
            cannot be converted to java.util.Set<? extends java.lang.RuntimeException>
         */
        set = new TreeSet<RuntimeException>();
        set = new TreeSet<NullPointerException>();

    }

}

/*
Which of the following statements can fill in the blank to make the code compile successfully?
(Choose all that apply.)

    A. new HashSet<? extends RuntimeException>();
        B. new HashSet<Exception>();
C. new TreeSet<RuntimeException>();
D. new TreeSet<NullPointerException>();
            E. None of the above

ANSWER
C
D

Set defines an upper bound of type RuntimeException.
This means that classes may specify RuntimeException or any subclass of RuntimeException as the type parameter.
Choice A is incorrect because the wildcard cannot occur on the right side of the assignment.
See Chapter 3 for more information.
 */

/*

1. Throwable
2.1 Error
    - LinkageError
    - VirtualMachineError
    - AWTError
    - ...
2.2 Exception
    - RuntimeException
      * ArithmeticException
      * NullPointerException
      * ArrayIndexOutOfBoundException
      * IllegalArgumentException
    - Exception
      * AWTExceptin
      * IOException
        = InterruptedIOException
        = EOFException
        = FileNotFoundException
        = ...
 */





















