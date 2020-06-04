package oracle.certified.associate.SE81Z0803.test1;

/**
 * Created by p on 02/06/2015.
 */
public class Q64 {

    public  static void main(String ... args){
        String a = "java";
        char [] b = {'j','a','v','a'};
        String c = new String(b);
        String d = a;

        //boolean e1 =( b==d);//Error:(14, 24) java: incomparable types: char[] and java.lang.String
        boolean e2 = (a==d);//true
        boolean e3 = (a=="java");//true
        boolean e4 = a.equals(c);//true
        boolean e5 = (a==c);//false
    }
}

interface Account{
    public default String getId(){
        return "000";
    }

    default String getId2() {
        return "2222";
    }
}

interface PremiumAccount extends Account{

    String getId2();

    default String getId(){
       return "111";
    }

}


interface i {
    public void compute();

    static void computer(){
        System.out.println("computing...");
    }
}
