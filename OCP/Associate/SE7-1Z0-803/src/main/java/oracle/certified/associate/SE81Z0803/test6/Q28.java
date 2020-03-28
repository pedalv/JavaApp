package oracle.certified.associate.SE81Z0803.test6;

import java.util.ArrayList;

/**
 * Created by pedro alves on 25/05/15.
 */
public class Q28 {
}

interface I {}

class A implements I{
    public String toString() {return "in a";}
}

class B extends A {
    public String toString(){return "in b";}
}

class TestClass{



    public static void main(String ... args){
        B b = new B();
        A a = b;
        I i = new A();

        Object[] objects = new Object[]{"aaa", new Object(), new ArrayList()};
        String [] sa = {};
        Object[][] arr = new Object[][]{new String[]{}, new Object[]{}, new ArrayList[]{}, {}};

        System.out.println(i);
        System.out.println((B)a);
        System.out.println(b);


        int arr1 []= {1,2,3,4,5};
        // Cannot use an existing/predefined variable in the variable declaration part.
        for( int v : arr1) {
            System.out.println(v);
        }

    }


}
