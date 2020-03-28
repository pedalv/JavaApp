package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 23/05/15.
 */
public class Q50 {

    public static void main(String ... args) {

        boolean hasParams = (args == null ? false : true );
        if(hasParams){
            System.out.println("has params");
        }
        {{
            System.out.println("no params");
        }}


    }


}
