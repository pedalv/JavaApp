package oracle.certified.associate.SE81Z0803.testn;

/**
 * Created by pedro alves on 19/04/15.
 */
public class Q46 {

    public static void main (String ... args){

        MySub ms = new MySub(5){
            public void m1(){

            }
        };
    }

}


class MySuper{
    public MySuper(int i ){

    }
}

abstract class MySub extends MySuper{
    public MySub(int i){super(i);}
    public abstract void m1();
}
