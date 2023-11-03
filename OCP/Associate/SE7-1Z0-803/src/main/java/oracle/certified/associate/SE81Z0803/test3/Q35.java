package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 28/02/15.
 */
public class Q35 {

    public static void main(String ... args){
        new A1().m1(1);
        new A2().m1(1);
    }

}

class A1 {
    public double m1(int a){
        System.out.println(a*(10/4)-30);
        return a*(10/4)-30;
    }
}

class A2 extends A1{
    public double m1(int a){

        System.out.println(10/4.0);
        System.out.println(a*10/4.0);
        return a*10/4.0;
    }
}
