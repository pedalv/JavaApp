package no.the.core.platform.multithreadingconcurrency;

import no.the.core.platform.multithreadingconcurrency.collable.PollThreadCollable;
import no.the.core.platform.multithreadingconcurrency.concurrency.notrunnable.PollThreadConcurrency;
import no.the.core.platform.multithreadingconcurrency.concurrency.runnable.PollThreadConcurrencyRunnable;
import no.the.core.platform.multithreadingconcurrency.concurrency.runnable.PollTxThreadConcurrencyRunnable;
import no.the.core.platform.multithreadingconcurrency.notimplements.PollThreadRunnable;
import no.the.core.platform.multithreadingconcurrency.runnable.MultipleThreadRunnable;
import no.the.core.platform.multithreadingconcurrency.runnable.PollThreadRunnableLoop;

import java.time.*;

public class Main{

    public static void main(String ... args) {
        Instant start = Instant.now();

        //SingleThread.runInsideMain();               // 36 sec - 1 thread
        //MultipleThreadRunnable.createandwait();     // 24 sec - n threads, BUT CREATE FOR LOOP
        //MultipleThread.createwait();             // 06 sec - n threads, NEW INSTANCY
        //PollThreadRunnable.createwait();            // 08 sec - 2 threads max
        //PollThreadRunnableLoop.createandwait();         // 24 sec - 2 threads max, BUT CREATE FOR LOOP
        //PollThreadCollable.createandFuture();       // 24 sec - 2 threads max, BUT CREATE FOR LOOP
        //PollThreadConcurrencyRunnable.createwait(); // 40 sec - 6 threads max, BUT CREATE FOR LOOP
        //PollThreadConcurrency.createwait();         // 4 sec - 2 threads max, NEW INSTANCY
        PollTxThreadConcurrencyRunnable.userAccount();

        Instant end = Instant.now();
        long seconds = Duration.between(start, end).getSeconds();
        System.out.println(String.format("seconds: %d",seconds));
    }
}


/*

java 1.0:   Threads and locks
java 5:     Threads pools
            Concurrent collections
java 7:     Fork/join framework
java 8:     Parallelism
            - the streams API
            - techniques for passing code to methods
            - default method in interfaces


 Concurrency safe collection access
 - syncronizedList
 - syncronizedMap
 - ...
 Note: syncronized not need

 Blocking Collections
 - LinkedBlockingQueue
 - PriorityBlockingQueue
 - ...

java.util.concurrent

java.util.current.atomic
- set, get, getAndAdd, compareAndSet

 */