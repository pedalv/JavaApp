package oracle.certified.associate.SE81Z0803.test5;

/**
 * Created by pedro alves on 15/03/15.
 */
public class Q60 {

    public static void  main(String ... args){
        A a = new A();
        a.bla();


    }



}


class A {
    void bla(){
        System.out.println("bla");
    }
}

abstract class B extends A {
    abstract void bla();
}