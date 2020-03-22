package no.book.chapter3GenericsandCollections.workingwithgenerics.bounds;

/*
By now,
    you might have noticed that generics don’t seem particularly useful since they are treated as Objects
    and therefore don’t have many methods available.
Bounded wildcards solve this by restricting what types can be used in that wildcard position.
A bounded parameter type is a generic type that specifies a bound for the generic.
A wildcard generic type is an unknown generic type represented with a question mark (?).
You can use generic wildcards in three ways,
1. Unbounded wildcard,              ?,              List<?> l =new ArrayList<String>();
2. Wildcard with an upper bound,    ? extends type, List<? extends Exception> l =new ArrayList<RuntimeException>();
3. Wildcard with a lower bound,     ? super type,   List<? super Exception> l =new ArrayList<Object>();
 */
public class Bounds {
}

/*
    java.lang.Object                            ? super type <=> ? super Exception => new ArrayList<RuntimeException>();
        java.lang.Throwable
            java.lang.Exception                 HERE
                java.lang.RuntimeException      ? extendens type <=> ? extends Exception => new ArrayList<RuntimeException>();
 */
