package oracle.certified.associate.SE81Z0808.test3;

/**
 * Created by p on 30/05/2015.
 */
public class Q74 {

    public static void main(String ... args)
    {
        int i = 20;
        for(i = 0; i < 10; i++)// int i = 0 PROBLEMS with redeclaration i
            System.out.println(i);

        System.out.println("i: " + i);

    }


}
