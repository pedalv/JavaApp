package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 22/03/15.
 */



public class Q84 {

    public static void main(String ... args){

        crazyloop1();


        crazyloop2();

    }


    static void crazyloop1(){

        int c = 0;
        JACK:
        while ( c<8 ){

            JILL: {
                System.out.println(c);
                if (c > 3)
                    break JACK;
                else
                    c++;
            }

        }

    }

    static void crazyloop2() {

        int c = 0;
        JACK:
        while (c < 8) {

            JILL:
            {
                System.out.println(c);
                for (int k = 0; k < c; k++) {
                    System.out.println("k = " + k + ", c = " + c);
                    if (c > 3)
                        break JACK;
                }
                c++;
            }
        }
    }



}
