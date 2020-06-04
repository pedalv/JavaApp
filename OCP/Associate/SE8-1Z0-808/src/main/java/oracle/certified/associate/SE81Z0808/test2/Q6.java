package oracle.certified.associate.SE81Z0808.test2;

import oracle.certified.associate.SE81Z0808.test2.p1.Movable;
import oracle.certified.associate.SE81Z0808.test2.p2.Donkey;

/**
 * Created by p on 31/05/2015.
 */
public class Q6 {

    public static void main(String ... args){
        Movable m = new Donkey();
        m.move(10);
        m.moveBack(20);
        System.out.println(m.location);
    }
}
