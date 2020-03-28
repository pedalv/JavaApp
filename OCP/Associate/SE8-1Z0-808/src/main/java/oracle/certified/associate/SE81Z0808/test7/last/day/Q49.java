package oracle.certified.associate.SE81Z0808.test7.last.day;

/**
 * Created by p on 11/06/2015.
 */
public class Q49 {

    static int a = 0;
    int b = 5;

    public void foo(){
        while(b>0){
            b--;
            a++;
        }
    }


    public static void main(String ... args){
        Q49 t1 = new Q49();
        t1.foo();

        Q49 t2 = new Q49();
        t2.foo();


    }


}
