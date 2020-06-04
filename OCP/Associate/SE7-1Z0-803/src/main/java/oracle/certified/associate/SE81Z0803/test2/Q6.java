package oracle.certified.associate.SE81Z0803.test2;

/**
 * Created by pedro alves on 07/02/15.
 */
public class Q6 {
    public static void main(String ... args){
        X x = new X();
        x.setNull();
        // any instance can be made eligible by setting all
        // its references to null


        x = null;
        // the contained object become eligible for GC
        // The following code, up - the instance of X and the object
        //instance contained inside X, will become eligible for GC
    }


}

class X {
    Object o = new Object();
    public void setNull() {
        o = null;
        // the Object instance referrer to by "o",
        // can be made eligivel for GC by calling setNull(),
        // even if the instance of X itself is not eligible for GC
    }

}


class M {}

class N {
    private M m = new M();

    public void makeItNull(M pM){
        pM = null;
    }

    public void makeThisNull(){
        makeItNull(m);
    }

    public static void main(String ... args){
        N n = new N();
        n.makeThisNull();
    }
}
//n = N@425
// m = M@427
//pm = M@427 => null (scope only inside makeItNull(M pM) method)
// Viktig
// pass vy value in java for wrapper class and primitives