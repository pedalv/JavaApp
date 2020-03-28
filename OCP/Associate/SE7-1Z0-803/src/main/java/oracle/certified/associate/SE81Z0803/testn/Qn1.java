package oracle.certified.associate.SE81Z0803.testn;

/**
 * Created by pedro alves on 22/03/15.
 */
public class Qn1 {
}

class Testing {

    public Testing(String s) {

    }

}

class Q84 extends Testing {

    public Q84(int i)
    {

        this();// I can either call supper(...) or this(...) but not both at first line in a constructor
    }

    public Q84()
    {
        super("");// I can either call supper(...) or this(...) but not both at first line in a constructor
        System.out.print("sa");
    }

    static public void ms() {}
    public void m()  {}
    public void m1()  {
        this.m(); //this is possible call a method
        // Note: that is not static
    }

    public static void main(String ... args){

        int i[]={1,2};
        int index1 = 0;

        // I cannot assign a variable in a for loop. index1 give a compile error, not a statement
        for(int index: i){
            System.out.println(index);
        }

        //  System.out.println(args[0]);
        // It give a ArrayIndexOutOfBoundsException when args has no parameters

        try{
            throw new Exception("geir");
        } catch(Exception e){
            System.out.println(e);// OUT: java.lang.Exception: geir
            e.printStackTrace();// OUT: [Ljava.lang.StackTraceElement;@34d704f0
            System.out.println(e.getStackTrace());
        }

        System.out.println("----OKAY----");

    }


}
