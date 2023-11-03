package oracle.certified.associate.SE81Z0808.test1;

/**
 * Created by p on 09/05/2015.
 */
public class Q1 {

    public static void main(String ... arg){

        try{
           new TestExceptionOutPut().m1();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("1.1-----" + e);

            System.out.println("1.2-----" + e.getMessage());
        }

        try {
            new TestExceptionOutPut().mmy1();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("2.1-----" + e);

            System.out.println("2.2-----" + e.getMessage());
        }
    }
}

class TestExceptionOutPut extends MyException{
    public TestExceptionOutPut(String msg) {
        super(msg);
    }

    public TestExceptionOutPut() {
        super();
    }

    public  void m1() throws Exception {
        throw new Exception();
    }
    public  void mmy1() throws MyException {
        throw new MyException("JJJJJJJJJ");
    }


}


class MyException extends Exception{

    public MyException(String msg){
        super(msg);
    }

    public MyException() {

    }
}