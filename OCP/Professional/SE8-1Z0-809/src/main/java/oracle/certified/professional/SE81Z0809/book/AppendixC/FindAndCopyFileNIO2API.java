package oracle.certified.professional.SE81Z0809.book.AppendixC;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
The following is a simple implementation of FileVisitor that searches for the file
zoo.txt in a directory tree. Once it finds the file, it copies it within the directory and
terminates the walk process. It also stops the process if it encounters an entry it failed
to process.
 */
public class FindAndCopyFileNIO2API implements FileVisitor<Path> {

    public FileVisitResult preVisitDirectory(
            Path dir, BasicFileAttributes attrs) throws IOException {

        return FileVisitResult.CONTINUE;

    }

    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {

        if (file.getFileName().equals("Zoo.txt")) {
            Files.copy(file, Paths.get("Zoo2.txt"));
            return FileVisitResult.TERMINATE;
        } else {
            return FileVisitResult.CONTINUE;
        }

    }

    public FileVisitResult visitFileFailed(
            Path file, IOException exc) throws IOException {

        return FileVisitResult.TERMINATE;

    }

    public FileVisitResult postVisitDirectory(
            Path dir, IOException exc) throws IOException {

        return FileVisitResult.CONTINUE;

    }
}

/*
Each method in FileVisitor returns a FileVisitResult enum that instructs the process
on what the next step in the walk should be by using the FileVisitor.
The full list of values is:
Enum Value      Description
CONTINUE        Continue to the next item in the file walk.
TERMINATE       Immediately terminate the file walk.
SKIP_SUBTREE    Used by the preVisitDirectory() method
                    to indicate that the current directory and its
                    descendants should be skipped.
SKIP_SIBLINGS   Used by the preVisitDirectory() and
                    postVisitDirectory() methods to indicate that
                    all remaining unvisited siblings should be skipped.
                If used in preVisitDirectory(), then the
                    directory entries are also skipped.
 */