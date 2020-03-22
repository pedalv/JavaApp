package no.book.AppendixC;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class TraversingDirectoriesNIO2API {

    public static void main(String ... args) {

        TraversingDirectories();

        FindAndCopyFileVisitFile();

        DeletePathVisitFile();
        // Deleting file: C:\OracleCertificationProgram\NIO2
        //java.nio.file.DirectoryNotEmptyException
        // Problems to create BasicFileAttributes - attrs
    }

    private static void DeletePathVisitFile() {

        Path path = Paths.get("C:\\OracleCertificationProgram\\NIO2");

        // TODO
        BasicFileAttributes attrs = new BasicFileAttributes() {
            @Override
            public FileTime lastModifiedTime() {
                return null;
            }

            @Override
            public FileTime lastAccessTime() {
                return null;
            }

            @Override
            public FileTime creationTime() {
                return null;
            }

            @Override
            public boolean isRegularFile() {
                return false;
            }

            @Override
            public boolean isDirectory() {
                return false;
            }

            @Override
            public boolean isSymbolicLink() {
                return false;
            }

            @Override
            public boolean isOther() {
                return false;
            }

            @Override
            public long size() {
                return 0;
            }

            @Override
            public Object fileKey() {
                return null;
            }
        };

        try {
            new DeletePathNIO2API().visitFile(path, attrs);
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private static void FindAndCopyFileVisitFile() {
        Path path = Paths.get("C:\\OracleCertificationProgram\\NIO2");
        BasicFileAttributes attrs = new BasicFileAttributes() {
            @Override
            public FileTime lastModifiedTime() {
                return null;
            }

            @Override
            public FileTime lastAccessTime() {
                return null;
            }

            @Override
            public FileTime creationTime() {
                return null;
            }

            @Override
            public boolean isRegularFile() {
                return false;
            }

            @Override
            public boolean isDirectory() {
                return false;
            }

            @Override
            public boolean isSymbolicLink() {
                return false;
            }

            @Override
            public boolean isOther() {
                return false;
            }

            @Override
            public long size() {
                return 0;
            }

            @Override
            public Object fileKey() {
                return null;
            }
        };

        try {
            new FindAndCopyFileNIO2API().visitFile(path,attrs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void TraversingDirectories() {

        // Reading a Directory with DirectoryStream
        /*
        Added to Java 8 as part of the Streams API
            and returned a Stream<Path> object, which we then processed in a lazy manner:
        to traverse a directory by using the Files.walk(Path) method
        and search a directory using the Files.find(Path,int,BiPredicate) method.
        */

        /*
        Part of the Java 7 release, we consider these techniques to
            be far less concise and convenient than the Streams API approach
        Used to iterate over a directory, similar to the java.io.File.listFiles() method.
         */

        /*
        The NIO.2 API includes an interface called DirectoryStream, which can be used to read a single directory.
        */

        Path path = Paths.get("C:\\OracleCertificationProgram\\NIO2");
        // use the try-with-resource syntax since we need to
        //ensure that the DirectoryStream object is closed when we are finished with it.
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for(Path element: stream) {
                System.out.println(element.getFileName()+"\t"+Files.isDirectory(element));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        Remember for the exam that the DirectoryStream process traverses only
            a single directory and does not visit any subdirectories that it encounters.
        This distinguishes it from the FileVisitor process that you will see in the next section.
         */

        /*
        Although this might sound confusing, the DirectoryStream interface does not implement or extend
            the generic java.util.stream.Stream interface, and it is therefore unrelated to the Streams API
            that you learned about in Chapter 4, “Functional Programming.”
        It is also not related to java.io streams that you learned about in Chapter 8.
        Blame the authors of Java for this quite ambiguous naming choice!
         */

        /*
        Since DirectoryStream does not inherit java.util.stream.Stream , we cannot apply any stream-based methods.
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path)
                    .filter(p -> p.getFileName().startsWith("zoo")) // DOES NOT COMPILE
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        This example does not compile because it tries to apply stream-based methods to a DirectoryStream instance.
        */


        // Walking a Directory Tree with FileVisitor

        /*
        While the DirectoryStream interface is used to visit the contents of a single directory,
            the FileVisitor<T> interface is used to visit an entire directory tree.
        Although FileVisitor<T> is a generic interface that
            can be constructed using any class, we use Path as the type throughout this section.

        The idea is simple.
        - You create a class that implements the FileVisitor<Path> interface
            and then pass it to a Files.walkFileTree() method.
        - The walkFileTree() method handles the complex process of loading the next directory and file for you,
            and it recursively calls the methods in your FileVisitor implementation as it encounters each entry.
         */

        /*
        Before we start walking a directory tree, we need to defi ne the structure of the
            FileVisitor<T> interface that you will need to implement. Using Path as the generic type,
            the FileVisitor<Path> interface requires four methods:
         */

        new FileVisitor(/*Path*/) {
            @Override
            //This
            //method is called before a directory’s contents are visited, and it automatically includes the
            //directory’s attributes in a BasicFileAttributes object.
            public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override
            //This method
            //is called when a fi le is visited, and it automatically includes the fi le’s attributes in a
            //BasicFileAttributes object.
            public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override
            //This method is called
            //when a file cannot be visited along with exception information about the reason for the failure.
            public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
                return null;
            }

            @Override
            //This method is
            //called after a directory’s contents are visited, and it includes exception information when
            //applicable. The directory-based exception sent to this method, if provided, is analogous to
            //the file-based exception sent to the visitFileFailed() method.
            public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
                return null;
            }
        };




    }

}
