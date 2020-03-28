package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q3 {
    // String objects are immutable
    // immutable
    // No matter what operation you do,
    // the original object will remain the same
    // and a new object will be returned
    //
    // The statement str1.concat(str2)
    // creates a new String object which is printed
    // but its reference is lost after the printing


    final public static int Geir() {
        return 1;
    }

    final static public  int Geir2() {
        return 1;
    }
    public static void main(String ... args){
        String str1 = "str1";
        String str2 = "str2";
        System.out.println(str1.concat(str2));
        System.out.println(str1);
    }
}
// OUT: The rogram will print "str1str2" and "str1"