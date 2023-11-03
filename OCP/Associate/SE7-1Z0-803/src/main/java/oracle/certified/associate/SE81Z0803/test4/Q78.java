package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 21/03/15.
 */
public class Q78 {

    // a StringBuilder to have a capacity of at least 100 characters

    StringBuilder sb100 = new StringBuilder(100);

    static StringBuilder sbmore100 = new StringBuilder();

    public static void main(String ... args){
        sbmore100.ensureCapacity(100);
    }
}
