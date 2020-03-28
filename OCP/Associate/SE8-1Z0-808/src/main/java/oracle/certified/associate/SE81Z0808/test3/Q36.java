package oracle.certified.associate.SE81Z0808.test3;

/**
 * Created by p on 30/05/2015.
 */
public class Q36 {

    public static void main(String ... args){
        Q36 q = new Q36();

        System.out.println(q);//test3.Q36@4554617c




    }

    @Override
    public String toString() {

        String str = getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                " --- " +
                "PEDRO Q36";
        return str;
    }
}
