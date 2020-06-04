package oracle.certified.associate.SE81Z0803.test4;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pedro alves on 08/03/15.
 */
public class Q53 {

    public static void main(String ... args) throws Exception{


        String substr = "emptiness".substring(9);
        System.out.println("out: " + substr + ", len: " + "emptiness".length());


        String test = "01234567";
        System.out.println(test.substring(4, 7));


        for (; ; ){
          System.out.println("i");
                break;
        }


        int a [] = {0,1};
        System.out.println(a.getClass().isArray());
        System.out.println(a[0]);



        //Exception e = null;
        //throw e;

        //blockLabel();

        List<CheckBox> list = new ArrayList<>();

        System.out.println(10.0f);
    }

    private static void blockLabel() {
        System.out.println("Entering");

        int c = 0;
        JACK: while (c < 8) {


            JILL: {
                System.out.println(c);

                if (c > 3) {
                    break JILL;
                }
                else {
                    c++;
                }
            }
        }
    }

}
