package no.the.core.platform.multithreadingconcurrency.pattern;

import no.the.core.platform.multithreadingconcurrency.pattern.running.PatternRunning;

public class Program {

    public static void main(String ... args) {

        PatternRunning run = new PatternRunning();
        run.createThreadJava7();
        run.createThreadJava8();


    }
}
