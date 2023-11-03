package no.the.core.platform.multithreadingconcurrency.multicorecpu.singleton.work;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String ... strings) {

        long start = System.currentTimeMillis();
        Instant start2 = Instant.now();


        for (int i = 0; i < 10; i++) {

            Runnable task = () -> System.out.println(Singleton.INSTANCE);
            Thread thread = new Thread(task);
            threadStart(thread);

        }

        long end = System.currentTimeMillis();
        Instant end2 = Instant.now();
        long nanos = Duration.between(start2, end2).getNano();
        float seconds =  Duration.between(start2, end2).getNano() / 1_000_000_000f;


        System.out.println(String.format("Time: %dms - %dms - %fs", end - start, nanos  / 1_000_000, seconds));
    }

    public static void threadStart(Thread thread) {
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}










/*

EXEMPLE:

public class Main implements Comparator<T> {}

public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
    return (Comparator<T>) Comparators.NaturalOrderComparator.INSTANCE;
}

enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
    INSTANCE;

    @Override
    public int compare(Comparable<Object> c1, Comparable<Object> c2) {
        return c1.compareTo(c2);
    }

    @Override
    public Comparator<Comparable<Object>> reversed() {
        return Comparator.reverseOrder();
    }
}

*/