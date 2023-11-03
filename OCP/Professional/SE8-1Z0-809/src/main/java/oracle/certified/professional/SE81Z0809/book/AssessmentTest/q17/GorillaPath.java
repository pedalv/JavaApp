package oracle.certified.professional.SE81Z0809.book.AssessmentTest.q17;

import oracle.certified.professional.SE81Z0809.book.helper.Directories;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GorillaPath {

    public static void main(String ... args) {

        Path path = null, path1 = null, path2 = null;

        try {
            path = Directories.getResourcePath("no/book/AssessmentTest/q17/gorilla/signed-words.txt");
            System.out.println(String.format("Path : %s",path));

            path1 = Paths.get("/gorilla/signed-words.txt");
            System.out.println(String.format("Path1: %s",path1));
            /*
            java.nio.file.NoSuchFileException: \gorilla
             */
            path2 = Paths.get("no/book/AssessmentTest/q17/gorilla/signed-words.txt");
            System.out.println(String.format("Path2: %s",path2));
            /*
            java.nio.file.NoSuchFileException: no\book\AssessmentTest\q17\gorilla
             */

        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

        /*
        public static Stream<Path> find(Path start,
                                    int maxDepth,
                                    BiPredicate<Path, BasicFileAttributes> matcher,
                                    FileVisitOption... options)
            throws IOException
         */
        try {
            Files
                    .find(
                            //path2.getParent(),10,
                            /*
                            java.nio.file.NoSuchFileException: no\book\AssessmentTest\q17\gorilla
                             */
                            //path1.getParent(),10,
                            /*
                            java.nio.file.NoSuchFileException: \gorilla
                             */
                            path.getParent(),10, // k1 - Fix: Need change from Long tp int
                            /*
                            Error: java: incompatible types: possible lossy conversion from double to int
                             */
                            (Path p, BasicFileAttributes bfattrs) -> p.toString().endsWith(".txt") && Files.isDirectory(p)) // k2
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        } catch (IOException e) {  // k1 - Fix: catch exception
            e.printStackTrace();
        }

        /*
        public static List<String> readAllLines(Path path) throws IOException {
            return readAllLines(path, StandardCharsets.UTF_8);
        }

        <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        @return the new stream

        default Stream<E> stream() {
            return StreamSupport.stream(spliterator(), false);
        }
        @return a sequential {@code Stream} over the elements in this collection
         */
        try {
            Files
                    .readAllLines(path) // k3
                    .stream() // k4 - Fix: @return a sequential {@code Stream} over the elements in this collection
                    .flatMap(p -> Stream.of(p.split(" "))) // k4 - @return the new stream
                    /*
                    Error: java: cannot find symbol
                      symbol:   method flatMap((p)->Strea[...]" ")))
                      location: interface java.util.List<java.lang.String>
                     */
                    .map(s -> s.toLowerCase()) // k5
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
Assuming that the directory/gorilla exists within the file system with the numerous files
including signed-words.txt, what is the result of executing the following code?
(Choose all that apply.)

    A. The code compiles but does not produce any output at runtime.
B. It does not compile because of line k1.
C. It does not compile because of line k2.
        D. It does not compile because of line k3.
E. It does not compile because of line k4.
    F. The code prints all of the .txt files in the directory tree.
    G. The code prints all of the words in the signed-words.txt file, each on a different line.

ANSWER
B
C
E

Numerous lines would have to be corrected for the code to compile, so
A, F, and G are incorrect.
First off, the second parameter to Files.find() is the depth limit
    and must be an int,
    so line k1 would have to be changed to make the code compile,
    and B is correct.
Next, the Files.find() method uses a BiPredictate<Path,BasicFileAttribute>,
    not a Predicate<Path>,
    for its lambda expression,
    so line k2 would also need to be changed to allow the code to compile,
    and C is also correct.

Finally,
    Files.readAllLines() returns a List<String>,
    not a stream,
    so the following line,
    k4,
    which applies flatMap(),
    would also prevent the code from compiling,
    and E is correct.

D is incorrect,
    since line k3 by itself does not cause any compilation issues.

For more information, see Chapter 9.

 */