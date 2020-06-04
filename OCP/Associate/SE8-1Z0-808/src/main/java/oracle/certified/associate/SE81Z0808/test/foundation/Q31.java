package oracle.certified.associate.SE81Z0808.test.foundation;

/**
 * Created by p on 16/02/2017.
 */
public class Q31 {


    public static void main(String... args ) {
        StringBuilder b1 = new StringBuilder("snorkler");
        StringBuilder b2 = new StringBuilder("yoodler");

        //b1.append(b2.substring(2,5).toUpperCase());
        //b1=snorklerODL
        //b2=yoodler


        //b2.insert(3, b1.append("a"));
        //b1=snorklera
        //b2=yoosnorkleradler

        b1.replace(3,4,b2.substring(4)).append(b2.append(false));
        //   snolerkleryoodlerfalse
        //b1=snolerkleryoodlerfalse
        //b2=yoodlerfalse




        int i = 0;
    }
}
