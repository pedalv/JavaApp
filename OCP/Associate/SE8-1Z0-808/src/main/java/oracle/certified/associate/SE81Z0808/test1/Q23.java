package oracle.certified.associate.SE81Z0808.test1;

/**
 * Created by p on 01/06/2015.
 */
public class Q23 {

    static int x = 20;
    static int y ;

    public static void testInts(Integer obj, int var){
        obj = var++;
        obj++;
    }

    public static void main(String [] args){

        Integer val1 = new Integer(5);
        int val2 = 9;
        testInts(val1++, ++val2);
        System.out.println(val1 + " " + val2);

        System.out.println(Q23.x + "  " + new Q23().x);
        System.out.println(Q23.y + "  " + new Q23().y);
    }



}
