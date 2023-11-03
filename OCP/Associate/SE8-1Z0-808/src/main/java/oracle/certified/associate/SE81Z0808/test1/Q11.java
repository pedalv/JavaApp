package oracle.certified.associate.SE81Z0808.test1;

/**
 * Created by p on 01/06/2015.
 */
public class Q11 {
    String str ="";

    public static void main(String ... args){

        Q11 q = new Q11();

        String myStr = "good";

        char [] myCharArr = {'g','o','o','d'};

        String newStr = null;
        for ( char ch: myCharArr){
            newStr = newStr + ch;
            q.str = q.str  + ch;
        }


        System.out.println((newStr == myStr) + "  " + (newStr.equals(myStr)));
        System.out.println((q.str == myStr) + "  " + (q.str.equals(myStr)));




    }


}
