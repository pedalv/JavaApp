package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 10/05/15.
 */
public class Q1 {

    public static void main(String ... args){

        int [] scores = {1, 2, 3, 4, 5, 6};
        System.arraycopy(scores, 2, scores, 3, 2);
        for(int i : scores)
            System.out.print(i);

    }


}
