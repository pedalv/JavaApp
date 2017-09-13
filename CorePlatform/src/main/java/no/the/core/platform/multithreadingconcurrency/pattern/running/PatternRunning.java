package no.the.core.platform.multithreadingconcurrency.pattern.running;

public class PatternRunning {

    public void createThreadJava7() {
        Runnable taskJava7 = new Runnable() {

            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println("I am running in thread " + name);

            }
        };

        Thread threadjava7 = new Thread(taskJava7);
        threadjava7.setName("Thread-Java7");
        threadjava7.start();
    }

    public void createThreadJava8() {
        Runnable taskJava8 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("I am running in thread " + name);
        };

        Thread threadjava8 = new Thread(taskJava8);
        threadjava8.setName("Thread-Java8");
        threadjava8.start();
    }


    /*
    create threads in Java
    - is to use the Runnable Pattern
    1. create an instance of Runnable
    2. pass it to the constructor of the thread calss
    3. call the start() method of this thread object

     */
}
