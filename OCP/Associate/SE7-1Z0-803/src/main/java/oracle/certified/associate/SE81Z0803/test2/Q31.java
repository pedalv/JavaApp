package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q31 {

    public static void main(String ... args){

        Integer a = new Integer(1);
        Integer b = new Integer(1);
        Integer c = new Integer(1);
        Double d = new Double(1);

        System.out.println(a.equals(a)); //OUT: true


        System.out.println(c.equals(b)); //OUT: true
        System.out.println(a.equals(b) + " må være"); //OUT: true (må være)

        System.out.println(a.equals(d)); //OUT: False, Integer not is a Double

    }

}

class Q23 {
    public static void main(String ... args){
        Integer i = new Integer(42);
        Long ln = new Long(42);
        Double d = new Double(42.0);

        //i == ln; // error: not a statement

        //ln == d; // error: not a statement


        System.out.println(i.equals(d)); //OUT: false

        System.out.println(d.equals(ln)); //OUT: False, Integer not is a Double

        System.out.println(ln.equals(42)); //OUT: False, Integer not is a Double


        //flags: error
        //if the compiler can figure out that something can NEVER happen

        //this case with d, ln, 42 it will be false
        //The conpiler knows that ln, i or d can never
        // pointer to the smae object in any case because
        // they are references to different class of objects
        // that have no relation (super/subclass)
        // between themselves
    }
}

//primitive wrapper class
//java.lan.Integer, Double, Float, etc, Object, String

//primitive data types:
// boolean, byte, short, char, int, long, double


