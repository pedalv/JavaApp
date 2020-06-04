package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 21/03/15.
 */
public class Q80 {
}


class Teacher {
    void teacher(String student){}
}

abstract class Prof extends Teacher{

    // Overloads
    public void teach() throws Exception{}
    private void teach(int i) throws Exception{}

    //overrides
    protected void teach(String s){}
    // or public abstract void teach(String s);
    public final void teacher(String s){}




}
