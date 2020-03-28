package oracle.certified.associate.SE81Z0803.testn;

/**
 * Created by pedro alves on 25/01/15.
 */
public class TestTry {

    public static void main (String ... args) throws Exception {


        try{
            m1();
            System.out.println("A");
        }
        catch (Exception e){
            System.out.println("e");
            System.exit(0);
        }
        finally{
            System.out.println("B");
        }
        System.out.println("C");
    }

    private static void m1() throws Exception {
        throw new Exception();
    }
}
