#!/c/Java/jdk-11.0.14+9/bin/java

import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * chmod +x listfiles
 * ./listfiles .
 *
 */
public class ListFilesScript {

    public static void main(String ...args) throws Exception {
        Files.walk(Path.of(args[0]))
                .forEach(System.out::println);
    }
}
