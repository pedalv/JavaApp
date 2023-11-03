package no.the.core.platform.multithreadingconcurrency.pattern.running;

import no.the.core.platform.multithreadingconcurrency.pattern.deathlock.A;

public class DeathLockRunning {

    public static void main(String[] args) throws InterruptedException {

        A deathLock = new A();

        Runnable task1 = () -> deathLock.a();
        Runnable task2 = () -> deathLock.b();

        Thread t1 = new Thread(task1);
        t1.start();

        Thread t2 = new Thread(task2);
        t2.start();

        t1.join(); //block here for key2 Deadloccks *solution
        t2.join();
    }

    /*
        *solution
        - The solution is reboot the JVM,
        there is not must here we can do
         - T1 holds a key needed by a T2,
        and T2 holds the key needed by T1
     */
}
