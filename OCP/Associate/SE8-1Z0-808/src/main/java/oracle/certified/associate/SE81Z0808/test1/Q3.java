package oracle.certified.associate.SE81Z0808.test1;

/**
 * Created by p on 01/06/2015.
 */
public class Q3 {

    public static void main(String ... args){
        InitTest it = new InitTest();
    }

}

class InitTest{
    public InitTest(){
        s1 = sM1("1");
    }

    static String s1 = sM1("a");

    String s3 = sM1("2");

    {s1 = sM1("3");}

    static {s1 = sM1("b");}

    static String s2 = sM1("c");

    String s4 = sM1("4");

    private static String sM1(String s){
        System.out.println(s);
        return s;
    }


}