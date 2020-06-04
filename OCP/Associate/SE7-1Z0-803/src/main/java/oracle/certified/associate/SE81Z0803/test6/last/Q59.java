package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 23/05/15.
 */
public class Q59 {


    public static void main(String ... args){

        int i = 0;


        for(int j= 0; j<=10; j++){

            if(j%2 == 0) {
                continue;
            }
            {
                System.out.println(j);
            }
        }

        while(i <= 10) {
            i += 1;


            if(i%2 == 0) {
                continue;
            } else {
                System.out.println(i);
            }




        }

    }

}
