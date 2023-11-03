package oracle.certified.associate.SE81Z0803.testn;

/**
 * Created by pedro alves on 25/01/15.
 */
public class Overloadtest {

    static int i = 10;

    void m1(int x){
        System.out.println("int");
    }

    void m1(double x)  {
        System.out.println("doubleß");
    }

    static int hei(int d) {
        return d;
    }

    public static void main(String ... args) {

        short B = 10;
        Overloadtest a = new Overloadtest();
        a.m1(2.0f);

    }
}

class B1 extends Overloadtest {

    //static int i = 11;

    static int hei() {
        return 11;
    }


    public B1() {

    }

}

class C extends B1 {

    public static void main(String ... s) {
        int i = C.hei(99);
        System.out.println(i);
    }

}

class D{
    int String;
    int ArrayList;

    int i = 10;
    static int j = 10;
    public static void play() throws Exception {
        System.out.println("Play A");
    }
}

class E extends D {
    int i = 1;
    static int j = 1;
    public static void play()  {
        System.out.println("Play B");
    }

    public static void main(String ... args){

        try {
            D.play();
            System.out.println(new D().i + " " + D.j);
            System.out.println(new E().i + " " + E.j);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
