package no.dfo.whatsnewinjava.langandlib.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/**
 * Stream API improvements
 * - takeWhile(1)
 * - dropWhile(1)
 * (1) Use with ordered Streams
 * - ofNullable
 * - iterate
 */
public class FindGitConflict {

    public static void main(String... args) throws Exception {

        """
        <html>
        <header>
            <<<<<<< HEAD
            <link tyoe="text/css" rel="stylesheet" media="all" href="style.css" />
            =======
            <!-- no style -->
            >>>>>>> master
        </header>
        <body>
         <h1>Hello, World! Life is great!</h1>
        </body>
        </html>
                """.lines()
                .dropWhile(l -> !l.contains("<<<<<<<"))
                .skip(1)
                .takeWhile(l -> !l.contains(">>>>>>>"))
                .forEach(System.out::println);



        //Exception in thread "main" java.nio.file.NoSuchFileException: resources\index.html
        // Files.lines -> Stream<String>
        Files.lines(Paths.get("C:\\workspace2\\JavaApp\\CloudComputing\\whats-new-in-java\\src\\main\\resources\\index.html"))
             .dropWhile(l -> !l.contains("<<<<<<<"))
             .skip(1)
             .takeWhile(l -> !l.contains(">>>>>>>"))
             .forEach(System.out::println);


    }



}
