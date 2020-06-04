package oracle.certified.professional.SE81Z0809.book.AppendixC;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FindTextFilesNIO2API extends SimpleFileVisitor<Path> {

    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {

        if(file.getFileName().endsWith("txt")) {
            System.out.println("Found file: "+file.toAbsolutePath());
        }

        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {

        if (exc instanceof FileSystemLoopException) {
            System.err.println("Circular reference detected: "+file.toString());
        } else if(exc != null) {
            throw exc;
        }

        return FileVisitResult.CONTINUE;
    }

}
