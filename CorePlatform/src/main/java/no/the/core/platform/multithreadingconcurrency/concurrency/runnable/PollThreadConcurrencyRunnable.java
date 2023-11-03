package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PollThreadConcurrencyRunnable {

    //ONLY 2 threads can be create without concluded
    private static ExecutorService es = Executors.newFixedThreadPool(4);


    public static void createwait() {

        BankAccount account = new BankAccount(100, "1");

        try {
            for (int i = 0; i < 5; i++) {
                WorkerRunnable worker = new WorkerRunnable(account,i);
                Thread.sleep(1000 * 2);
                es.submit(worker);
                Thread.sleep(1000 * 2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2 threads create
        // assigns a queue for tasks into a pool of threads
        // when threads are finish will start the others
        // not allow more threads and wait for older threads finish
        shutdownAwaitThreads();
    }

    private static void shutdownAwaitThreads() {
        try {
            //not allow more threads
            es.shutdown();
            // wait for all older threads concluded
            es.awaitTermination(120, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting ");
    }

}