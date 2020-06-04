package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q8 {


    public static void main(String ... args){
        System.out.println("");
        System.out.println("0.1");
        parseFloat("0.1");
        System.out.println("");
        System.out.println("0x.1");
        parseFloat("0x.1");
        System.out.println("");
        System.out.println("1");
        parseFloat("1");
        System.out.println("");
        System.out.println("0x1");
        parseFloat("0x1");
    }


    public static float parseFloat(String s){
        float f = 0.0f;
        try {
            f = Float.valueOf(s).floatValue();
            return f;
        } catch (NumberFormatException nfe){
            System.out.print("Invalid input " + s);
            f = Float.NaN;
            return f;
        } finally {
            System.out.print(" Finally ");
        }
        //return f;
        // java: unreachable statement
    }

}


