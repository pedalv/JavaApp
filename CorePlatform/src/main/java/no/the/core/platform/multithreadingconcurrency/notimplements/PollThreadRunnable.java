package no.the.core.platform.multithreadingconcurrency.notimplements;

import no.the.core.platform.multithreadingconcurrency.runnable.AdderRunnable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PollThreadRunnable {

    static String[] inFiles = {"inFile1.txt","inFile2.txt","inFile3.txt","inFile4.txt","inFile5.txt", "inFile6.txt" };
    static String[] outFiles = {"outFile1.txt","outFile2.txt","outFile3.txt",
            "outFile4.txt","outFile5.txt", "outFile6.txt" };


    private static ArrayList<Thread> arrThreads = new ArrayList<Thread>();

    //ONLY 2 threads can be create without concluded
    private static ExecutorService es = Executors.newFixedThreadPool(2);

    public static void createwait() {
        runThread1();
        runThread2();
        runThread3();
        runThread46();

        // 2 threads create
        // assigns a queue for tasks into a pool of threads
        // when threads are finish will start the others
        // not allow more threads and wait for older threads finish
        waitAllThreadsFinish();
        shutdownAwaitThreads();
    }


    /*
        Only allow run two threads each time
     */
    private static void shutdownAwaitThreads() {
        try {
            //not allow more threads
            es.shutdown();
            // wait for all older threads concluded
            es.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitAllThreadsFinish() {
        for (int i = 0; i < arrThreads.size(); i++)
        {
            try {
                arrThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread exiting ");
    }

    private static void runThread46() {
        // Lambda Runnable
        Runnable task4 = () -> {
            try {
                dothings(3);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        };

        Runnable task5 = () -> {
            try {
                dothings(4);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        };

        Runnable task6 = () -> {
            try {
                dothings(5);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        };

        // start the thread
        //new Thread(task4).start();
        //new Thread(task5).start();
        //new Thread(task6).start();

        Thread thread4 = new Thread(task4);
        thread4.start();
        arrThreads.add(thread4);

        Thread thread5 = new Thread(task5);
        thread5.start();
        arrThreads.add(thread5);

        Thread thread6 = new Thread(task6);
        thread6.start();
        arrThreads.add(thread6);

    }

    /*
        Runnable Lambda Code
     */
    private static void runThread3() {
        // Lambda Runnable
        Runnable task3 = () -> {
            try {
                dothings(2);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        };

        // start the thread
        //new Thread(task3).start();
        Thread thread3 = new Thread(task3);
        thread3.start();

        arrThreads.add(thread3);
    }


    /*
         Before Java 8, Or pass the anonymous class into the Thread’s constructor
     */
    private static void runThread2() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    dothings(1);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();

        arrThreads.add(thread2);
    }

    /*
        Before Java 8, we create and start a thread by creating an anonymous class that implements the Runnable interface,
        as shown in the following code:
     */
    private static void runThread1() {
        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                try {
                    dothings(0);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread thread1 = new Thread(task1);
        thread1.start();

        arrThreads.add(thread1);
    }

    private static void dothings(int i) throws InterruptedException, IOException {
        AdderRunnable adder = new AdderRunnable(inFiles[i], outFiles[i]);
        Thread.sleep(1000*2);
        es.submit(adder);
        Thread.sleep(1000*2);
        System.out.println("called Adder(inFiles["+i+"], outFiles["+i+"]");
    }
}
