package no.the.core.platform.multithreadingconcurrency.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PollThreadRunnableLoop {

    static String[] inFiles = {"inFile1.txt","inFile2.txt","inFile3.txt","inFile4.txt","inFile5.txt", "inFile6.txt" };
    static String[] outFiles = {"outFile1.txt","outFile2.txt","outFile3.txt",
            "outFile4.txt","outFile5.txt", "outFile6.txt" };


    //ONLY 2 threads can be create without concluded
    private static ExecutorService es = Executors.newFixedThreadPool(2);

    public static void createandwait() {

        try {
            for (int i = 0; i < inFiles.length; i++)
            {
                AdderRunnable adder = new AdderRunnable(inFiles[i], outFiles[i]);
                Thread.sleep(1000*2);
                es.submit(adder);
                Thread.sleep(1000*2);
                System.out.println("called Adder(inFiles["+i+"], outFiles["+i+"]");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shutdownAwaitThreads();

    }

    private static void shutdownAwaitThreads() {
        try {
            //not allow more threads
            es.shutdown();
            // wait for all older threads concluded
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting ");
    }

}
