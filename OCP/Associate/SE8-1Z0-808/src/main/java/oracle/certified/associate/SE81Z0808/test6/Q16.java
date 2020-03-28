package oracle.certified.associate.SE81Z0808.test6;

/**
 * Created by p on 11/06/2015.
 */
public class Q16 {

    public static void main(String ... args){

        try {

            m1();
        } catch(SomeThrowable e){
            try{
                throw e;
            } catch(SomeThrowable e1) {}
        } finally {
          System.out.println("Done");
        }



    }

    private static void m1() throws MyThrowable{
        throw new MyThrowable();
    }

}


class SomeThrowable extends Throwable {}

class MyThrowable extends SomeThrowable {}

