package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PollTxThreadConcurrencyRunnable {

    //ONLY 2 threads can be create without concluded
    private static ExecutorService es = Executors.newFixedThreadPool(4);


    public static void userAccount() {

        BankAccount account = new BankAccount(450);

        /*
        TxWorkerRunnable[] workers = {
                new TxWorkerRunnable(account,'w',100),
                new TxWorkerRunnable(account,'d',160),
                new TxWorkerRunnable(account,'w',10)
        };
        */

        TxWorkerRunnable[] workers = {
                new TxPromoWorker(account,'w',100),
                new TxPromoWorker(account,'d',260),
                new TxPromoWorker(account,'w',10),
                new TxPromoWorker(account,'d',250),
                new TxPromoWorker(account,'d',250),
                new TxPromoWorker(account,'d',250),
                new TxPromoWorker(account,'d',250)
        };

        for(TxWorkerRunnable worker: workers) {
            es.submit(worker);
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