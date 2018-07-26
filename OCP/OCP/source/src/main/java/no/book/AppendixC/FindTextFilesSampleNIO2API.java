package no.book.AppendixC;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;

/*
The sample application searches for all of the text files at most five levels deep from the
C:\OracleCertificationProgram\NIO2 root, following all symbolic links it finds. If a circular reference is detected,
it outputs a message and continues processing the request. Remember that the NIO.2 API
method will skip the processing of a file it has already read if a circular link is detected, and
it will instead call the visitFileFailed() method.
 */

/*
TODO: Not find any txt fil !!!!!!!!!!!!!!!!!!!!!!
 */
public class FindTextFilesSampleNIO2API {


    public static void main(String[] args) throws IOException {

        // Applying walkFileTree(Path, Set<FileVisitOption>, int, FileVisitor<? super Path>)

        Files.walkFileTree(
                Paths.get("C:\\OracleCertificationProgram\\NIO2"),
                EnumSet.of(FileVisitOption.FOLLOW_LINKS),
                5,
                new FindTextFilesNIO2API());


        // For example, other than the circular error handling,
        //the previous FindTextFiles class can be rewritten into a single stream-based
        //statement:


        Files.walk(
                Paths.get("C:\\OracleCertificationProgram\\NIO2"),
                5,
                FileVisitOption.FOLLOW_LINKS)
                .filter(p -> p.getFileName().endsWith("txt"))
                .forEach(p -> System.out.println("Found file: "+p.toAbsolutePath()));

        /*
        It is clear that this approach is a lot simpler to read and maintain. There are some situations
            where the longer form is acceptable, such as if you need to reuse the FileVisitor
            implementation in multiple processes. You may also prefer the FileVisitor approach if
            you are hiding the implementation details from a caller using a compiled version of your class.
         */

    }

}
