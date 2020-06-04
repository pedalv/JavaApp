package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 28/02/15.
 */
public class Q36 {

    public static void main(String ... args){
        loop:
        for(int i = 0; i < 2; i++){

            System.out.println("i: " + i);


            for(int j = 0; j < 2; j++){

                System.out.println("i: " + i + ", j: " +j);

                break loop;

            }




        }


    }




}
