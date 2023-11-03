package no.the.core.platform.multithreadingconcurrency.pattern.racecondition;

public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    //class object hold the key
    //Good solution until two CPUs
    //More than 2 CPUS we have performance issues
    //only one T of n Ts can access to getInstance method
    public static synchronized Singleton getInstance(){
        if(instance == null) //read
            instance = new Singleton(); //write
        return instance;
    }

    //instance hold the key for no static methods

    //object hold the key for blocks, synschronizes(obj) {...}
}