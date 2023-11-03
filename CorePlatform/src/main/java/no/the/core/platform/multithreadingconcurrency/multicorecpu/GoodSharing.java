package no.the.core.platform.multithreadingconcurrency.multicorecpu;

public class GoodSharing {
    /*
        Note:
        - All share variables should be access in
        a synchronized or a volatile way
     */
}

class BadShraring {
    private int index;

    //WRITE
    void increment() { //Race condition problem
        index++;
    }
    //READ
    void print() { //Race condition problem
        System.out.println(index);
    }
}

class GoodSharing1 {
    private int index;

    //WRITE
     synchronized void increment() { //Fix race condition
        index++;
    }
    //READ
    synchronized void print() { //Fix race condition
        System.out.println(index);
    }
}

class GoodSharing2 {
    private volatile int index; //Fix race condition

    //WRITE
    void increment() {
        index++;
    }
    //READ
    void print() {
        System.out.println(index);
    }
}
