package no.the.core.platform.multithreadingconcurrency.multicorecpu.singleton.buggly.doublecheckloking;

public class SingletonBugRead {
    private static SingletonBugRead instance;

    private static Object key = new Object();

    private SingletonBugRead() {}

    // Note: DOUBLE CHECK PATTERN has a bug
    // - read is not synchronized
    // BAD solution for multiples CPUs:
    // - two threads could be create
    //because read is not synchronize
    public static SingletonBugRead getInstance(){

        if(instance != null) //read
            return instance;

        synchronized (key){
            if(instance == null) //read
                instance = new SingletonBugRead(); //write
        }

        return instance;
    }

    //instance hold the key for no static methods

    //object hold the key for blocks, synschronizes(obj) {...}
}