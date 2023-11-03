package oracle.certified.associate.SE81Z0803.test1;

/**
 * Created by pedro alves on 24/05/15.
 */
public class Q24 {

    public static void main(String [] args){
        System.out.println(new MNOP().x + ", " + new MNOP().y);

        System.out.println(new MNOP().x + ", " + MNOP.y);

        MNOP mnop = new MNOP();
        System.out.println(new MNOP().x + ", " + mnop.y);


    }

}


class ABCD{
    int x = 10;
    static int y = 20;
}

class MNOP extends ABCD{
    int x = 30;
    static int y = 40;
}