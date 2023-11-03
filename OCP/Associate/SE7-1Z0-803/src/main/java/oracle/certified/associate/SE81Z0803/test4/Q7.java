package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q7 {
}

class Widget {

    static int MAX = 111;
    static final String CLASS_GUID = "XYZ123";
    static int MAXFINAL;

    //1.
    // static variables can be left without initializing
    // (They will get default values)

    //2.
    // final variables must be explicitly initialized
    // Now, gere CLASS_GUID is a "static final" variable and
    //not just final or static. As static fields can be accessed
    // even without creating an instance of the class, it is entirely
    //possible that this field can be accessed before even a single
    // instance is created. In this case, no constructor or non-static
    // initializer had ever been called.
    // And so, the field (as it is fina so must be initialized
    // explicitly) remains uninitialized. This cause the
    // compiler to complain.


    Widget(){
        MAX = 112;
        MAXFINAL = 113;
        //CLASS_GUID = "123";
        // java: cannot assign a value to final variable CLASS_GUID

    }

    Widget(int k){
        MAX = 112;
        MAXFINAL = 113;
        // only static
        // it cannot wait till the constructor executes to be initialized
    }

    public static void printstatic(){
        System.out.println("It cannot wait till the constructor executes to be initialized, MAXFINAL: " + MAXFINAL);
    }

    public static void main(String ... args){
        printstatic();// WORKS!!!!!

        //new Widget();
        //new Widget(6);
    }

}
