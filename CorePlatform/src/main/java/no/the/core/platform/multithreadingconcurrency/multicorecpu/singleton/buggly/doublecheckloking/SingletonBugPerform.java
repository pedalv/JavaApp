package no.the.core.platform.multithreadingconcurrency.multicorecpu.singleton.buggly.doublecheckloking;

public class SingletonBugPerform {

    private static SingletonBugPerform instance;

    private SingletonBugPerform() {}

    //class object hold the key
    //Good solution until two CPUs
    //More than 2 CPUS we have performance issues
    //only one T of n Ts can access to getInstance method
    public static synchronized SingletonBugPerform getInstance(){
        if(instance == null) //read
            instance = new SingletonBugPerform(); //write
        return instance;
    }

    //instance hold the key for no static methods

    //object hold the key for blocks, synschronizes(obj) {...}
}