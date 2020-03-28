package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 01/03/15.
 */
public class Q61 {
}

class A{
    private int i = 10;
    public void f(){System.out.println("a.f();");}
    public void g(){System.out.println("a.g();");}
}

class B extends A{
    public int i = 20;
    public void g(){System.out.println("b.g();");}
}

class C{

    public static void main(String ... args){
        A a = new A();
        A b = new B();

        B c = new B();

        System.out.println("c.i: " + c.i);

        System.out.println("A b = new B()");
        //b.i;//i is private
        b.f();
        b.g();

        System.out.println("A a = new A()");
        //a.i;// i is private
        a.f();
        a.g();


    }


}