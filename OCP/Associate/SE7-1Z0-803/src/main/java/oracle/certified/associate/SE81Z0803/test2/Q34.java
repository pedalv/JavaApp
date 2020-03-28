package oracle.certified.associate.SE81Z0803.test2;

import oracle.certified.associate.SE81Z0803.test2.interfacee.IInt;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q34 {

    public static void main(String ... args){

        new C1().m1();// OUT: A
        new C2().m1();// OUT: C2
        new B1().m1();// OUT: A
        new B2().m1();// OUT: B2

        System.out.println("--//--");

        C1 objectOfC1 = new C1();
        objectOfC1.m1(); // OUT: A

        C2 objectOfC2 = new C2();
        objectOfC2.m1(); // OUT: C2

        B1 objectOfB1 = new B1();
        objectOfB1.m1(); // OUT: A

        B2 objectOfB2 = new B2();
        objectOfB2.m1(); // OUT: B2


    }
}

class A{
    public static String str = "A";
    public void m1() {
        System.out.println("A");
    }

}

class B1 extends A {
    static public String str = "B1";
}

class B2 extends A {

    static String str = "B2";
    public void m1() {
        System.out.println("B2");
    }

}


class C1 extends B1 {
    static public String str = "C1";
}

class C2 extends B1 {

    public static String str = "C2";

    public void m1() {
        System.out.println("C2");
    }

    public static void main(String ... args){
        C1 objectOfC1 = new C1();

        System.out.println(C1.str); // OUT: C1
        System.out.println(objectOfC1.str); // OUT: C1
        System.out.println(str); // OUT: C2


    }

}


class Q22 implements IInt {

    public static void main(String ... args){
        Q22 s = new Q22();

        int j = s.thevalue;
        int k = IInt.thevalue;
        int l = thevalue;
    }

}

