package no.the.core.platform.multithreadingconcurrency.pattern.running;

import no.the.core.platform.multithreadingconcurrency.pattern.racecondition.LongWrapper;

public class LongWrapperRunning {

    public static void main(String[] args) throws InterruptedException {

        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable task = () -> {

            for (int i = 0 ; i < 1_000 ; i++) {
                longWrapper.incrementValue();
            }
        };

        /*
        Thread t1 = new Thread(task);
        t1.start();
        t1.join();
        */

        Thread[] threads = new Thread[1_000];
        for (int i = 0 ; i < threads.length ; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0 ; i < threads.length ; i++) {
            threads[i].join();
        }

        System.out.println("Value = " + longWrapper.getValue());
    }
}
