package oracle.certified.associate.SE81Z0808.test2;

/**
 * Created by p on 01/06/2015.
 */
public class Q76 {

    public static void main(String ... args){

        A a = new A();
        //a.i;
        A ab = new B();
        //ab.i;
        B b = new B();
        int okay = b.i;


    }
}


class A{
    private int i = 10;
}

class B extends A{
    public int i = 20;
}