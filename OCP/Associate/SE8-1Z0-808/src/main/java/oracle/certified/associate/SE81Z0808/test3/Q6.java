package oracle.certified.associate.SE81Z0808.test3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by p on 25/05/2015.
 */
public class Q6 {

    public static void main(String ... args){
        LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);
        LocalDate d2 = LocalDate.of(2015, 2, 5);
        LocalDate d3 = LocalDate.now();
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);






    }





}
