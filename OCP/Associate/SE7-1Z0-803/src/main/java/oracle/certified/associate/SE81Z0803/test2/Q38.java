package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q38 {
}

class TestClass {

    public static void methosX() throws Exception {
        //throw new AssertionError();
        //throw new Exception();
        throw new Error();
    }


    public static void main(String ... args){
        try{
            methosX();
        } catch (Exception e){
            System.out.println("Exception");
        }
    }
}

// 1. Throwable
// 1.1 Error
// 1.1.1 AssertionError
// 1.1 Exception

//OUT:Exception in thread "main" java.lang.AssertionError