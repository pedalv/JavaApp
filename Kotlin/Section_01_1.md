# [Java Interoperability](https://docs.oracle.com/javase/tutorial/collections/interoperability/index.html)
- Interoperability tells us how the Collections Framework interoperates with older APIs that predate the addition of Collections to Java. Also, it tells you how to design new APIs so that they'll interoperate seamlessly with other new APIs.

1. [Compatibility](https://docs.oracle.com/javase/tutorial/collections/interoperability/compatibility.html): Describes how collections can be made to work with older APIs that predate the addition of Collections to the Java platform.

2. [API Design](https://docs.oracle.com/javase/tutorial/collections/interoperability/api-design.html): Describes how to design new APIs so that they will interoperate seamlessly with one another.

Java is a statically typed language that including the primitive types like int or boolean, arrays and all the Java classes, interfaces, enums and annotations that reside on the class path.  Java Generics allow define type parameters on methods and classes and pass type arguments to generic types just as you are used to from Java. The type system and its conformance and casting rules are implemented as defined in the Java Language Specification.

# Java collection framework: 
- Course: 
1. [From Collections to Streams in Java 8 Using Lambda Expressions](https://www.pluralsight.com/courses/java-8-lambda-expressions-collections-streams?clickid=WIiUwpWDFWpZSjkRjB1xvwA%3AUkgXgVV2LxHx2w0&irgwc=1&mpid=1193463&utm_source=impactradius&utm_medium=digital_affiliate&utm_campaign=1193463&aid=7010a000001xAKZAA2)

2. [Java Fundamentals: Collections](https://www.pluralsight.com/courses/java-fundamentals-collections?clickid=WIiUwpWDFWpZSjkRjB1xvwA%3AUkgXgkzmLxHx2w0&irgwc=1&mpid=1193463&utm_source=impactradius&utm_medium=digital_affiliate&utm_campaign=1193463&aid=7010a000001xAKZAA2)

- Set, List and Map are three important interfaces of Java collection framework
- List in Java provides ordered and indexed collection which may contain duplicates.
1. If you need to access elements frequently by using the index than List is a way to go. Its implementation e.g. ArrayList provides faster access if you know index.

2. If you want to store elements and want them to maintain an order on which they are inserted into a collection then go for List again, as List is an ordered collection and maintain insertion order.

- The Set interface provides an unordered collection of unique objects.
1.  If you want to create a collection of unique elements and don't want any duplicate than choosing any Set implementation e.g. HashSet, LinkedHashSet or TreeSet. All Set implementation follow there general contract e.g. uniqueness but also add addition feature e.g. TreeSet is a SortedSet and elements stored on TreeSet can be sorted by using Comparator or Comparable in Java. LinkedHashSet also maintains insertion order.

- Map provides a data structure based on key-value pair and hashing.
1. If you store data in form of key and value than Map is the way to go. You can choose from Hashtable, HashMap, TreeMap based upon your subsequent need. In order to choose between first two see the difference between HashSet and HashMap in Java.

![Java Collection Framework](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/JavaCollectionFramework.PNG)
