package no.book.chapter1AdvancedClassDesign.imports;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/*
The key is to note that this question really has two parts.

One thing to figure out is how to get sort(list) to compile.
Since sort() is a static method on Collections, you definitely need a static import.
Either of these will do it:
import static java.util.Collections.sort;
import static java.util.Collections.*;

The other part of the question is to note that List and ArrayList are both referenced.
These are regular classes and need regular imports.
One option is to use a wildcard:
import java.util.*;
The other option is to list them out:
import java.util.List;
import java.util.ArrayList;

There are other imports you can add, but they have redundancy or are unnecessary.
For example, you could import java.lang.*.
However, this package is always imported whether you specify it or not.
 */
public class ListHelper {

    public List <String> copyAndSortList(List<String> original) {
       List <String> list = new ArrayList<String>(original);
        sort(list);
        return list;
    }

}
