package no.book.AppendixC;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*
By extending the SimpleFileVisitor class, we can conveniently skip declaring the
visitFileFailed() and preVisitDirectory() methods, instead relying on the default
implementations. Notice that we delete the directory in the postVisitDirectory()
method, since this is executed after the contents of the directory have been deleted. If we
tried instead to delete the directory in the preVisitDirectory() method, an exception
would be thrown if the directory was not empty. Finally, we check for the presence of
exception in the postVisitDirectory() method, such as if the directory itself was unable
to be read.
 */
public class DeletePathNIO2API extends SimpleFileVisitor<Path> {

    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {

        System.out.println("Deleting file: "+file.toAbsolutePath());
        Files.delete(file);


        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(
            Path dir, IOException exc) throws IOException {

        if(exc != null) {
            System.out.println("Exception encountered "+exc.toString());

            throw exc;
        }

        System.out.println("Deleting directory: "+dir.toAbsolutePath());
        Files.delete(dir);

        return FileVisitResult.CONTINUE;
    }

}
