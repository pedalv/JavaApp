package no.dfo.whatsnewinjava.compile;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java> ..\..\..\..\Java\jdk-17.0.6+10\bin\java .\src\main\java\no\dfo\whatsnewinjava\compile\ListFiles.java
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
 *         at no.dfo.whatsnewinjava.compile.ListFiles.main(ListFiles.java:9)
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java> ..\..\..\..\Java\jdk-17.0.6+10\bin\java .\src\main\java\no\dfo\whatsnewinjava\compile\ListFiles.java .
 *
 */
public class ListFiles {

    public static void main(String ...args) throws Exception {
        Files.walk(Path.of(args[0]))
                .forEach(System.out::println);
    }
}
