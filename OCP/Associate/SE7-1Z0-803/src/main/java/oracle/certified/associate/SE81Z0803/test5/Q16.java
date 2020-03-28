package oracle.certified.associate.SE81Z0803.test5;

/**
 * Created by pedro alves on 22/03/15.
 */
public class Q16 {

}


interface Worker{
    void performWork();
}

class FastWorker implements Worker {

    @Override
    public void performWork() { }

    /*
    I am creating a class tha follows
    "program to an interface"
     */
    public Worker getWorker(){
        return new FastWorker();
    }

}
