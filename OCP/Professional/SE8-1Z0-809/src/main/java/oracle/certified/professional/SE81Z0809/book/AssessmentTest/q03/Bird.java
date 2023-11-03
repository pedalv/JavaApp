package oracle.certified.professional.SE81Z0809.book.AssessmentTest.q03;


import java.io.*;
import java.net.URL;

import static oracle.certified.professional.SE81Z0809.book.helper.Directories.*;

public class Bird implements Serializable { // Line 3

    private String name;
    private transient int age; // Line 5
    private Tail tail;

    public String getName() { return name; }
    public Tail getTail() { return tail; }

    public void setName(String name) { this.name = name; }
    public void setTail(Tail tail) { this.tail = tail; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public static void main(String[] args) {

        String current = GettingCurrentWorkingDirectory();
        System.out.println(String.format("Current: %s",current));
        // C:\Space2\JavaApp\OCP\OCP\source

        String filepath = getAbsolutePathFile("src/main/resources/no/book/AssessmentTest/q03/birds.dat");
        System.out.println(String.format("Filepath: %s", filepath));
        // C:\Space2\JavaApp\OCP\OCP\source\src\main\resources\no\book\AssessmentTest\q03\birds.dat

        URL url = getURLFile("no/book/AssessmentTest/q03/birds.dat");
        System.out.println(String.format("URL: %s", url));
        //file:/C:/Space2/JavaApp/OCP/OCP/source/target/classes/no/book/AssessmentTest/q03/birds.dat


        File initialFile = new File("src/main/resources/no/book/AssessmentTest/q03/birds.dat");
        try(InputStream targetStream = new FileInputStream(initialFile)) {
            System.out.println(targetStream);
            //java.io.FileInputStream@50675690
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(InputStream is = new ObjectInputStream( // Lina 16
                new BufferedInputStream(new FileInputStream("src/main/resources/no/book/AssessmentTest/q03/birds.dat")))) { // Line 17
            System.out.println(is.toString());
            //Bird bird = (Bird) is.readObject(); // Line 18
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            /*
            invalid stream header: 66657766
            java.io.StreamCorruptedException: invalid stream header: 66657766
                at java.io.ObjectInputStream.readStreamHeader(ObjectInputStream.java:866)
                at java.io.ObjectInputStream.<init>(ObjectInputStream.java:358)
                at no.book.AssessmentTest.q03.Bird.main(Bird.java:50)
             */
        }
    }

}

 /*
 Question 3
    A. It compiles and runs without issue.
        B. The code will not compile because of line 3.
        C. The code will not compile because of line 5.
D. The code will not compile because of lines 16–17.
E. The code will not compile because of line 18.
    F. It compiles but throws an exception at runtime.


 Answer
 D, E.
 The code does not compile due to a number of issues, so A and F are incorrect.

 First off, the readObject() method is not available to the InputStream class,
    and since the ObjectInputStream has been upcast to InputStream,
    the code will not compile due to line 18, so E is correct.

Class InputStream
    java.lang.Object
        java.io.InputStream
All Implemented Interfaces:
    Closeable, AutoCloseable
Direct Known Subclasses:
    AudioInputStream,
    ByteArrayInputStream,
    FileInputStream, FilterInputStream, InputStream,
    ObjectInputStream,
    PipedInputStream,
    SequenceInputStream,
    StringBufferInputStream
Constructor and Description
    InputStream()
Method Summary
Modifier and Type	Method - Description
int	                available() - Returns an estimate of the number of bytes that can be read (or skipped over) from this input stream without blocking by the next invocation of a method for this input stream.
void	            close() - Closes this input stream and releases any system resources associated with the stream.
void	            mark(int readlimit) - Marks the current position in this input stream.
boolean	            markSupported() - Tests if this input stream supports the mark and reset methods.
abstract int	    read() - Reads the next byte of data from the input stream.
int	                read(byte[] b) - Reads some number of bytes from the input stream and stores them into the buffer array b.
int	                read(byte[] b, int off, int len) - Reads up to len bytes of data from the input stream into an array of bytes.
void	            reset() - Repositions this stream to the position at the time the mark method was last called on this input stream.
long	            skip(long n) - Skips over and discards n bytes of data from this input stream.

Class ObjectInputStream
    java.lang.Object
        java.io.InputStream (upcast)
            java.io.ObjectInputStream (here)
All Implemented Interfaces:
    Closeable, DataInput, ObjectInput, ObjectStreamConstants, AutoCloseable

    Line 18 will also not compile because the return type of readObject()
        is of type Object and must be cast explicitly to Bird in order to be
        assigned to the Bird reference.
    Furthermore, constructors and methods on lines 16, 17, and 18
        throw checked IOExceptions that must be caught, so D is also correct.
    Note that line 18 also throws ClassNotFoundException.

    Lines 3 and 5 compile without issue, so B and C are incorrect.
    It should be noted that even if the compilation problems were resolved,
        the code would still throw an exception at runtime since the Bird class includes
        a Tail reference as a member,
        and the Tail class does not implement Serializable.
For more information, see Chapter 8.
  */