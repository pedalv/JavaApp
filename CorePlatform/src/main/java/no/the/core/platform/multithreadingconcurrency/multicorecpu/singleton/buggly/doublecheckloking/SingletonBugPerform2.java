package no.the.core.platform.multithreadingconcurrency.multicorecpu.singleton.buggly.doublecheckloking;

public class SingletonBugPerform2 {
    private static volatile SingletonBugPerform2 instance; //read

    private SingletonBugPerform2() {}

    //Solution for multiples CPUs:
    // - now read and write are synchronized
    // - we have the same performance issues
    public static synchronized  SingletonBugPerform2 getInstance(){

        if(instance == null) //read
            instance = new SingletonBugPerform2(); //write

        return instance;
    }

    //instance hold the key for no static methods

    //object hold the key for blocks, synschronizes(obj) {...}


}
