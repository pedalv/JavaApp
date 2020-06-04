package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 21/03/15.
 */
public class Q66 {

    public static void main(String ... args){

        Integer i = new Integer(1);
        Long m = new Long(1);
        if( i.equals(m) ) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

        //if(i instanceof Long){}

        Q66A ac = new Q66A();
        Q66B ab = new Q66B();
        if( ac.equals(ab) ) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }


    }

}
/*

    boolean equals(Object o);
    - so it can take any object
    - the equals method of all wrapper classes first:
     1. check if the two object are of the same class or not
     if not, they immediately return false

 */

class Q66A {
    Integer a = new Integer(1);
}

class Q66B extends Q66A{
    Integer b = new Integer(1);
}