package oracle.certified.associate.SE81Z0808.test5;

/**
 * Created by p on 09/06/2015.
 */
public class Q39 {


    public static void main(String ... args){
        B b = new B();
        A a = new A(3);

    }

}

class A {
    public A() {System.out.println("a");}
    public A(int i){System.out.println(i);}
}

class B extends A{
    static A s1 = new A(1);

    A a = new A(2);

    static A s2 = new A(4);

    public B() {System.out.println("b");}

}
//TODO
//static : 1. constants 2. variable 3. blocks
//no-static 1. constants 2. variables 3. blocks
// constructor