package oracle.certified.associate.SE81Z0808.test3;

/**
 * Created by p on 30/05/2015.
 */
public class Q39 {

    static String s1 = sM1("a");

    {s1 = sM1("b");}

    static {s1 = sM1("c");}

    private static String sM1(String s) {
        System.out.println(s);
        return s;
    }

    public static void main(String ... rags)
    {
        Q39 q = new Q39();
    }

    /*
    First, static statements/blocks are called IN THE ORDER they are defined. (Hence, a and c will be printed.)
    Next, instance initializer statements/blocks are called IN THE ORDER they are defined. Finally, the constructor
     is called. So, then it prints b.
     */

}
