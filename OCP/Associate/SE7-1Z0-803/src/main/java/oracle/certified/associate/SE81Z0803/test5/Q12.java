package oracle.certified.associate.SE81Z0803.test5;

/**
 * Created by pedro alves on 22/03/15.
 */
public class Q12 {

    public static void main (String ... args){
        crazyloop0();

    }

    static void crazyloop0(){

        int c = 0;
        JACK:
        while ( c<8 ){

            JILL:
            {
                System.out.print(c);
                if (c > 3)
                    break JILL;
                else
                    c++;
            }
/*
- Would be valid only when it is within the block of code under the scope of the label JILL
- Without JILL: {}
  In this case, the scope of JILL extends only up till System.out.println(c);
and break JILL; is out of the scope of the label
 */
        }

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
