package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q23 {

    public static void main(String ... args){
        Object a, b, c;
        a = new String ("A");
        b = new String ("B");
        c = a;
        a = b;
        System.out.println(""+c);
    }

}
