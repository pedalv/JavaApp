package oracle.certified.associate.SE81Z0808.test2.p2;

import oracle.certified.associate.SE81Z0808.test2.p1.Movable;

/**
 * Created by p on 31/05/2015.
 */
public class Donkey implements Movable {
    int location = 200;
    @Override
    public void move(int by) {
        location = location + by;
    }

    @Override
    public void moveBack(int by) {
        location = location - by;
    }
}
