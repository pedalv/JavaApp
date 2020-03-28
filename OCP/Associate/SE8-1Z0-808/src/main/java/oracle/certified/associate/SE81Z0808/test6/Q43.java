package oracle.certified.associate.SE81Z0808.test6;

/**
 * Created by p on 11/06/2015.
 */
public class Q43 {

    static int p =0;
    public static Integer wiggler(Integer x){


        Integer y = x + 10;
        x++;
        System.out.println(x);
        return y;
    }

    public static int add(ObjInt o) {
        o.i++;
        o.i = 10;
        return 5;
    }

    void a(){
        int a = p;
    }

    public static void main(String ... args){
        Integer dataWrapper = new Integer(5);
        Integer value = wiggler(dataWrapper);
        System.out.println(dataWrapper+value);
        ObjInt o = new ObjInt();

        System.out.println(add(o));



    }

}


class ObjInt {
    int i;
}

