package oracle.certified.associate.SE81Z0808.test6;

/**
 * Created by p on 11/06/2015.
 */
public class Q24 {

    public static void main(String ... args){
        crazyLoop();
    }


    static void crazyLoop() {
        int c = 0;
        JACK:
        while (c < 8) {
            JILL:
            System.out.println(c);
            if (c > 3) break JACK;
            else c++;
        }
    }



}
