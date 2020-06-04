package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 23/05/15.
 */
public class Q60 {
    public static void main(String args[]){
        Bang mc = new BigBang();
    }
}

abstract class Bang {
    abstract void f();
    final void g() {}
    //final void h(){}
    protected static int i;
    private int j;
}

final class BigBang extends Bang{

    //BigBang(int n){m = n;}

    @Override
    void f() {

    }

    void h(){}
    void k(){i++;}
    //void l(){j++;}
    int m;
}