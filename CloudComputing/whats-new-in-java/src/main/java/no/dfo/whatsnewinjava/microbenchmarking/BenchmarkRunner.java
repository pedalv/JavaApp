package no.dfo.whatsnewinjava.microbenchmarking;

public class BenchmarkRunner {

    //ERROR: Unable to find the resource: /META-INF/BenchmarkList
    //	at org.openjdk.jmh.runner.AbstractResourceReader.getReaders
    // ...
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

}
