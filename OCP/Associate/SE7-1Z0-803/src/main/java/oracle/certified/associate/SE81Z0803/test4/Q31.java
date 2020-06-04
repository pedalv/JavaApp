package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */

interface Bonzo{
    int type = 1;
}

public class Q31 implements Bonzo {

    public void m1(){}
    void m2(){}

    public Q31() {

    }

    public static void main(String ... args){

        String s = "pedro";

        System.out.println(
                " s: java.lang.String \n" +
                "(s instanceof java.util.Date)\n " +
                "Result:\n " +
                "java: inconvertible types\n" +
                        "  required: java.util.Date\n" +
                        "  found:    java.lang.String"

        );


        Object s1 = new String("pedro");

        if(!(s1 instanceof java.util.Date)){
            System.out.println(
                    "\n\n s1: java.lang.Object \n" +
                            "(s1 instanceof java.util.Date)\n " +
                            "Result:\n " +
                            "It COMPILE, but s1 is NO instanceof Date"
            );
        }

        for(int i = 0; ; ++i);

        /*
        // unreacheble statement

        do{
            break;
        } while(true);

        for(int j = 1 ; false; j++){
            System.out.println("G");
        }

        */
    }

}
