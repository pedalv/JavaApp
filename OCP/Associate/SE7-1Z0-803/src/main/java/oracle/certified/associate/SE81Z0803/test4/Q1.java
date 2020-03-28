package oracle.certified.associate.SE81Z0803.test4;

import java.util.Collection;

/**
 * Created by pedro alves on 26/04/15.
 */
public class Q1 {

    public static void main(String ... args){

        int c  = 0;
        A: for(int i = 0; i < 2; i++){
            B: for(int j = 0; j < 2; j++){
                C: for(int k = 0; k < 3; k ++){
                    c++;
                    if( k > j) break;
                }
            }
        }
        System.out.println(c);

        /*
        Integer dataWrapper = new Integer(5);
        Integer value = wiggler(dataWrapper);
        System.out.println(dataWrapper+value);
*/

    }





    public static Integer wiggler(Integer x){


        int i = 0;
        for(i=10; i > 10 ; i++){

        }

        String a = null;
        Collection<String>  b = null;

        for (String aa:b){

        }



        Integer y = x + 10;
        x++;
        System.out.println(x);
        return y;
    }

}

interface XX {
    public static final int i = 10;

    public abstract void mq();

    public   void m10();


}