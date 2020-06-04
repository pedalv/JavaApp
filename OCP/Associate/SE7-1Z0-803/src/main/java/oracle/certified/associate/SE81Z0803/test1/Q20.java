package oracle.certified.associate.SE81Z0803.test1;

/**
 * Created by pedro alves on 24/05/15.
 */
public class Q20 {

    public static void main(String ... args){
        byte b = 1;
        char c = 1;
        short s  = 1;
        int i = 1;


        i = b*b;
        i = b+c+s;
        s*=b; // s = (short)(s*b)
        s+=i; // s = (short)(s+i)
    }



}
