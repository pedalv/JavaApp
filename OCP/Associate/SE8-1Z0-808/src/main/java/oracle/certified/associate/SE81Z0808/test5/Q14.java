package oracle.certified.associate.SE81Z0808.test5;

/**
 * Created by p on 07/06/2015.
 */
public class Q14 {

    public static void main(String ... args){
        new LoopTest().printThem();

    }




}

class LoopTest {

    int k = 5;

    public boolean checkIt(int k){
        return k-- > 0 ? true : false;
    }

    public void printThem() {
        while(checkIt(k)){
            System.out.println(k--);
        }
    }

}