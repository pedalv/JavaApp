package oracle.certified.associate.SE81Z0803.test4;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by pedro alves on 21/03/15.
 */
public class Q32 {
}



class Q32A {
    Q32A() throws IOException{}
    void O() throws IOException{}
}

class Q32B extends Q32A{
    Q32B() throws IOException{}
    void O() throws IOException{}
}

class Q32C extends Q32A{
    Q32C() throws Exception{}
    //void O() throws Exception{}
    //Overriding a method: cannot throw a superclass exception
}

class Q32D extends Q32A{
    Q32D() throws IOException {}
    //Q32D() throws FileNotFoundException{}
    //Constructor:         cannot throw subclass exception
    void O() throws FileNotFoundException{}
}

/*
Overriding a method: cannot throw a superclass exception
Constructor:         cannot throw subclass exception



 */

