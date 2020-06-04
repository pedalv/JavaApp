package oracle.certified.associate.SE81Z0808.test3;

/**
 * Created by p on 25/05/2015.
 */
public class Q53 {

    public static void main(String ... args){
       OBJ obj = new OBJ();
        System.out.println(obj.i);
 changeitvalues(obj);
        System.out.println(obj.i);

changeitreference(obj);

        System.out.println(obj.i);



    }


    private static void changeitvalues(OBJ o){
        o.i = 1;
    }

    private static void changeitreference(OBJ o){
        o = new OBJ();
        o.i = 2;
        o = null;
    }


}


class OBJ {

    int i = 0;
    double d = 0.0;
    float f = 0.0f;
    char  c = 'a';

}
