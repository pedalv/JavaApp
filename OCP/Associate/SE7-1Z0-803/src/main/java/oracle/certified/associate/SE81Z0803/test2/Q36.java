package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q36 {

    public static void main(String ... args){
        short s = Short.MAX_VALUE;
        //char c = s; // compile error: possible los of precision
        char c = (char) s; // Viktig: cast trenger
        System.out.println( c == Short.MAX_VALUE);


        final short s1 = 1;
        byte b = s1;
        // A short CONSTANTE can be assigned to a char only
        //if the value fits into a char

        short s2 = 1;
        //byte b1 = s2; // compile error: possible los of precision
        byte b1 = (byte) s2; // Viktig: cast trenger


        //int i = 129L //compile error: possible los of precision
        int i = (int) 129L; // Viktig: cast trenger
    }


}

//primitive data types:
// boolean, byte, short, char, int, long, double

//Implicit narrowing:
//byte, char, short, int

// long, float, double
//int i = 129L //compile error