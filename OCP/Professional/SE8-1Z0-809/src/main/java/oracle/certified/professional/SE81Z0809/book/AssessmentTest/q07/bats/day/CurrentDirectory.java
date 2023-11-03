package oracle.certified.professional.SE81Z0809.book.AssessmentTest.q07.bats.day;


import oracle.certified.professional.SE81Z0809.book.helper.Directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrentDirectory {

    public static void main(String ... args) {
        Path path1 = null, path2 = null;

        Directories.GettingCurrentWorkingDirectory();
        // Current dir:C:\Space2\JavaApp\OCP\OCP\source

        path1 = Paths
                .get("src/main/resources/no/book/AssessmentTest/q07/bats/night","../")
                .resolve(Paths.get("./sleep.txt"))
                .normalize();
        System.out.println(String.format("Path1: %s",path1));
        // Path1: src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt

        try {
            path2 = new File("src/main/resources/no/book/AssessmentTest/q07/bats/sleep.txt")
                    .toPath()
                    .toRealPath();
            System.out.println(String.format("Path2: %s",path2));
            // Path2: C:\Space2\JavaApp\OCP\OCP\source\src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt
        } catch (IOException e) {
            System.out.println(String.format("Exception: %s",e.getMessage()));
            //e.printStackTrace();
        }

        try {
            System.out.print(Files.isSameFile(path1,path2));
        } catch (IOException e) {
            System.out.println(String.format("Exception: %s",e.getMessage()));
            //Exception: src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt
            e.printStackTrace();
            /*
            java.nio.file.NoSuchFileException: src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt
                at sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:79)
                at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:97)
                at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:102)
                at sun.nio.fs.WindowsFileSystemProvider.isSameFile(WindowsFileSystemProvider.java:427)
                at java.nio.file.Files.isSameFile(Files.java:1504)
                at no.book.AssessmentTest.q07.bats.day.CurrentDirectory.main(CurrentDirectory.java:35)
             */
        }
        System.out.print(" "+path1.equals(path2));
    }

}

/*
Question 7
A. true true
B. false false
C. true false
D. false true
    E. The code does not compile.
    F. The code compiles but throws an exception at runtime.

Answer
A.
The code compiles and runs without issue, so E and F are incorrect.
For this question,
    it helps if you resolve each path to a simplified form component before answering it.
The path1 variable simplifies to /bats/sleep.txt after the Path operations have been applied.
- Path1: src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt => OKAY
The path2 variable using the current directory of /bats/day is assigned a path value of /bats/sleep.txt.
- Path2: C:\Space2\JavaApp\OCP\OCP\source\src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt => OKAY

Since the file Path objects represent the same path within the file system,
    they will return true for both
    equals()
    and isSameFile(),
so A is the correct answer
and B, C, and D are incorrect.
For more information, see Chapter 9.

C ARE THE CORRECT ONE
- equals(): NO NO NO - Fails relative path is not equal to absolute path
- and isSameFile(): OKAY

Current dir using System:C:\Space2\JavaApp\OCP\OCP\source
Path1: src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt
Path2: C:\Space2\JavaApp\OCP\OCP\source\src\main\resources\no\book\AssessmentTest\q07\bats\sleep.txt
true false (c)

Path path1 = Paths.get("/bats/night","../").resolve(Paths.get("./sleep.txt")).normalize();
Path path2 = new File("../sleep.txt").toPath().toRealPath();
 */