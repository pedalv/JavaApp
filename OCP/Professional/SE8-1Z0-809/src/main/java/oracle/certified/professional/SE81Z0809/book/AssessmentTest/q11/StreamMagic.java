package oracle.certified.professional.SE81Z0809.book.AssessmentTest.q11;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamMagic {

    private static void magic(Stream<Integer> s) {
        Optional o = s
                .filter(x -> x < 5)
                .limit(3)
                .max((x, y) -> x-y); // .max(Comparator.comparingInt(x -> x));

        System.out.println(o.get());
    }

    public static void main(String ... args) {
        //magic(Stream.empty()); //runs infinitely.
        /*
        Exception in thread "main" java.util.NoSuchElementException: No value present
            at java.util.Optional.get(Optional.java:135)
            at no.book.AssessmentTest.q11.StreamMagic.magic(StreamMagic.java:14)
            at no.book.AssessmentTest.q11.StreamMagic.main(StreamMagic.java:18)
         */
        // OKAY // magic(Stream.empty()); //throws an exception.

        //magic(Stream.iterate(1, x ->> x++)); //runs infinitely.
        // Error: java: illegal start of expression

        //magic(Stream.iterate(1, x ->> x++)); //throws an exception.
        // Error: java: illegal start of expression
        magic(Stream.of(5, 10)); //runs infinitely.
        /*
        Exception in thread "main" java.util.NoSuchElementException: No value present
            at java.util.Optional.get(Optional.java:135)
            at no.book.AssessmentTest.q11.StreamMagic.magic(StreamMagic.java:14)
            at no.book.AssessmentTest.q11.StreamMagic.main(StreamMagic.java:32)
         */


        // OKAY //magic(Stream.of(5, 10)); //throws an exception.

    }

}

/*
Which of the following are true? (Choose all that apply.)

        A. magic(Stream.empty()); runs infinitely.
B. magic(Stream.empty()); throws an exception.
    C. magic(Stream.iterate(1, x ->> x++)); runs infinitely.
    D. magic(Stream.iterate(1, x ->> x++)); throws an exception.
        E. magic(Stream.of(5, 10)); runs infinitely.
F. magic(Stream.of(5, 10)); throws an exception.
            G. The method does not compile.

Anawer
B
F.

Calling get() on an empty Optional causes an exception to be thrown, making options B and F correct.
Option C is incorrect because the infinite stream is made finite
    by the intermediate limit() operation.
Options A and E are incorrect because the source streams are not infinite.
Therefore, the call to max() sees only three elements and terminates.
For more information, see Chapter 4.

 */