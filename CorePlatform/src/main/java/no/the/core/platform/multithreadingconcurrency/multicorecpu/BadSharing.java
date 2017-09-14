package no.the.core.platform.multithreadingconcurrency.multicorecpu;

public class BadSharing {

    int x, y, r1, r2;

    Object lock = new Object();

    // it is writting x and y
    void firstMethod(){
        x = 1;
        synchronized (lock) {
            y = 1;
        }
    }

    // It is reading x and y to r2 and r1
    // If T run first the secondMethod
    //it is impossible say values for r1 and r2
    //because it could be 0 or 1
    void secondMethod(){
        synchronized (lock) {
            r1 = y;
        }
        r2 = x;
    }
}
