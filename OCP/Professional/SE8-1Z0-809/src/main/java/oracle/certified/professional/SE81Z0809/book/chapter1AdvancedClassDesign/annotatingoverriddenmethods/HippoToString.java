package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.annotatingoverriddenmethods;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

public class HippoToString {

    private String name;
    private double weight;

    public HippoToString(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        //return "Name: " + name + ", Weight: " + weight;
        // OUTPUT:
        // Name: Harry, Weight: 3100.0

        //return ToStringBuilder.reflectionToString(this);
        // OUTPUT:
        // no.book.chapter1AdvancedClassDesign.annotatingoverriddenmethods.HippoToString@d716361[name=Harry,weight=3100.0]

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        // OUTPUT:
        // HippoToString[name=Harry,weight=3100.0]

    }

    public static void main(String[] args) {

        HippoToString h1 = new HippoToString("Harry", 3100);
        System.out.println(h1); // Harry

        /*
        ArrayList provided an implementation of toString() that listed the contents of the
            ArrayList, in this case, an empty ArrayList.
        (If you want to be technical about it, a superclass of ArrayList implemented toString()
            and ArrayList inherited that one instead of the one in Object, whereas the array used
            the default implementation from Object.)
         */
        System.out.println(new ArrayList()); // []
        System.out.println(new String[0]); // [Ljava.lang.String;@65cc892e
    }

}
