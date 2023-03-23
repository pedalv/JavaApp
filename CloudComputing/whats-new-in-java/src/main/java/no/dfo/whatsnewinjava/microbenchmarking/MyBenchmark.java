package no.dfo.whatsnewinjava.microbenchmarking;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * https://www.baeldung.com/java-microbenchmark-harness
 *
 * javac .\src\main\java\no\dfo\whatsnewinjava\microbenchmarking\MyBenchmark.java
 * java Hello
 *
 * Note: See jmh-number-verification-performance-test project with an example that runs with maven from the course
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java> ..\..\..\..\Java\jdk-17.0.6+10\bin\java .\src\main\java\no\dfo\whatsnewinjava\microbenchmarking\MyBenchmark.java
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1) // a single JVM
@State(Scope.Benchmark)
public class MyBenchmark {

    /*
    public static void main(String ...args) {
        MyBenchmark jbm = new MyBenchmark();
        jbm.doNothing();
    }
     */


    @Param({ "100", "200", "300", "500", "1000" })
    String iterationsToParse;

    @Benchmark
    public Integer parseInt() throws Exception {
        return Integer.parseInt(iterationsToParse);
    }

    @Benchmark
    public double foldedLog2() {
        return 2.0794415416798357;
    }

    @State(Scope.Benchmark)
    public static class Log {
        public int x = 8;
    }

    @Benchmark
    public double log(Log input) {
        return Math.log(input.x);
    }

    @Benchmark
    public double foldedLog() {
        int x = 8;

        return Math.log(x);
    }


    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void blackHole(Blackhole blackhole) {
        blackhole.consume(new Object());
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void doNothing() {
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void objectCreation() {
        new Object();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public Object pillarsOfCreation() {
        return new Object();
    }

}
