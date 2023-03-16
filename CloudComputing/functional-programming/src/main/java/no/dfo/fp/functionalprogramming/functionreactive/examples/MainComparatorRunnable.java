package no.dfo.fp.functionalprogramming.functionreactive.examples;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Executors;

@Slf4j
public class MainComparatorRunnable {

    public static void main(String[] args) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        Comparator<String> comparatorlambda = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        String[] names = new String[]{ "PP", "PPP", "P" };
        //Arrays.sort(names, comparator);
        Arrays.sort(names, comparatorlambda);

        //--

        Runnable r  = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i++ < 10) {
                    log.info("Its works!");
                }
            }
        };

        Runnable rlanbda  = () -> {
            int i = 0;
            while (i++ < 10) {
                log.info("Its works!");
            }
        };

        //Executors.newSingleThreadExecutor().execute(r);
        Executors.newSingleThreadExecutor().execute(rlanbda);

    }

}
