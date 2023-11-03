package oracle.certified.associate.SE81Z0808.test5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by p on 09/06/2015.
 */
public class Q51 {

    public static void main(String[] args){
        Y y = new Z();

        System.out.println(LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));


    }
}


class X {
    {print(4,"X: no-static block");}
    int sx5 = print(5,"X: no-static var");
    final int sx6 = print(6,"X: no-static const var");

    static int sx = print(1,"x: static var");
    static final int sx2 = print(2,"X: static constant var");
    static {print(3, "x:static block");}


    public X(){
        System.out.println("In X");
    }

    public static int print(int i, String str){
        System.out.println(str);
        return i;
    }
}

class Y extends X {

    {print(4,"Y: no-static block");}
    int sx5 = print(5,"Y: no-static var");
    final int sx6 = print(6,"Y: no-static const var");

    static int sx = print(1,"Y: static var");
    static final int sx2 = print(2,"Y: static constant var");
    static {print(3, "Y:static block");}


    public Y(){
        super();
        System.out.println("IN Y");
    }
}

class Z extends Y{

    {print(4,"Z: no-static block");}
    int sx5 = print(5,"Z: no-static var");
    final int sx6 = print(6,"Z: no-static const var");

    static int sx = print(1,"Z: static var");
    static final int sx2 = print(2,"Z: static constant var");
    static {print(3, "Z:static block");}

    public Z(){
        System.out.println("In Z");
    }
}
//TODO
//1.ALL class -> static : 1. constants 2. variable 3. blocks appear for ALL CLASS
//2.1 CLASS -> no-static 1. constants 2. variables 3. blocks appear for each class
//2.2 CONSTRUCTOR CLASS -> constructor for each class