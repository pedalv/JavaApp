package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q33 {
    public static void main(String ... args){
        short s = 10;

        //char c = s; // compile error: possible los of precision
        char c = (char) s; // Viktig: cast trenger

        //s =  c; // compile error: possible los of precision
        s = (short) c;
    }
}

//primitive data types:
// boolean, byte, short, char, int, long, double
