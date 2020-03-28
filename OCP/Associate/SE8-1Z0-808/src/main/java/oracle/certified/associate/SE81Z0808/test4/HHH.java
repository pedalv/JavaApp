package oracle.certified.associate.SE81Z0808.test4;

/**
 * Created by p on 13/06/2015.
 */
public class HHH {

    public static void main(String ... args){

        System.out.println(Boolean.parseBoolean("true") == true);
        System.out.println( new Boolean("no") == false);

        System.out.println(Boolean.parseBoolean("TrUe") == new Boolean(null));
        System.out.println(new Boolean("TrUe") == new Boolean(true));
        System.out.println(new Boolean("true") == Boolean.TRUE);

        System.out.println(new Boolean("true"));
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.parseBoolean("TrUe"));

        System.out.println(Boolean.parseBoolean("TrUe") == new Boolean(true));

        float f = 9898__7878.333_333f;
        System.out.println(f);




    }



}
