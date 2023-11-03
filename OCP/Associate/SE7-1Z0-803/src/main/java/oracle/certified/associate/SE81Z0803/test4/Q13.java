package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q13 {

    /*
    Covariante returns are allowed since 1.5,
    which means that an overriding method can
    change the return type to a subclass of the
    return type declared in the overridden method.

     But remember that covarient returns does not
     apply to primitives.
     */


    public static void main(String ... args){
        Base b = new Base2();
        System.out.println(b.getValue());
    }

}


class Base {
    public Object getValue(){
        return new Object();
    }
}

class Base2 extends Base {
    public String getValue(){
        return "hello";
    }
}