package oracle.certified.associate.SE81Z0803.test1;

/**
 * Created by p on 02/06/2015.
 */
public class Q75 {

    public static void main(String args[]){

        C c = new C();
        System.out.println(((A)c).i);
        //System.out.println(((A)c).j);
        //System.out.println(new A().j);//Error:(13, 35) java: j has private access in test1.A
        System.out.println(((A)c).w);
        System.out.println(c.k);


        Integer i1 = 1;
        Integer i2 = new Integer(1);
        int i3 = 1;
        Byte b1 = 1;
        Long g1 = 1L;


        boolean e1 = (i1 == i2); // false
        boolean e2 = (i1 == i3); // true
        //boolean e3 = (i1 ==b1);//Error:(29, 26) java: incomparable types: java.lang.Integer and java.lang.Byte
        boolean e31 = i1.equals(b1);//false
        boolean e4 = i1.equals(i2);//true
        boolean e5 = i1.equals(b1);//false

    }

}


class A {
    public int i = 10;
    private int j = 20;
    int w = 30;
}

class B extends A {
    private int i = 30;
    public int k = 40;
}

class C extends B{}