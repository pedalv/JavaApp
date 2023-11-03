package no.the.core.platform.multithreadingconcurrency.pattern.racecondition;

public class LongWrapper {

    private Object key = new Object();
    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        synchronized (key) {
            return l; //fix access to read on field l
        }
    }

    public void incrementValue() {
        synchronized (key) { //fix access to read/write on some field l
            l = l + 1;
        }

        /*
            Note:
            - Volatile fix the read
            - Write need be synchronize
            - So this is the best solution here
         */
    }
}
