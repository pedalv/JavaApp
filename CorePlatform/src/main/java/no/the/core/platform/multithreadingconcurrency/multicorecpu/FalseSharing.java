package no.the.core.platform.multithreadingconcurrency.multicorecpu;

/*
    FalseSharing:
    - It happens because of the way the CPU caches work
    - the cacahe is organized in line of data that can hold 8 longs (64 bytes)
    - When a visible variable is modofied in an L1 cache,
    all the line is marked "dirty" for the other caches
*/
public class FalseSharing {

    long a,b;

    void firstMethod(){
        a++;
        // Core 1 - Cache L1 - ab
        // - T1 increment a and others cache is marked as dirty
    }

    void secondMethod(){
        b++;
        // Core 2 - Cache L1 - ab
        // - T2 need go to main memory to fetch variable b
        //that take longer access
        //and information could be outdate
    }


}
