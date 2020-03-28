package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q21 {
    public Q21() {}
    public Q21(String s) {
        this();
        System.out.println("A: "+s);

    }
}

class B21 extends Q21{

    public int B1(String s) {
        System.out.println("B: "+s);
        return 0;
    }
}

class C21 extends B21 {
    private C21(){ super();}
    public C21(String s){this(); System.out.println("C :" + s);}
    public C21(int i) {}
}



class TestObjCreate{
    public static void main(String ... args){
        //new C21();// private: can not instanciate
        new C21("str");
        new C21(37);

    }
}