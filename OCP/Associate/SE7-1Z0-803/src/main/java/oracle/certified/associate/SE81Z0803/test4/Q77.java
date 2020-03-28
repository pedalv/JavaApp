package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 21/03/15.
 */
public class Q77 {
}


interface Bozo{
    int type = 0;
    public void jump();
}

class Type1Bozo implements Bozo{

    Type1Bozo(){
        //type = 1; //cannot assign a value to final variable type
    }

    @Override
    public void jump() {

    }
}
