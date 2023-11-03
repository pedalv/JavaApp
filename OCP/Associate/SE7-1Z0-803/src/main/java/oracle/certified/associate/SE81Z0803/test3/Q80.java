package oracle.certified.associate.SE81Z0803.test3;


import java.io.IOException;
import java.security.spec.ECField;
import java.sql.SQLException;

/**
 * Created by pedro alves on 07/03/15.
 */
public class Q80 {

    public static void main(String ... args) throws Exception {

        try {
            m1();
        } catch(IndexOutOfBoundsException e) {
            System.out.println("1");
            throw new NullPointerException();
            //try {
                //throw new Exception();
            //} catch (Exception e1) {
              //  e1.printStackTrace();
            //}
        } catch (NullPointerException e){
            System.out.println("2");
        } catch (Exception e){
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
        System.out.println("END");
    }

    static void m1(){
        System.out.println("m1 Starts");
        throw new IndexOutOfBoundsException("Big Bang");
    }


}

class ExceptionJava8 {

    public void exception(){
        try{
            int i = 1/0;

        } catch(  ArithmeticException | NullPointerException e){

        }
    }
}