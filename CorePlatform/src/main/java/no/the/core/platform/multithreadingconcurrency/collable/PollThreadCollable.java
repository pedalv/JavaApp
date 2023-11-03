package no.the.core.platform.multithreadingconcurrency.collable;

import java.util.concurrent.*;

public class PollThreadCollable {

    static String[] inFiles = {"inFile1.txt","inFile2.txt","inFile3.txt","inFile4.txt","inFile5.txt", "inFile6.txt" };
    static String[] outFiles = {"outFile1.txt","outFile2.txt","outFile3.txt",
            "outFile4.txt","outFile5.txt", "outFile6.txt" };

    //ONLY 2 threads can be create without concluded
    private static ExecutorService es = Executors.newFixedThreadPool(2);

    static Future<Integer>[] results = new Future[inFiles.length];

    public static void createandFuture() {

        try {
            for (int i = 0; i < inFiles.length; i++)
            {
                AdderCollable adder = new AdderCollable(inFiles[i], outFiles[i]);
                Thread.sleep(1000*2);
                results[i] = es.submit(adder);
                Thread.sleep(1000*2);
                System.out.println("called Adder(inFiles["+i+"], outFiles["+i+"]");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        futureAllThreads();

    }

    private static void futureAllThreads() {

        try {

            for(Future<Integer> result: results) {
                int value = result.get(); // blocks until return value available
                System.out.println("Total: " + value);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            Throwable adderEx = e.getCause(); // Get the Adder exception
            System.out.println(adderEx.getMessage());
        }

        //not allow more threads
        es.shutdown();

        System.out.println("Main thread exiting ");
    }
}
