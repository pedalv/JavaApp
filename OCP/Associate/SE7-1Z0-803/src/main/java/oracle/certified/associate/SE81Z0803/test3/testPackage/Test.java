package oracle.certified.associate.SE81Z0803.test3.testPackage;

/**
 * Created by pedro alves on 07/03/15.
 */
public class Test {


    public static void main(String ... args){
        String hello = "Hello", lo = "lo";

        System.out.println(
                (oracle.certified.associate.SE81Z0803.test3.testPackage.Other.hello == hello) + " "
        ); // line 1

        System.out.println(
                (oracle.certified.associate.SE81Z0803.test3.other.Other.hello == hello) + " "
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

class Other{
    static String hello = "Hello";
}
