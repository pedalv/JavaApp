package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q7 {
}

//private class TC
//Viktig
// the file will not compile because TC is a top level class
//and privaye is not a valid access for a top class.
//
// private can be applied to an inner class.
//
/*private*/ class TC extends java.util.HashMap{
    public TC(){
        super(100);
        System.out.println("TC created");
    }
}

class TestClassQ7  extends TC {
    public TestClassQ7(){
        System.out.println("TestClass created");
    }
    public static void main(String ... args){
        new TestClassQ7();
    }
}
