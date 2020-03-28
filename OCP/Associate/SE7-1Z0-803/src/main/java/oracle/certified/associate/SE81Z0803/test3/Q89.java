package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 07/03/15.
 */
public class Q89 {

    public static void main(String ... args) throws StringIndexOutOfBoundsException{

        StringBuilder sb = new StringBuilder("1234567890");

        System.out.println(sb + ", len: " + sb.length());

        sb.setLength(5);
        System.out.println(sb + ", len: " + sb.length());

        sb.setLength(10);
        System.out.println(sb + ", len: " + sb.length());

       // try {
            sb.setLength(-10);
            System.out.println(sb + ", len: " + sb.length());
        //} catch(StringIndexOutOfBoundsException e){
          //  System.out.println(e.getMessage());

        //}

    }


}
