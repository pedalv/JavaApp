package oracle.certified.professional.SE81Z0809.book.chapter7Concurrency.AssigmentTest.q05;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class CodeSnippet {

    public static void main(String ...args) {

        List<Integer> source = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> fish = new CopyOnWriteArrayList<>(source);
        List<Integer> mammals = Collections.synchronizedList(source); // synchronized List
        Set<Integer> birds = new ConcurrentSkipListSet<>();

        birds.addAll(source);

        synchronized(new Integer(10)) {
            for(Integer f: fish) fish.add(4); // c1

            for(Integer m: mammals) mammals.add(4); // c2 - mammals is a synchronized list and not a concurrent one
            /*
            Exception in thread "main" java.util.ConcurrentModificationException
                at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
                at java.util.ArrayList$Itr.next(ArrayList.java:859)
                at no.book.AssessmenTest.q05.CodeSnippet.main(CodeSnippet.java:21)
             */

            for(Integer b: birds) birds.add(5); // c3

            System.out.println(fish.size()+" "+mammals.size()+" "+birds.size());
        }

    }
}

/*
Question 5
        A. It outputs 4 8 5.
    B. It outputs 8 4 5.
        C. It outputs 8 8 8.
    D. The code does not compile.
        E. It compiles but throws an exception at runtime on line c1.
F. It compiles but throws an exception at runtime on line c2.
        G. It compiles but throws an exception at runtime on line c3.
        H. It compiles but enters an infinite loop at runtime.

Answer
F.
The code compiles without issue, so D is incorrect.
The code throws a ConcurrentModificationException at runtime on line c2,
    because mammals is a synchronized list and not a concurrent one.
Therefore, it is not safe to be used inside an iterator, and F is the correct answer.
Note that if line c2 were removed, the rest of the code would
    run without throwing an exception, outputting 8 4 5.
See Chapter 7 for more information.
 */