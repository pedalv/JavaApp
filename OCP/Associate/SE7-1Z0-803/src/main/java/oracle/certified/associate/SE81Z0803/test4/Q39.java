package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q39 {



}



class Updater {


    public int update(int a , int offset){
        a = a + offset;
        return a;
    }

    public static void main(String ... args){
        Updater u = new Updater();
        int a = 99;

        a = u.update(a,111);

        System.out.println(a);
    }


    /*

    THIS QUESTION IS BASED ON THE PRINCIPLE THAT
    PRIMITIVES ARE ALWAYS PASSED BY VALUE.

    THUS, WHEN I PASS a TO UPDATE() METHOD,
    THE VALUE OF a IS PASSED

    THE VARIABLE a IN UPDATE(9 METHOD IS NOT SAME
    THE a IN MAIN()´S a.

    THEREFOE, WE NEED TO RETURN THE NEW VALUE FROM
    UPDATE(9 METHOD AND ASSIGN IT TO MAIN()´S a.



     */

}
