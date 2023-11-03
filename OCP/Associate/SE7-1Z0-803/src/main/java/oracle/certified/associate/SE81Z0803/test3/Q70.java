package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 07/03/15.
 */
public class Q70 {
    public static void main(String [] args){
        final Holder a = new Holder(5);
        Holder b = new Holder(10);
        a.link = b;
        b.link = setIt(a,b);
        System.out.println(a.link.value+" " + b.link.value);
    }

    private static Holder setIt(final Holder x, Holder y) {
        x.link = y.link;
        return x;
    }
}

class Holder {
    int value = 1;
    Holder link;
    public Holder(int val) {this.value = val;}
}
