package no.dfo.jbm;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

/**
 * https://www.baeldung.com/java-microbenchmark-harness
 *
 * javac .\src\main\java\no\dfo\whatsnewinjava\microbenchmarking\MyBenchmark.java
 * PS C:\workspace2\JavaApp\CloudComputing\MyBenchmark> ..\..\..\..\java\jdk-17.0.6+10\bin\java -jar .\build\libs\MyBenchmark-1.0-SNAPSHOT.jar
 *
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1) // a single JVM
@State(Scope.Benchmark)
public class MyBenchmark {


    /*
    public static void main(String ...args) {
        System.out.println("Java Benchmark");
    }
     */

    @Param({ "100", "200", "300", "500", "1000" })
    String iterationsToParse;

    @Benchmark
    public Integer parseInt() throws Exception {
        return Integer.parseInt(iterationsToParse);
    }

}
