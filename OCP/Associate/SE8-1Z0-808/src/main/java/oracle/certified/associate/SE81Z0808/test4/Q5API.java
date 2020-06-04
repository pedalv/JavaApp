package oracle.certified.associate.SE81Z0808.test4;

/**
 * Created by p on 12/06/2015.
 */
public class Q5API {


    public static void main(String ... args){

        int i = 1_000___________000000;

        StringBuilder sb = new StringBuilder("12345678");
        System.out.println(sb.length());
        System.out.println(sb.toString());
        sb.setLength(5);
        System.out.println(sb.length());
        System.out.println(sb.toString());
        sb.setLength(10);
        System.out.println(sb.length());
        System.out.println(sb.toString());
        sb.ensureCapacity(100);
        System.out.println(sb.length());
        System.out.println(sb.toString());


    }




}
