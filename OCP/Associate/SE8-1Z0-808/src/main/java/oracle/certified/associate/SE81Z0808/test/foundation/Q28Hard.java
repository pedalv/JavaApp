package oracle.certified.associate.SE81Z0808.test.foundation;

/**
 * Created by p on 06/06/2015.
 */
public class Q28Hard
{
    public static void main(String ... args){
        C c = new C();


        ((A)c).m1() ;       B b = new C();

    }

}

class A{
    public void m1(){System.out.println("A");}
}

class B extends A{
    public void m1(){System.out.println("B");}
}

class C extends B {
    public void m1(){
System.out.println("C");       // C.super();
    }
}
