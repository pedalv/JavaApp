## Java 8 Stream API : [Part 1](https://app.pluralsight.com/guides/java-8-stream-api-part-1), [Part 2](https://app.pluralsight.com/guides/java-8-stream-api-part-2)
- [Interface Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
  ```
  int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();
  ```

- Lambda
  ```
  () -> System.out.println("Hi");
  (String s) -> System.out.println(s);
  (String s1, String s2) -> System.out.println(s1 + s2);
  (s) -> System.out.println(s); s -> System.out.println(s);
  () -> 4; (int a) -> a*6;
  () -> {
     System.out.println("Hi");
     return 4;
  }
  (int a) -> {
     System.out.println(a);
     return a*6;
  }
  ```

    - Stream
        - Streams are wrappers for collections and arrays.
      ```
      List<String> words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
      Stream<String> stream = words.stream();
    
      Stream<String> stream = Stream.of("hello","hola", "hallo", "ciao");
    
      String[] words = {"hello", "hola", "hallo", "ciao"};
      Stream<String> stream = Stream.of(words);
      ```
        - Intermediate Operations
      ```
      Stream<String> s = Stream.of("m", "k", "c", "t")
      .sorted()
      .limit(3);
      ```
        - Stateless operations retain no state from previous elements when processing a new element so each can be processed independently of operations on other elements.
        - Stateful operations, such as distinct and sorted, may incorporate state from previously seen elements when processing new elements.

        - Terminal Operations
      ```
      int[] digits = {0, 1, 2, 3, 4 , 5, 6, 7, 8, 9};
      long n = IntStream.of(digits).count();
      System.out.println(IntStream.of(digits).findFirst()); // OK
      ```

        - Operations on Collections
      ```
      List<String> words = ...
    
      for(int i = 0; i < words.size(); i++) {
          System.out.println(words.get(i));
      }
    
      for(Iterator<String> it = words.iterator(); it.hasNext();) {
        System.out.println(it.next());
      }
    
      for(String w : words) {
        System.out.println(w);
      }
  
      //Stream
      - void forEach(Consumer<? super T> action)
      Stream<String> stream = words.stream();
      // As an anonymous class
      stream.forEach((new Consumer<String>() {
           public void accept(String t) {
               System.out.println(t);
          }
      });
      // As a lamba expression
      stream.forEach(t -> System.out.println(t));
      
      words.sorted()
        .limit(2)
        .forEach(System.out::println);
    
      Stream.of(wordList).forEach(t -> System.out.println(t.length()));
      Stream.of(wordList).forEach(System.out::println);
      Or wrap the code inside one lambda:
      Consumer<String> print = t -> {
        System.out.println(t.length());
        System.out.println(t);
      };
      words.forEach(print);
    
      List<String> words = Arrays.asList("hello", null, "");
      words.stream()
         .filter(t -> t != null) // ["hello", ""]
         .filter(t -> !t.isEmpty()) // ["hello"]
         .forEach(System.out::println); //hello
      ```
        - Data Search
      ```
      IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      stream.findFirst()
         .ifPresent(System.out::println); // 1
  
      IntStream stream2 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      stream2.findAny()
         .ifPresent(System.out::println); // 1
    
      Stream<String> stream = Stream.empty();
      System.out.println(
         stream.findAny().isPresent()
      ); // false
    
      IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      System.out.println(
         stream.anyMatch(i -> i%3 == 0)
      ); // true
    
      IntStream stream = IntStream.empty();
      System.out.println(
         stream.anyMatch(i -> i%3 == 0)
      ); // false
  
      IntStream stream2 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      System.out.println(
         stream2.anyMatch(i -> i%10 == 0)
      ); // false
    
      IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      System.out.println(
         stream.allMatch(i -> i > 0)
      ); // true
  
      IntStream stream2 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      System.out.println(
         stream2.allMatch(i -> i%3 == 0)
      ); // false
    
      IntStream stream = IntStream.empty();
      System.out.println(
         stream.allMatch(i -> i%3 == 0)
      ); // true
    
      IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      System.out.println(
         stream.noneMatch(i -> i > 0)
      ); // false
  
      IntStream stream2 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      System.out.println(
         stream2.noneMatch(i -> i%3 == 0)
      ); // false
  
      IntStream stream3 = IntStream.of(1, 2, 3, 4, 5, 6, 7);
      System.out.println(
         stream3.noneMatch(i -> i > 10)
      ); // true
    
      IntStream stream = IntStream.empty();
      System.out.println(
        stream.noneMatch(i -> i%3 == 0)
      ); // true
    
      - Stream<T> sorted()
      List<Integer> list = Arrays.asList(57, 38, 37, 54, 2);
      list.stream()
         .sorted()
         .forEach(System.out::println); //2 37 38 54 57  
    
      - Stream<T> sorted(Comparator<? super T> comparator)
      List<String> strings = Arrays.asList("Stream","Operations","on","Collections");
      strings.stream()
        .sorted( (s1, s2) -> s2.length() - s1.length() )
        .forEach(System.out::println); //Collections Operations Stream on
      ```
        - Data and Calculation Methods
      ```
      - long count()
      - Optional<T> max(Comparator<? super T> comparator)
      - Optional<T> min(Comparator<? super T> comparator)
  
      //IntStream
      - OptionalDouble average()
      - long count()
      - OptionalInt max()
      - OptionalInt min()
      - int sum()
    
      //LongStream
      - long count()
      - OptionalLong max()
      - OptionalLong min()
      - long sum()
  
      //DoubleStream
      - OptionalDouble average()
      - long count()
      - OptionalDobule max()
      - OptionalDouble min()
      - double sum()
    
      List<Integer> list = Arrays.asList(57, 38, 37, 54, 2);
      System.out.println(list.stream().count()); // 5
    
      List<String> strings = Arrays.asList("Stream","Operations","on","Collections");
      strings.stream()
         .min( Comparator.comparing((String s) -> s.length()))
         .ifPresent(System.out::println); // on
  
      System.out.println(IntStream.of(28,4,91,30).sum()); // 153
      System.out.println(IntStream.of(28,4,91,30).average()); // 38.25
      ```

        - map() is used to transform the value or the type of the elements of a stream:
      ```
      - <R> Stream<R> map(Function<? super T,? extends R> mapper)
      - IntStream mapToInt(ToIntFunction<? super T> mapper)
      - LongStream mapToLong(ToLongFunction<? super T> mapper)
      - DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
    
      Stream.of('a', 'b', 'c', 'd', 'e')
        .map(c -> (int)c)
        .forEach(i -> System.out.format("%d ", i)); //97 98 99 100 101
    
      IntStream.of(100, 110, 120, 130 ,140)
        .mapToDouble(i -> i/3.0)
        .forEach(i -> System.out.format("%.2f ", i)); //33.33 36.67 40.00 43.33 46.67
    
      ```

        - merge()

        - flatMap() is used to flatten (or combine) the elements of a stream into one (new) stream:
      ```
      - <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
      - DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper)
      - IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper)
      - LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper)
    
      List<Character> aToD = Arrays.asList('a', 'b', 'c', 'd');
      List<Character> eToG = Arrays.asList('e', 'f', 'g');
      Stream<List<Character>> stream = Stream.of(aToD, eToG);
      stream
        .flatMap(l -> l.stream()) //returns a stream
        .map(c -> (int)c) //returns an element
        .forEach(i -> System.out.format("%d ", i)); //97 98 99 100 101 102 103
    
      stream
        .flatMap(l -> l.stream()) //returns a stream
        .peek(System.out::print) //This way, with flatMap() you can convert a Stream<List<Object>> to Stream<Object>.
        .map(c -> (int)c) //returns an element
        .forEach(i -> System.out.format("%d ", i)); //a97 b98 c99 d100 e101 f102 g103
      ```

        - Reduction  is an operation that takes many elements and combines them to reduce them into a single value or object. Reduction is done by applying an operation multiple times.
      ```
      collect()
      reduce()
      - Optional<T> reduce(BinaryOperator<T> accumulator) //Remember that a BinaryOperator<T> is equivalent to a BiFunction<T, T, T>, where the two arguments and the return type are all of the same types.
      - T reduce(T identity, BinaryOperator<T> accumulator)
      - <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
    
      OptionalInt total = IntStream.of(1, 2, 3, 4, 5, 6)
                          .reduce( (sum, n) -> sum + n ); // 21
    
      int total = IntStream.of(1, 2, 3, 4, 5, 6)
                   .reduce( 0, (sum, n) -> sum + n ); // 21
    
      int total = IntStream.of(1, 2, 3, 4, 5, 6)
                    .reduce( 4, (sum, n) -> sum + n ); // 25
      //However, notice that in the example above, the first value cannot be considered an identity because, for instance, 4 + 1 is not equal to 4.
    
      int length = 
      Stream.of("Parallel", "streams", "are", "great")
          .reduce(0,
                (Integer accumInt, String str) -> accumInt + str.length(), //accumulator
                (Integer accumInt1, Integer accumInt2) -> accumInt1 + accumInt2);//combiner
      or
      int length =
        Stream.of("Parallel", "streams", "are", "great")
            .mapToInt(s -> s.length())
            .reduce(0, (sum, strLength) -> sum + strLength);
      or
      int length = Stream.of("Parallel", "streams", "are", "great")
                    .mapToInt(s -> s.length())
                    .sum();
      ```

        - collect
      ```
      - <R,A> R collect(Collector<? super T,A,R> collector)
      - <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
    
      List<Integer> list =
        Stream.of(1, 2, 3, 4, 5)
            .collect(
               () -> new ArrayList<>(),
               (l, i) -> l.add(i),
               (l1, l2) -> l1.addAll(l2)
            );
      or
      List<Integer> list =
        Stream.of(1, 2, 3, 4, 5)
            .collect(
               ArrayList::new,
               ArrayList::add,
               ArrayList::addAll
            );
    
      ```

        - Collectors
      ```
      List<Integer> list =
        Stream.of(1, 2, 3, 4, 5)
            .collect(Collectors.toList()); // [1, 2, 3, 4, 5]
      or
      import static java.util.stream.Collectors.*;
      ...
      List<Integer> list =
      Stream.of(1, 2, 3, 4, 5)
         .collect(toList()); // [1, 2, 3, 4, 5]
    
      String s = Stream.of("a", "simple", "string")
                   .collect(joining()); // "asimplestring"
    
      String s = Stream.of("a", "simple", "string")
                  .collect(joining(" ")); // " a simple string"
    
      //separator - prefix - suffix
      String s = Stream.of("a", "simple", "string")
                 .collect(joining(" ", "This is ", ".")); // "This is a simple string."
    
      double avg = Stream.of(1, 2, 3)
                    .collect(averagingInt(i -> i * 2)); // 4.0
  
      long count = 
      Stream.of(1, 2, 3)
        .collect(counting()); // 3
  
      Stream.of(1, 2, 3)
        .collect(maxBy(Comparator.naturalOrder()))
        .ifPresent(System.out::println); // 3
  
      Integer sum = 
      Stream.of(1, 2, 3)
         .collect(summingInt(i -> i)); // 6
      ```

        - groupingBy(Function<? super T,? extends K> classifier)
      ```
      Map<Integer, List<Integer>> map =
      Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
         .collect( groupingBy (i -> i/10 * 10 ) ); //{0=[2], 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}
      ```

        - groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
      ```
      Map<Integer, Long> map =
      Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
         .collect(groupingBy(i -> i/10 * 10, counting())); //{0=1, 50=2, 20=2, 10=2, 30=3}
  
      Map<Integer, Map<String, List<Integer>>> map =
      Stream.of(2,34,54,23,33,20,59,11,19,37)
         .collect(groupingBy(i -> i/10 * 10, groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD")));
      //RESULT
      {
        0 = {EVEN=[2]},
        50 = {EVEN=[54], ODD=[59]},
        20 = {EVEN=[20], ODD=[23]},
        10 = {ODD=[11, 19]},
        30 = {EVEN=[34], ODD=[33, 37]}
      }
      ```

        - groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
      ```
      //******************IMPORTANT*****************
      Map<Integer, Map<String, List<Integer>>> map =
      Stream.of(2,34,54,23,33,20,59,11,19,37)
        .collect( groupingBy(i -> i/10 * 10,
                             TreeMap::new,
                             groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD"))
                 );
      //RESULT
      {
          0 = {EVEN=[2]},
          10 = {ODD=[11, 19]},
          20 = {EVEN=[20], ODD=[23]},
          30 = {EVEN=[34], ODD=[33, 37]},
          50 = {EVEN=[54], ODD=[59]}
      }
      ```

    - partitioningBy(), The difference with groupingBy() is that partitioningBy() will return a Map with a Boolean as the key type, which means there are only two groups, one for true and one for false.
  ```
  - partitioningBy(Predicate<? super T> predicate)
  Map<Boolean, List<Integer>> map =
    Stream.of(45, 9, 65, 77, 12, 89, 31)
        .collect(partitioningBy(i -> i < 50)); //{false=[65, 77, 89], true=[45, 9, 12, 31, 12]}

  Map<Boolean, Set<Integer>> map =
    Stream.of(45, 9, 65, 77, 12, 89, 31, 12)
        .collect(partitioningBy(i -> i < 50, toSet())); //{false=[65, 89, 77], true=[9, 12, 45, 31]}
  Set<Integer> lessThan50 = map.get(true);
  Set<Integer> moreThan50 = map.get(false);
  ```

    - [Leveraging Parallel Streams for Fast Data Processing in Java 8](https://app.pluralsight.com/library/courses/leveraging-parallel-streams-fast-data-processing-java/table-of-contents)
    - Parallel Streams use the Fork/Join Framework. This means that, by default, the number of threads available to process parallel streams equals the number of available cores in your machine's processor (CPU).
  ```
  Stream<String> parallelStream = Stream.of("a","b","c").parallel();
  
  List<String> list = Arrays.asList("a","b","c");
  Stream<String> parStream = list.parallelStream();
  
  stream
   .parallel()
      .filter(..)
         .sequential()
            .forEach(...);
  
  stream.parallel().isParallel(); // true
  
  stream
   .parallel()
      .unordered()
         .collect(...);
  
  Stream.of("a","b","c","d","e")
    .forEach(System.out::print); //abcde
  
  Stream.of("a","b","c","d","e")
    .parallel()
    .forEach(System.out::print);
  //RESULT
  cbade // One execution
  cebad // Another execution
  cbdea // Yet another execution
  
  //******************IMPORTANT*****************
  long start = System.nanoTime();
  String first = Stream.of("a","b","c","d","e").parallel().findFirst().get();
  long duration = (System.nanoTime() - start) / 1000000;
  System.out.println(first + " found in " + duration + " milliseconds");//a found in 2.436155 milliseconds
  
  long start = System.nanoTime();
  String any = Stream.of("a","b","c","d","e").parallel().findAny().get();
  long duration = (System.nanoTime() - start) / 1000000;
  System.out.println(any + " found in " + duration + " milliseconds"); //c found in 0.063169 milliseconds
  
  
  double start = System.nanoTime();
  Stream.of("b","d","a","c","e")
    .sorted()
    .filter(s -> {
      System.out.println("Filter:" + s);
      return !"d".equals(s);
    })
    .parallel()
    .map(s -> {
      System.out.println("Map:" + s);
      return s += s;
    })
    .forEach(System.out::println);
  double duration = (System.nanoTime() - start) / 1_000_000;
  System.out.println(duration + " milliseconds");
  //RESULT
  Filter:c
  Map:c
  cc
  Filter:a
  Map:a
  aa
  Filter:b
  Map:b
  bb
  Filter:d
  Filter:e
  Map:e
  ee
  79.470779 milliseconds
  
  //Compare this with the output of the sequential version (just comment out .parallel()):
  Filter:a
  Map:a
  aa
  Filter:b
  Map:b
  bb
  Filter:c
  Map:c
  cc
  Filter:d
  Filter:e
  Map:e
  ee
  1.554562 milliseconds
  
  double start = System.nanoTime();
  long c = IntStream.rangeClosed(0, 1_000_000_000)
    .parallel()
    .filter(i -> i % 2 == 0)
    .count();
  double duration = (System.nanoTime() - start) / 1_000_000;
  System.out.println("Got " + c + " in " + duration + " milliseconds");
  //The parallel version output: Got 500000001 in 738.678448 milliseconds
  //The sequential version output: Got 500000001 in 1275.271882 milliseconds
  ```

    - Reducing Parallel Streams, In concurrent environments, assignments are bad. This is because if you mutate the state of variables (especially if they are shared by more than one thread), you may run into invalid states.
  ```
  class Total {
    public long total = 1;
    public void multiply(long n) { total *= n; }
  }
  ...
  Total t = new Total();
  LongStream.rangeClosed(1, 10)
    .forEach(t::multiply);
  System.out.println(t.total); //3628800
  
  LongStream.rangeClosed(1, 10)
    .parallel()
    .forEach(t::multiply); //Sometimes we get the correct result and other times we don't.
  
  long tot = LongStream.rangeClosed(1, 10)
                .parallel()
                .reduce(1, (a,b) -> a*b);
  System.out.println(tot); //3628800
  ```
    - We can safely use collect() with parallel streams if we follow the same requirements of associativity and identity. (For example, combining any partially accumulated result with an empty result container must produce an equivalent result.)
    - Or, if we are grouping with the Collectors class and ordering is not important, we can use the method groupingByConcurrent(), the concurrent version of groupingBy().

## TIPs
- Use Java streams to filter, transform and process data.
- Perform decomposition and reduction, including grouping and partitioning on sequential and parallel streams.
- A lambda expression is an anonymous method.
- Functional programming: Passing code as data.
- Lambda expression implements functional interface.
- Catch an exception in a loop with lambda expressions can be very verbose.
- Captured local variable must be effectively final. This approach should simplify the process of making lambda execution thread-safe.
- One of the main purposes of lambdas is use in parallel computing, which means that they're really helpful when it comes to thread-safety.
    ```
    int[] total = new int[1];
    Runnable r = () -> total[0]++;
    r.run();
    ```
- [Lambda Expressions and Functional Interfaces: Tips and Best Practices](https://www.baeldung.com/java-8-lambda-expressions-tips)
- [Functional Interfaces in Java 8](https://www.baeldung.com/java-8-functional-interfaces)
- Method references: products.forEach(product -> System.out.println(product)) => products.forEach(System.out::println)
- map() - one to one - is used to transform the value or the type of the elements of a stream => String, integer, Long, etc
  - ``` Stream<Stream<String>> streammap = products.stream().map(product -> spaces.splitAsStream(product.getName())); ```
- flatMap() - one to many -  is used to flatten (or combine) the elements of a stream into one (new) stream => ? 
  -  ``` Stream<String> streamflastmap = products.stream().flatMap(product -> spaces.splitAsStream(product.getName())); ```
- Reducing Bugs with Immutable Data
  - ``` final String = "data not change after created"; ```
- Lazy Evaluation : delays the evaluation of an expression until its value is needed
  - Powered by pure functions
- Stream, Lazy evaluation, stream.sort()
- Collection, Eager evaluation, list.sort()
- Caching results => Functional programming -> Lazy evaluation === Memoization, Sample: Redux => Store - memoized - Selector  
- Memoization: to speed up computer programs by storing the results of expensive function calls and returning the cached result when sa,e inputs occur again.
- Benefits  of functional programming:  memorization, parallelism, reducing bugs, do one thing well === decompose problems
  - public IEnumerable<T> findCoursesForAuthor<T> (T author, IEnumerable<T> courses), C# Generics
  - public Iterator<T> findCoursesForAuthor<T> (T author, Iterator<T> courses), Java Generics
- Functional Programming Languages: Java, .Net (#C), Javascript, Scala, Haskell, Elixir (from 2011 and influenced by Ruby); Dynamic type language: Pearl, Java, Rubby, Python, Javascript; Multi-paradigm language: .Net (F#)
- Functional Programming : A programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data.
- Pure Function : Does not cause side effects, and will always return the same result for a given input.
- OOP: More data structures - Fewer functions per data structure - 10 functions on 10 data structures
- FP : Fewer data stuctures - More functions per data structure -  100 functions on 1 data structure

## Resources
- [Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/streams-lambda-expressions-java-se-11-developer-certification-1z0-819/table-of-contents)
- [Implementing Concurrency in Java (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/java-concurrency-implementing-certification-1z0-819)
- [Secure Coding Practices in Java Applications (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/secure-coding-practices-java-applications-java-se-11-developer-certification-1z0-819)
- [Working with Arrays and Collections in Java (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/arrays-collections-java-se-11-developer-certification-1z0-819)
- [Implementing Localization in Java (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/implementing-localization-java-se-11-developer-certification-1z0-819)
- [Working with the Java Module System (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/java-module-system-java-se-11-developer-certification-1z0-819/table-of-contents)
- [Using Annotations in Java (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/using-annotations-java)
- [Database Applications with JDBC in Java SE Applications (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/database-applications-jdbc-applications-java-se-11-developer-certification-1z0-819)
- [Working with Java I/O API in Java SE Applications (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/java-io-api-java-se-applications-java-se-11-developer-certification-1z0-819)
- [Exception Handling in Java (Java SE 11 Developer Certification 1Z0-819)](https://app.pluralsight.com/library/courses/exception-handling-java-se-11-developer-certification-1z0-819)
- [Java SE 11 Developer Certification 1Z0-819 Overview](https://app.pluralsight.com/library/courses/java-se-11-developer-certification-1z0-819-overview)
- [From Collections to Streams in Java 8 Using Lambda Expressions](https://app.pluralsight.com/library/courses/java-8-lambda-expressions-collections-streams/table-of-contents)
- [Using Lambda Expressions in Java 8 Code](https://app.pluralsight.com/library/courses/lambda-expressions-java-code/table-of-contents)
- [Implementing Design Patterns Using Java 8 Lambda](https://app.pluralsight.com/library/courses/implementing-design-patterns-java-8-lambda-expression/table-of-contents)
- [Streams, Collectors, and Optionals for Data Processing in Java 8](https://app.pluralsight.com/library/courses/java-8-data-processing-streams-collectors-optionals/table-of-contents)
- [Using Java 8 Streams to Process and Analyze Data in Memory](https://app.pluralsight.com/library/courses/java-streams-process-analyze-data-memory/table-of-contents)
- [Handling Streaming Data with a Kafka Cluster](https://app.pluralsight.com/library/courses/handling-streaming-data-kafka-cluster/table-of-contents)
- [Leveraging Parallel Streams for Fast Data Processing in Java 8](https://app.pluralsight.com/library/courses/leveraging-parallel-streams-fast-data-processing-java/table-of-contents)
- [Java: JSON Fundamentals](https://app.pluralsight.com/library/courses/java-json-fundamentals/table-of-contents)
- [Introduction to Developing AWS Lambdas in Java](https://app.pluralsight.com/library/courses/enterprise-aws-lambdas-java-eclipse-ide/table-of-contents)
- [Functional Reactive with Core JDK - by Sven Ruppert (Foojay JUG tour)](https://www.youtube.com/watch?v=dljXXu3eEnU)
- [javaBin Online: "Fight Complexity with Functional Programming", Gopal Akshintala](https://www.youtube.com/watch?v=tnpL1O8kTbM)

## Functions, functional interfaces:
- A functional interface has a single abstract method.
- Any interface with a SAM(Single Abstract Method) is a functional interface, and its implementation may be treated as lambda expressions.
- Standard functional interfaces in package java.util.function.
- Examples: 
  - interface Function<T, R> { R apply(T value); }
  - interface Consumer<T> { void accept(T value); }
    - the Consumer accepts a generified argument and returns nothing: DoubleConsumer, IntConsumer and LongConsumer
  - interface Supplier<T> { T get(); }
    - Opposite of consumer 
    - BooleanSupplier, DoubleSupplier, LongSupplier and IntSupplier, whose return types are corresponding primitives.
  - interface Predicate<T> { boolean test(T value); }
    - Predicates is a function that receives a value and returns a boolean value: IntPredicate, DoublePredicate and LongPredicate
  - interface UnaryOperator<T> { T apply(T value); }
      - Operators. Operator interfaces are special cases of a function that receive and return the same value type. 
  - BiFunction: DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction: having both argument and return type defined as primitive types, as specified by their names
    - interface BiFunction<T, U, R> { R apply(T v1, U v2); }
    - interface BiConsumer<T, U> { void apply(T v1, U v2); }
    - interface BiPredicate<T, U> { boolean test(T v1, U v2); }
    - interface BinaryOperator<T> { T test(T v1, T v2); }
      - Operators. Operator interfaces are special cases of a function that receive and return the same value type.
      - interface IntBinaryOperator<T> { int applyAsOnt(int v1, int v2); }
  - default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) { ... }
    - it works as a map with key, values
    ```
      Map<Category, List<Product>> productsByCategory = new HashMap<>();
      ...
      productsByCategory.computeIfAbsent(category, c -> new ArrayList<>()).add(product);
    ```
  - Map<String, Integer> nameMap = new HashMap<>(); Integer value = nameMap.computeIfAbsent("John", String::length);
  - IntFunction, LongFunction, DoubleFunction: arguments are of specified type, return type is parameterized
  - ToIntFunction, ToLongFunction, ToDoubleFunction: return type is of specified type, arguments are parameterized
  - @FunctionalInterface public interface ShortToByteFunction { byte applyAsByte(short s); }
  - reduction operation: se above, Reduction  is an operation that takes many elements and combines them to reduce them into a single value or object. Reduction is done by applying an operation multiple times.
- Functional Composition
  - combine to function in one
    - **Function** andThen **Function**
    - **Function** compode **Function**
    - **Predicate** and **Predicate**
  ```
  Function<Product, BigDecimal> productToPrice = Product::getPrice;
  Function<BigDecimal, String> priceToMessage = price -> String.format("The price of %s is $ %.2f%n", name, price);

  //From
  .map(productToPrice)
  .map(priceToMessage)
  //To
  // Compose a new function out of the two functions above by using andThen(...)
  Function<Product, String> productToMessage = productToPrice.andThen(priceToMessage);
  // Alternative: use compose(...), which is the same as andThen(...) except that the order of the functions is reversed
  // Function<Product, String> productToMessage = priceToMessage.compose(productToPrice);
  .map(productToMessage)
  
  // Two simple predicates that can be combined using the functional composition methods in interface Predicate.
  Predicate<Product> isFood = product -> product.getCategory() == Category.FOOD;
  Predicate<Product> isCheap = product -> product.getPrice().compareTo(priceLimit) < 0;
  isFood.and(isCheap)
  ```
  
  