package no.the.core.platform.multithreadingconcurrency.runnable;

public class MultipleThreadRunnable {

    static String[] inFiles = {"inFile1.txt","inFile2.txt","inFile3.txt","inFile4.txt","inFile5.txt", "inFile6.txt" };
    static String[] outFiles = {"outFile1.txt","outFile2.txt","outFile3.txt",
            "outFile4.txt","outFile5.txt", "outFile6.txt" };


    static Thread[] threads = new Thread[inFiles.length];

    public static void createandwait() {

        try {
            for (int i = 0; i < inFiles.length; i++)
            {
                AdderRunnable adder = new AdderRunnable(inFiles[i], outFiles[i]);
                Thread.sleep(1000*2);
                //Thread thread = new Thread(adder);
                //thread.start();
                threads[i] = new Thread(adder);
                threads[i].start();
                Thread.sleep(1000*2);
                System.out.println("called Adder(inFiles["+i+"], outFiles["+i+"]");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitAllThreadsFinish();

    }

    private static void waitAllThreadsFinish() {
        for(Thread thread:threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread exiting ");
    }

}
