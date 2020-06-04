package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 23/05/15.
 */
public class Q63 {

    static String s = "";

    public void m3(){}

    public static void m0(int a, int b){
        s+=a;
        //try{
            m2();
        //}catch(Exception e) {}
        m1(b);
    }

    public static void m1(int i){
        s+=i;
    }

    public static void m2(){
        throw new NullPointerException("aa");
    }

    public static void m(){
        m0(1,2);
        m1(3);
    }

    public static void main(String args[]){
        try{
            m();
        }catch(Exception e){
            System.out.println("1. " + e.getStackTrace());
            System.out.println("2. " + e.getClass());
            System.out.println("3. " + e);
            System.out.println("4. " + e.getMessage());
            //e.printStackTrace();
        }
        System.out.println("s: "+s);
    }

}
