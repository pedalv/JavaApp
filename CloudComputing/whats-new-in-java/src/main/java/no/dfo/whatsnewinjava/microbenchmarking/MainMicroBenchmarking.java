package no.dfo.whatsnewinjava.microbenchmarking;

/**
 * Java Micro-benchmarking Harness
 * - Reproducability
 * - Handles JVM warm-up
 * - Conistent reporting
 * - Multi-threading support
 *
 * Examples
 * - java.math.BigDecimal arithmetic
 * - Class::forName reflection
 * - Threading
 * - Crypto algorithms
 *
 * mvn archetype:generate \
 *  -DinteractiveMode=false \
 *  -DarchetypeGroupId=org.openjdk.jmh \
 *  -DarchetypeArtifactId=jmh-java-benchmark-archetype \
 *  -DgroupId=org.sample \
 *  -DartifactId=test \
 *  -Dversion=1.0
 *
 *
 *  javac .\src\main\java\no\dfo\whatsnewinjava\microbenchmarking\MainMicroBenchmarking.java
 *  Note: See jmh-number-verification-performance-test project with an example that runs with maven from the course
 */
public class MainMicroBenchmarking {

    public static void main(String ...args) {
        dontDoThis(); // only runs once, delay on start that can change time, minimize after start several times, etc,
    }

    public static void dontDoThis() {
        // Don't Do This
        long start = System.currentTimeMillis();
        System.out.println(String.valueOf(start));
        //Code to be benchmarked
        long end = System.currentTimeMillis();
        System.out.println(String.valueOf(end));
        long elapsed = end - start;
        System.out.println(String.valueOf(elapsed));
    }


}
