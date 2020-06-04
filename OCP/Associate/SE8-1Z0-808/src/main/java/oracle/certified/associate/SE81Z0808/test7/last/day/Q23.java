package oracle.certified.associate.SE81Z0808.test7.last.day;

/**
 * Created by p on 11/06/2015.
 */
public class Q23 {


    public static void main(String ... args) {
        House ci = new MyHouse();
        System.out.println(ci.getAddress());

        Bungalow cb = new MyHouse();
        System.out.println(cb.getAddress());


        I1 i1 = new CI();
        i1.m1();
    }
}


interface House{
    public default String getAddress(){
        return "101 Main Str";
    }
}

interface Bungalow extends House{
    public default String getAddress(){
        return "101 Smart Str";
    }
}

class MyHouse implements Bungalow, House{


}



interface I1{
    public default String m1(){
        System.out.println("in I1.m1");
        return "1";
    }
}

interface I2{
    public default String m1(){
        System.out.println("in I2.m1");
        return "2";
    }
}

class CI implements I1,I2 {

    public String m1() {
        System.out.println("no extends interfaces");
        return "3";
    }
}