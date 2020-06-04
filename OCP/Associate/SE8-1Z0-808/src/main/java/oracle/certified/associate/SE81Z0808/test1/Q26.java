package oracle.certified.associate.SE81Z0808.test1;

import java.io.IOException;

/**
 * Created by p on 01/06/2015.
 */
public class Q26 {

    public static void main(String ... args) throws Exception, IOException{
        try{
            m1();
            System.out.println("A");
        } finally{
            System.out.println("B");
        }
        System.out.println("C");




    }

    private static void m1() throws Exception{
        throw new Exception();
    }


}
