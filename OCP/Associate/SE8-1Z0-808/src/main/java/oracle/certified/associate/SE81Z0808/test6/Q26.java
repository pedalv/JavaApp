package oracle.certified.associate.SE81Z0808.test6;

/**
 * Created by p on 11/06/2015.
 */
public class Q26
{
    public static void main(String ... args){
        Automobile a = new Automobile();
        Truck t = new Truck();
        a.drive();
        t.drive();
        a = t;
        a.drive();
        t = (Truck) a;
        t.drive();
    }



}

class Automobile{
    public void drive(){
        System.out.println("Automobile: drive");
    }
}

class Truck extends Automobile{
    public void drive(){
        System.out.println("Truck: drive");
    }
}