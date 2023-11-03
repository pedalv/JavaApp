package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 23/05/15.
 */
public class Q62 {

    public static long main(String [] args){
        System.out.println("Hello");
        return 10L;
    }

    //When the program is run, the JVM looks for a method named main() which takes an array of Strings as input and returns nothing (i.e. the return type is void). But in this case, it doesn't find such a method ( the given main() method is returning long!) so it throws a java.lang.NoSuchMethodError. Note that java.lang.Error does not extend Exception class. It  extends java.lang.Throwable and so it can be "thrown".

}
