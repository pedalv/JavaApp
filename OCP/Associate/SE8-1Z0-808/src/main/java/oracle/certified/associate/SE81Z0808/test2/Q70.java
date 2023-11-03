package oracle.certified.associate.SE81Z0808.test2;

/**
 * Created by p on 01/06/2015.
 */
public class Q70 {

    public static void main(String ... args){
        Q70 q1 = new Q70();
        Q70 q2 = new Q70();

        System.out.println(q1.equals(q2));
        System.out.println(q1.hashCode());
        System.out.println(q1.hashCode() == q2.hashCode());
        System.out.println(q1 == q2);




    }


}
