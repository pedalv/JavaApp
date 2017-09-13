package no.the.core.platform.multithreadingconcurrency.pattern.racecondition;

public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    //class object hold the key
    public static synchronized Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    //instance hold the key for no static methods

    //object hold the key for blocks, synschronizes(obj) {...}


}
