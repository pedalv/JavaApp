package no.the.core.platform.multithreadingconcurrency.pattern.productconsumer.waitnotify;

public class ProducerConsumer {

    private static Object lock = new Object();

    private static int[] buffer;
    private static int count;

    static class Producer {

        void produce() {
            synchronized (lock) { //Fix Race Condition
                if (isFull(buffer)) {
                    try {
                        lock.wait(); //Fix the Deadlock
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
                buffer[count++] = 1;
                lock.notify(); //Fix the Deadlock

                //Note: wait() and notify() cannot be invoked outside a synchronized block
                // notitfyAll(): it will a wake all threads
            }
        }
    }


    static class Consumer {

        void consume() {
            synchronized (lock) { //Fix Race Condition
                if (isEmpty(buffer)) {
                    try {
                        lock.wait(); //Fix the Deadlock
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
                buffer[--count] = 0;
                lock.notify(); //Fix the Deadlock

                //Note: wait() and notify() cannot be invoked outside a synchronized block
                // notitfyAll(): it will a wake all threads
            }
        }
    }

    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static void main(String... strings) throws InterruptedException {

        buffer = new int[10];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            for (int i = 0 ; i < 50 ; i++) {
                producer.produce();
            }
            System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            for (int i = 0 ; i < 50 ; i++) {
                // change to 60 will be a deathlock
                // change to 45 will be 5 left on buffer
                // change to some number as producer will be 0 on the buffer
                consumer.consume();
            }
            System.out.println("Done consuming");
        };

        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("Data in the buffer: " + count);

    }

}