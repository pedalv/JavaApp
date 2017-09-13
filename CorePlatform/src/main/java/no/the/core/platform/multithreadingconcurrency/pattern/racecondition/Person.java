package no.the.core.platform.multithreadingconcurrency.pattern.racecondition;

public class Person {

    private String name;
    private int age;

    public String getName() {
        synchronized (name) {
            return name;
        }
    }

    public int getAge() {
        synchronized ((Object)age) {
            return age;
        }
    }

    /*
        synchronize block - OKAY
        - two threads can access to getAge and getName at the same time

        synchronize method
        - only one thread can access to one for the methods at the same time

        two instance of Person
        - one thread can access to getName from one instance and other thread can access getName from other instance
        - Solution for only one thread from n threads can access at one person instance
        => private static synchronized Person person1
        => private static synchronized Person personn

        Note: Locks are reentrant
        - When a thrad holds a lock, it can enter a block
        synchronized on the lock it is holding

        Deadloccks
        - a thread T1 holds a key needed by a thread T2,
        and T2 holds the key needed by T1
        Solution:
        - if it happens the solution is reboot the JVM,
        there is not must here we can do
        - it is difficulty find where the problem is located,

     */
}
