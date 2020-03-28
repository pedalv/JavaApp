package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 21/02/15.
 */
public class Q32 {


    public static void main(String ... args){

        String mStr = "123";

        long m = new Long(mStr);
        System.out.println(m);

        m = Long.parseLong(mStr);
        System.out.println(m);

        m = Long.valueOf(mStr).longValue();
        System.out.println(m);

    }



}
