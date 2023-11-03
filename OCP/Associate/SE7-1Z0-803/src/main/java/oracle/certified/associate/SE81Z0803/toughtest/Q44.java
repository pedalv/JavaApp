package oracle.certified.associate.SE81Z0803.toughtest;

/**
 * Created by pedro alves on 29/05/15.
 */
public class Q44 {

    public static void main(String ... args){

        A x = new B();
        B y = new B();
        B z = new C();

        x.mA();
        //x.mB();
        // is invalid call. It will not even compile because the class of x is A, which does not contain method mB().
        // Even though the object referred to by x is of class B which does contain mB()

        y.mA();
        y.mB();

        z.mA();
        z.mB();
        //z.mC();
        // is invalid for the same reason.


    }




}

class A{
    public void mA(){System.out.println("AA");};
}

class B extends A{
    public void mA(){System.out.println("BA");};
    public void mB(){System.out.println("BA");};
}

class C extends B{
    public void mC(){System.out.println("CC");};
}