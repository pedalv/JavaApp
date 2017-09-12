package no.the.core.platform.multithreadingconcurrency.concurrency.notrunnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;
import no.the.core.platform.multithreadingconcurrency.concurrency.runnable.WorkerRunnable;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PollThreadConcurrency {

    private static ArrayList<Thread> arrThreads = new ArrayList<Thread>();

    //ONLY 2 threads can be create without concluded
    private static ExecutorService es = Executors.newFixedThreadPool(2);

    public static void createwait() {

        BankAccount account = new BankAccount(100);

        runThread1(account);
        runThread2(account);
        runThread3(account);
        runThread4(account);
        runThread5(account);
        //runThread6(account);
        //runThread7(account);
        //runThread8(account);
        //runThread9(account);
        //runThread10(account);

        // 2 threads create
        // assigns a queue for tasks into a pool of threads
        // when threads are finish will start the others
        // not allow more threads and wait for older threads finish
        waitAllThreadsFinish();
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

    private static void runThread10(BankAccount account) {
        Runnable task10 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread10 = new Thread(task10);
        thread10.start();
        arrThreads.add(thread10);
    }

    private static void runThread9(BankAccount account) {
        Runnable task9 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread9 = new Thread(task9);
        thread9.start();
        arrThreads.add(thread9);
    }

    private static void runThread8(BankAccount account) {
        Runnable task8 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,8);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread8 = new Thread(task8);
        thread8.start();
        arrThreads.add(thread8);
    }

    private static void runThread7(BankAccount account) {
        Runnable task7 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread7 = new Thread(task7);
        thread7.start();
        arrThreads.add(thread7);
    }

    private static void runThread6(BankAccount account) {
        Runnable task6 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread6 = new Thread(task6);
        thread6.start();
        arrThreads.add(thread6);
    }

    private static void runThread5(BankAccount account) {
        Runnable task5 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread5 = new Thread(task5);
        thread5.start();
        arrThreads.add(thread5);
    }

    private static void runThread4(BankAccount account) {
        Runnable task4 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread4 = new Thread(task4);
        thread4.start();
        arrThreads.add(thread4);
    }

    private static void runThread3(BankAccount account) {
        Runnable task3 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account, 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread3 = new Thread(task3);
        thread3.start();
        arrThreads.add(thread3);
    }

    private static void runThread2(BankAccount account) {
        Runnable task2 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread2 = new Thread(task2);
        thread2.start();
        arrThreads.add(thread2);
    }

    private static void runThread1(BankAccount account) {
        Runnable task1 = new Runnable(){

            @Override
            public void run(){

                try {
                    useBankAccount(account,1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread1 = new Thread(task1);
        thread1.start();
        arrThreads.add(thread1);
    }

    private static void useBankAccount(BankAccount account, int work) throws InterruptedException {
        WorkerRunnable worker = new WorkerRunnable(account,work);
        Thread.sleep(1000 * 2);
        es.submit(worker);
        Thread.sleep(1000 * 2);
    }

}

