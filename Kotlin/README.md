# Kotlin
- For Java programmers wanting to be prepared for future project work on web side.
- For Android app developer who knows Java well, but we want to be able to move forward with Kotlin for new Android development work.

# Kotlin in JZ2018
- [Asynchronous Programming with Kotlin](https://2018.javazone.no/program/05be4d7b-ccce-4b9f-8a86-a51d033fb5a3)
- [Springing into Kotlin: How to Make the Magic even more Magical](https://2018.javazone.no/program/c76d33ef-665a-48bb-a939-32b7087975a8)
- [The beauty and elegance of testing in Kotlin](https://2018.javazone.no/program/5b95ae2c-41de-489b-bf44-1260d8b0f12b)
- [Kotlin på Android = <3](https://2018.javazone.no/program/82eff0c6-6d24-4531-90f6-3a7577f013d5)

# [Kotlin for Java Developers](https://www.udemy.com/kotlin-for-java-developers/learn/v4/content)
Lectures: 91 and Video: 16.5 hours
- Section 1: Introduction to the course
- Section 2: Introduction to Kotlin
- Section 3: Basic Differences Between Kotlin and Java
- Section 4: Data Types and Null Reference Handling
- Section 5: OO and Kotlin: Classes, Functions, Inheritace
- Section 6: Loops, and the if, When, and Try/Catch Expressions
- Section 7: Lambda Expressions, Collections, and Generics
- Section 8: File I/O
- Section 9: Java Interoperability
- Section 10: Course Wrap Up
- Section 11: Bonus Material

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

![Java Collection Framework](https://github.com/pedalv/JavaApp/blob/master/Kotlin/JavaCollectionFramework.PNG)

# Prerequisites

```
Pedro Alves@DESKTOP-TC6U1JA MINGW64 /c/Space2/JavaApp/Kotlin (master)
$ java -version
java version "11.0.2" 2019-01-15 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.2+9-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.2+9-LTS, mixed mode)

Pedro Alves@DESKTOP-TC6U1JA MINGW64 /c/Space2/JavaApp/Kotlin (master)
$ mvn -version
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T20:41:47+02:00)
Maven home: C:\JavaTools\apache-maven-3.6.0
Java version: 11.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.2
Default locale: no_NO, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

- Install JDK on Windows/MAC/Linux, [Java SE Downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- Install JDK version, [Java Early Access Downloads](https://www.oracle.com/technetwork/articles/java/ea-jsp-142245.html) - [Oracle Java Archive](https://www.oracle.com/technetwork/java/archive-139210.html) - [jdk.java.net - JDK 13 Early-Access Builds](https://jdk.java.net/13/)
- Install Maven on Windows/MAC/Linux, [Downloading Apache Maven 3.6.0](https://maven.apache.org/download.cgi) 
- Install/Config IDE on Windows/MAC/Linux, [Intellij Idea](https://www.jetbrains.com/idea/download/?gclid=EAIaIQobChMI4avr5pOv4AIVFc-yCh0ypg_jEAAYASABEgIWBvD_BwE&gclsrc=aw.ds#section=windows) 
- Config Kotlin on IDE


# Created 'kotlin' project 
[SPRING INITIALIZR bootstrap your application now](https://start.spring.io/)
- Group: no.agitec.fagaften.2019.januar
- Artifact: kotlin
- Name: kotlin
- Description: Kotlin for Java Developers 
- Packaging: Jar
- Java version: 11
