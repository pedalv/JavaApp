package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 01/03/15.
 */
public class Q57 {

}


class ScopeTest{
    static int x = 5;


    public static void main(String ... args){
        int x = (x=3) * 4;
        System.out.println(x);
    }
}