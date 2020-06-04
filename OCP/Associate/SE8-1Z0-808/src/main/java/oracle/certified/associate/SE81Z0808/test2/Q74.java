package oracle.certified.associate.SE81Z0808.test2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by p on 01/06/2015.
 */
public class Q74 {

    public static void main(String ... args){

        LocalDateTime dt = LocalDateTime.parse("2015-06-01T19:14:55");
        System.out.println(dt);

        dt = LocalDateTime.parse("2015-06-01T19:15:55");
        dt.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(dt);

        dt = LocalDateTime.parse("2015-06-01T19:16:55");
        dt.toString();
        System.out.println(dt);

        //return the date string in ISO 8601 format?

        dt = LocalDateTime.parse("2015-06-01T19:17:55");
        dt.format(DateTimeFormatter.ISO_DATE);
        System.out.println(dt);
    }



}
