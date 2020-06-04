package oracle.certified.associate.SE81Z0803.test3;

import oracle.certified.associate.SE81Z0803.test3.other.Other;

/**
 * Created by pedro alves on 07/03/15.
 */
public class Q81 {

    public static void main(String ... args){
        String hello = "Hello", lo = "lo";

        System.out.println(
                (Other.hello == hello) + " "
        ); // line 1

        System.out.println(
                (Other.hello == hello) + " "
        ); // line 2

        System.out.println(
                (hello == ("Hel" + "lo")) + " "
        ); // line 3

        System.out.println(
                (hello == ("Hel"+lo)) + " "
        ); // line 4

        System.out.println(
                hello == ("Hel"+lo).intern()
        ); // line 5

    }
}
