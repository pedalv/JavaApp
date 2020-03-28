package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q14 {

    //booleans
    //are initialized to false

    // numeric types
    // to 0

    // object references
    // to null

    // elements arrays
    // are initialized to the default values of their types
    // so,
    // elements of a boolean array are initialized to false
    // int, char, float to 0
    // Object to null

    static boolean b; //false;
    static boolean [] ba = new boolean[1]; // false
    static int i;// 0
    static int [] ia = new int[1];// 0
    static char c;//0 => whit space, 65 => A, 97 => a
    static char [] ca = new char[1];// 0
    static float f; // 0
    static float [] fa = new float[1];// 0
    static String s; // null
    static String [] sa = new String[1];// null

    public static void main(String ... args){

        System.out.println(
            "b: " + b + ", ba: " + ba[0] +
            ", i: " + i + ", ia: " + ia[0] +
            ", c: " + c + ", ca: " + (int)ca[0] +
            ", f: " + f + ", fa: " + fa[0] +
            ", s: " + s + ", sa: " + sa[0]
        );



    }

}
