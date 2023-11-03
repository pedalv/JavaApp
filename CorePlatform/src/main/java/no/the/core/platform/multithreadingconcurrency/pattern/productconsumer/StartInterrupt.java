package no.the.core.platform.multithreadingconcurrency.pattern.productconsumer;

public class StartInterrupt {

    public static void main(String... strings) throws InterruptedException {
        //1
        Runnable task = () -> {
            while(! Thread.currentThread().isInterrupted()) {
                System.out.println("Hi høst fra 2017");
            }
        };

        //2
        Thread thread = new Thread(task);

        //3
        thread.start();

        Sleeping();

        //4
        // stop method (NO NO NO): It is there for legacy, backward compatibility reasons
        // interrupt() method: Call it causes the isInterrupted(9 method to return true
        thread.interrupt();

        //if the thread is
        //blocked,
        //or waiting,
        //then the corresponding method will throw an
        //InterrupterException
        // wait() / notify() / join() throw InterruptedException
    }

    public static void Sleeping() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
@FunctionalInterface
public interface Runnable {
    void run();
}
*/