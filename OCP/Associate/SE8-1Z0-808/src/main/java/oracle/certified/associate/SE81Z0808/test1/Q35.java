package oracle.certified.associate.SE81Z0808.test1;

/**
 * Created by p on 02/06/2015.
 */
public class Q35 implements IInt {

    public static void main(String ... args){

        Q35 s = new Q35();
        int j = s.thevalue;//1
        int k = thevalue;//2
        int m = Q35.thevalue;//3
        int n = IInt.thevalue;//4
    }

}

interface IInt{
    int thevalue = 0;
}
