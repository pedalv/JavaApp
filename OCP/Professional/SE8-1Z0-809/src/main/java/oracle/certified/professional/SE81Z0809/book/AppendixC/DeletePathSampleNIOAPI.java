package oracle.certified.professional.SE81Z0809.book.AppendixC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
The following application
uses our DeletePathNIO2API class to walk and delete files in a directory:
 */
public class DeletePathSampleNIOAPI {

    public static void main(String[] args) throws IOException {

        // Applying walkFileTree(Path, FileVisitor<? super Path>)

        Files.walkFileTree(Paths.get("C:\\OracleCertificationProgram\\NIO2"), new DeletePathNIO2API());

        /*
        Like the Files.walk() method that you saw in Chapter 9, the order in which a tree is
            searched is in depth-first manner. The result is that anytime the postVisitDirectory()
            method is called, we know that all of the available descendants of the directory have
            already been processed.
         */

    }
}
