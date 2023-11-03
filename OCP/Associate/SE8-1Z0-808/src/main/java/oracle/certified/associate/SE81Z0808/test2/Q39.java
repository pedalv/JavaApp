package oracle.certified.associate.SE81Z0808.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p on 31/05/2015.
 */
public class Q39 {

    public static void main(String ... args){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("mrx");
        String s = sb.toString();
        list.add(s);
        System.out.println(s.getClass());
        System.out.println(list.getClass());
    }


}
