
package oracle.certified.associate.SE81Z0803.test2;

import java.lang.System;

/**
 * Created by pedro alves on 08/02/15.
 */
public class Q44 {

    public int i = 10;
    private int j = 20;

}


class B44 extends Q44 {
    private int i = 30;
    public int k = 40;

    public void test() {
        throw new RuntimeException();
    }
}

class C44 extends B44{

}

class TestClass44{

    public static void main(String ... args){

        C44 c = new C44();
        System.out.println( ((Q44)c).i );
        //System.out.println( c.j );
        System.out.println( c.k );



    }

}
