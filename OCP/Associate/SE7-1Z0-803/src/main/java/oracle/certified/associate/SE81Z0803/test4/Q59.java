package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 11/03/15.
 */
public class Q59 {


    public static void main(String ... args){

        Flyer f = new Eagle();
        Eagle e = new Eagle();
        Bat b = new Bat();
        BatFinal bf = new BatFinal();


        if(f instanceof Bird)
            System.out.println("f is a Bird");


        if(e instanceof Flyer)
            System.out.println("e is a Flyer");


        if(b instanceof Flyer)
            System.out.println("b is a Flyer");
        /*
        b points to an object of class Bat, which does not extend from Bird.
        Therefore, B instanceof Flyer return false.

        There is no compilation issue with b instanceof Flyer because Flyer
        is an interface and it is possible for b to point to an object of a class
        that is a sub class of Bat and also implements Flyer. The compiler doesn´t complain.
         */


        //if(bf instanceof Flyer)
        //    System.out.println("bf is a Flyer");
        //java: inconvertible types
        /*
        Make Bat class as final, b instanceof Flyer will not compile bacause the compiler
        knows that is noy possible for b to point to an object of a class tha
        implements Flyer
         */



        //if(b instanceof Bird)
        //    System.out.println("b is a Bird");
        // java: inconvertible types

    }

}

interface Flyer{}
class Bird implements Flyer{}
class Eagle extends Bird {}
class Bat {}
final class BatFinal{}
