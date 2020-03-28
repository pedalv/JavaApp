package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 21/03/15.
 */
interface I70{
    int A = 10;
    int B = 1;
}

public class Q70 implements I1 {

    public static final int A = 10;
    /*
    - A constant declaration in a interface is implicitly public, satic and final
    - A constant declaration in a interface must not include any of the modifiers
    synchronized, transient or volatile, or a compiletime error occurs.ß
     */

    public synchronized void mI1() {}

    public static void main(String ... args){
        //I1.X = 30; // cannot assign a value to final variable X
        int a = I1.X;

    }


}

interface I1{

    int X = 10;
    void mI1();
}

interface I2{
    int X = 20;
}

interface I extends I1, I2{
    //int Y = X; //Error because of ambiguous reference to X
    int Z = I1.X; //Valid
}

/*
    - a method in an interface cannot be declared:
    native
    or
    synchronized
    or a compile-time error occurs,
    because those keywords describe implementations properties
    rather then interface properties.
    However, a method declared in an interface may be implemented
    by a method that is declared native or synchronized in a class that
     implements the interface.



 */