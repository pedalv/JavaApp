package oracle.certified.associate.SE81Z0808.test1;

/**
 * Created by p on 09/05/2015.
 */
public class Q18 {

}


class Type1Bozo implements Bozo{

    Type1Bozo(){

    }


    @Override
    public void jump() {

    }
}

interface Bozo {
    int type = 0;
    final int type1 = 0;
    public void jump();
}