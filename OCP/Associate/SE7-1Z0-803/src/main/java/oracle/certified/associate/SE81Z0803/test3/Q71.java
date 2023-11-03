package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 01/03/15.
 */
public class Q71 {

    int a;
    int b = 0;
    static int c;

    public void m(){
        int d;
        int e = 0;
        a++;
        b++;
        c++;
        e++;
    }


    public static void main (String ... args){
        new Q71().m();

    }


    /*
    1. all instance or static variables
    are given a default values if they are not explicitly initialized
    2. all numeric variable
    are given a value of zero or equivalent to zero
    i.e.    0 for integral types
            0.0 for double/float
    3. booleans
    are initialized to false
    4. objects
    are initialized to null
     */
}
