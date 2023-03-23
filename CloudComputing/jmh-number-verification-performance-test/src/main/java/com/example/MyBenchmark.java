package com.example;

import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.*;
import org.openjdk.jmh.runner.options.*;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Benchmark              (toParse)  Mode  Cnt   Score    Error  Units
 * MyBenchmark.parseInt           1  avgt    5  10,496 ±  7,222  ns/op
 * MyBenchmark.parseInt       12345  avgt    5  23,253 ±  1,197  ns/op
 * MyBenchmark.parseInt  2147483647  avgt    5  45,324 ± 14,956  ns/op
 *
 * mvn clean package
 * java -jar .\target\benchmarks.jar
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class MyBenchmark {

    @Param({"1", "12345", "2147483647"})
    String toParse;

    /*
    Benchmark              (toParse)  Mode  Cnt   Score    Error  Units
    MyBenchmark.parseInt           1  avgt    5  10,496 ±  7,222  ns/op
    MyBenchmark.parseInt       12345  avgt    5  23,253 ±  1,197  ns/op
    MyBenchmark.parseInt  2147483647  avgt    5  45,324 ± 14,956  ns/op

     */
    @Benchmark
    public Integer parseInt() throws Exception {
      return Integer.parseInt(toParse);
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
