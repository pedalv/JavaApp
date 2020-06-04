package oracle.certified.professional.SE81Z0809.book.chapter8IO.AssessmentTest.q13;

import java.io.Console;

public class SystemConsole {

    public static void main(String ... qrgs) {
        String line;
        Console c = System.console();
        if ((line = c.readLine()) != null) // Line 10
            System.out.println(line);
        /*
        Exception in thread "main" java.lang.NullPointerException
	        at no.book.AssessmentTest.q13.SystemConsole.main(SystemConsole.java:10)
         */
    }

}


/*
What is the result of executing the following code? (Choose all that apply.)
    A. The code runs without error but prints nothing.
B. The code prints what was entered by the user.
    C. An ArrayIndexOutOfBoundsException might be thrown.
D. A NullPointerException might be thrown.
    E. An IOException might be thrown.
    F. The code does not compile.

Answer
B
D
Option B is correct because this is the right way to read data from the Console.
Option D is also correct.
    If there is no console available,
        a NullPointerException is thrown.
The read method does not throw an IOException.
For more information, see Chapter 8.
 */



    //private static volatile Console cons = null;
    /**
     * Returns the unique {@link java.io.Console Console} object associated
     * with the current Java virtual machine, if any.
     *
     * @return  The system console, if any, otherwise <tt>null</tt>.
     *
     * @since   1.6
     */
    //public static Console console() {
//    if (cons == null) {
//          synchronized (System.class) {
//              cons = sun.misc.SharedSecrets.getJavaIOAccess().console();
//          }
//      }
//      return cons;
//  }
