package oracle.certified.associate.SE81Z0803.test2;

//static import java.lang.*; // error
//import static java.lang.*; // okay
// viktig: import forst



/**
 * Created by pedro alves on 07/02/15.
 */
public class Q28
{
// public < protector < package (or default) < private

    //method
    public static void m1(String ... args) {}
    static public void m2(String ... args) {}

    //variable
    public static int i1 = 1;
    static public int i2 = 1;


}
