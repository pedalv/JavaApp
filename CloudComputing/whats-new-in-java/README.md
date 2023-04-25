## What's new in Java
- Java long term: Java 8, Java 11 and Java 17 === every three years
Top five of new features since Java 9: 
- the `var` keyword (Java 10), 
- the HttpClient API (made official in Java 11), 
- the new ZGC garbage collector (still experimental, but approaching GA state in Java 14 and later), 
- Switch expressions (Java 14), and 
- the Records preview feature in Java 14.

### Java SE 26 Long-term Support (2030-2033)
- It's coming

### Java SE 23 Long-term Support (2027-2030), [JDK 20](https://openjdk.org/projects/jdk/20/)
- It's coming

### Java SE 21, [JDK 21](https://openjdk.org/projects/jdk/21/)
- It's coming

### Java SE 20 Long-term Support (2024-2027), [JDK 20](https://openjdk.org/projects/jdk/20/)
- It's coming

### Java SE 18 & 19, [New APIs in Java 19](https://javaalmanac.io/jdk/19/apidiff/17/), [JDK 18](https://openjdk.org/projects/jdk/18/) and , [JDK 19](https://openjdk.org/projects/jdk/19/)
- API improvements
  - CharSet
  - Duration
  - HttpClient
  - Future
  - Pattern Matching for Switch (preview feature)
    - [JEP 305: Pattern Matching for instanceof (Preview)](https://openjdk.org/jeps/305) 
  - Record Patterns (preview feature)
  - Vector API
  - Foreign Function & Memory API 
  - Virtual Threads (preview feature)
  - Structured Concurrency
- Simple web server
- Platform changes
  - [JEP 418: Internet-Address Resolution SPI (DNS Server Provider Interface)](https://openjdk.org/jeps/418)
  - [JEP 416: Reimplement Core Reflection with Method Handles](https://openjdk.org/jeps/416)
  - [JEP 400: UTF-8 by Default](https://openjdk.org/jeps/400)


### Java SE 17 Long-term Support (2021-2024), [JDK 17](https://openjdk.org/projects/jdk/17/)
- Java Developmnet Kit (JDK), Readability, Stability
  ```
   javac Hello.java -> Hello.class
   java Hello -> "blabla"
  
   java Hello.java //--source <version>
  ```
1. Java programming language
2. Runtime environment
3. Standard library

### Java SE 16, [JDK 16](https://openjdk.org/projects/jdk/16/)
- [Java](https://github.com/topics/java)
- [openJDK](https://github.com/openjdk)
- Stream API improvements
  ```
   Old: .collect(Collectors.toList());
   New: .toList() // Unmodifiable list
  
   <R> Stream<R> mapMulti(BiConsumer<? super T, ? super Consumer<R>> mapper)
   Old:
   List<Integer> evenNumbers = Stream.of(1, 2, 3, 4)
    .flatMap(number -> {
      if(number % 2 == 0)[
        return Stream.of(number, number);
      } else {
        return Strema .of();
      }
     })
     .toList();
  
    new:
    List<Integer> evenNumbers = Stream.of(1, 2, 3, 4)
    .<Integer>mapMulti((number, downstream) -> {
      if(number % 2 == 0)[
        downstream.accept(number);
        downstream.accept(number);
     })
     .toList();
  ```
- DateTimeFormatterBuilder
  ```
   var formatter = new DateTimeFOrmatterBuilder()-appendDayPeriodText(TextStyle.FULL).toFormatter();
   var output = formatter.format(LocalDateTime.of(2021, 6,1, 19,30)); // in the evening
  ```
- Records and Pattern matching
  - [JEP 384: Records (Second Preview)](https://openjdk.org/jeps/384) 
  - [JEP 305: Pattern Matching for instanceof (Preview)](https://openjdk.org/jeps/305)
  - Implicity final
  - Implicitly extends java.land.Record === can not extends from other class
  - can only implements several interfaces
  - Cannot have native methods
    - Native methods can access system-specific functions and APIs that are not available directly in Java 
  - Serializable by default
  - Annotations on Components
    - Annotation can be propagated to: Field, Accessor method and Constructor parameter
    - Annotations's target: Field, Method, Parameter, Type
  - Records and Reflection
   - isRecord() -> true|false
   - getRecordComponents() -> RecordComponent[], returns components in definition order for further reflection
 - Where Would you Use Records?
   - Data Transfer Objects (**not JPA entities!**)
     - In popular JPA providers like Hibernate, entities are created and managed using proxies. 
     - Proxies are classes that are generated at runtime and extend the entity class. 
     - **These proxies rely on the entity class to have a no-args constructor and setters.** 
     - **Since records don't have these, they can't be used as entities**
     - Records do not work with immutable objects
     - [Can I use Java 16 record with JPA entity?](https://stackoverflow.com/questions/70601508/can-i-use-java-16-record-with-jpa-entity)
     - [JEP 395: Records](https://openjdk.org/jeps/395)
     - [Jakarta Persistence](https://en.wikipedia.org/wiki/Jakarta_Persistence)
     - [Hibernate (framework)](https://en.wikipedia.org/wiki/Hibernate_(framework))
   - Jackson 2.12+ support
   - Compound map keys
   - Multiple return values
- Java packaging Tool
- JVM Improvements
- ZGC
  - [JEP 376: ZGC: Concurrent Thread-Stack Processing](https://openjdk.org/jeps/376) 
- Strong Encapsulation of JDK Internals
  - Encapsulating internal types: sun.security.x509.X500Name
  - Block deep reflection on public types
    ```
    var dc = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
    dc.setAccessible(true); 
    
    Exception for sun.misc.Unsafe
    ``` 
  - Security
    ```
    var ks = java.security.KeyStore.getInstance("jceks"); 
    var f = ks.getClass().getDeclaredField("keyStoreSpi");
    f.setAccessible(true);
    ```
  - Maintainability:  Allow evolution of JDK implementation  
  - [JEP 396: Strongly Encapsulate JDK Internals by Default](https://openjdk.org/jeps/396)
  - Run your applications with --illegal-access=permit, Java 9-15, runs
  - Run your applications with **--illegal-access=deny**, Java 16, not runs => java.lang.IllegalAccessError
  - Upgrade libraries, fix code where required
  - Use jdeps -jdkinternals to find problematic code
  - As a last resort: use --add-exports and --add-opens JVM flags

### Java SE 15, [JDK 15](https://openjdk.org/projects/jdk/15/)
- Helpful NullPointerExceptions
  ```
  -XX:+ShowCodeDetailsInExceptionMessages //activate
  -XX:-ShowCodeDetailsInExceptionMessages //deactivate
  
  //-g                           to show local names variables
  //-g                           Generate all debugging info
  //-g:{lines,vars,source}       Generate only some debugging info
  //-g:none                      Generate no debugging info
  javac -g HelpfulNPEDEMO.java && java HelpfulNPEDEMO
  java -XX:+ShowCodeDetailsInExceptionMessages HelpfulNPEDEMO 
  ```  
- Sealed Classes
  - [JEP 360: Sealed Classes (Preview)](https://openjdk.org/jeps/360) 
- Vector API (incubating)
- Foreign Linker & Foreign Memory Access Api 8incubating)
- Text blocks
  - [JEP 368: Text Blocks (Second Preview)](https://openjdk.org/jeps/368)  
  - [Programmer's Guide To Text Blocks](bit.ly/textblocks-guide) 
  - [Programmer's Guide To Text Blocks](https://docs.oracle.com/en/java/javase/20/text-blocks/index.html)
  - [JEP 305: Pattern Matching for instanceof (Preview)](https://openjdk.org/jeps/305)
  ```
  String json = """ 
  { 
     "key1" : "value1", 
     "key2": "value2"
  } """;
  ```
- RMI Deprecations
  - java.rmi.action
  - Depreceted tool: rmid
  - Removed tool: rmic
- Removed Nashorn JavaScript engine
  - [JEP 372: Remove the Nashorn JavaScript Engine](https://openjdk.org/jeps/372) 
  - Removed tool: jjs
  - Alternative: GraalVM 
    - [Nashorn removal: GraalVM to the rescue!](https://medium.com/graalvm/nashorn-removal-graalvm-to-the-rescue-d4da3605b6cb)
- ZGC
  - [Understanding the JDK’s New Superfast Garbage Collectors](bit.ly/zgc-benchmark)
    - -XX:+UseZGC 
  - Pause times under 10ms
  - Scale to multi-terabyte heaps
  - Great performance without tuning
- Garbage Collection: Shenandoah
  - Developed by Red Hat, contributed to OpenJDK
  - Backported to java 8 & Java 11
  - -XX:+UseShenandoahGC, error occurred during initialization of VM option -XX:+UseShenandoahGC not supported 
- Other JVM improvements
  - [JEP 371: Hidden Classes](https://openjdk.org/jeps/371)
  - [JEP 339: Edwards-Curve Digital Signature Algorithm (EdDSA)](JEP 339: Edwards-Curve Digital Signature Algorithm (EdDSA))
  - [JEP 373: Reimplement the Legacy DatagramSocket API](https://openjdk.org/jeps/373)

### Java SE 14, [JDK 14](https://openjdk.org/projects/jdk/14/)
- --enable-preview --release 14
- the new ZGC garbage collector (still experimental, but approaching GA state in Java 14 and later),
  - [Understanding the JDK’s New Superfast Garbage Collectors](bit.ly/zgc-benchmark)
    - -XX:+UseZGC
- garbage Collection changes: G1, -XX:+UseNUMA
- garbage Collection changes: CMS removed, -XX:+UseConcMarkSweepGC -> OpenJDK 64-Bit Server VM warning: Ignoring option UseConcMarkSweepGC; support was removed in 14.0
- Switch expressions (Java 14), and
- Text Blocks
- The jpackege Tool
  - [JEP 343: Packaging Tool (Incubator)](https://openjdk.org/jeps/343) 
  - **Windows**: **.EXE** & **.MSI**
  - Requires Wix Toolset 3.0 or later
  - **MacOS**: **.DMG** & **.PKG**
  - Requires Xcode tools (when signing)
  - **Linux**: **.RPM** & **.DEB**
  - Depending on distro: requires rpm-build or fakeroot

  ``` 
  mvn package -> target directory
  install package on MacOS
  go application and run jpackage-sample.app with double click 
  ```
  - Packaging Process  jpackage --input target --main-jar jpackege-sample-1.0.0.jar --name jpackage-sample --type pkg -> jpackage-sample-1.0.pkg

    - 1. Create runtime image : jlink  
      - jpackege ... -jlink-options ... 
    - 2. Create native package
      - jpackhe ... --runtime-image image-dir
   
    - Additional Configuration
    ```
    jpackage --input target/ \
    --main-jar jpackage-sample-1.0.0.jar \
    --type dmg \
    --name "JPackage Sample" \
    --app-version 1.0 \
    --description "Demo of JPackage tool" \
    --vendor "Sander Mak Inc." \
    --copyright "(C) 2021"
    ```
  
    ```
    --arguments "first second" or --arguments first --arguments second 
    
    --java-options "-Xms1g -Xmx4g"
    
    --linux-shortcut
    --linux-menu-group Samples
    
    --windows-shortcut
    --win-menu-group Samples
    --win-menu
    
    --win-dir-chooser
    ```
  - [JEP 392: Packaging Tool](https://openjdk.org/jeps/392)
  - [Packaging Tool User's Guide](https://docs.oracle.com/en/java/javase/20/jpackage/)
- the Records preview feature in Java 14.
  - [JEP 384: Records (Second Preview)](https://openjdk.org/jeps/384) 
- Api Updates Deprecated/Removed
  - java.security.acl
  - java.util.jar
    - Pack200.{Packer, Unpacker} 
  - Thread::suspend
  - Thread::resume
- Api Updates Updates
  - PrintStream
    ```
    old: write(byte[] buf, int off, int len)
    add: 
    - write(byte[] buf) throws IOExcpetion
    - writeBytes(byte[] buf)
    ```
  - @java.io.Serial
  ```
  private static final long serialVersionUID = 1L;
  -Xlint:serial
  ```
- Other improvements
  - [JEP 352: Non-Volatile Mapped Byte Buffers](https://openjdk.org/jeps/352) 
  - [JEP 370: Foreign-Memory Access API (Incubator)](https://openjdk.org/jeps/370)
  - [JEP 349: JFR Event Streaming](https://openjdk.org/jeps/349)

### Java SE 13, [JDK 13](https://openjdk.org/projects/jdk/13/)
- API Updates
  - Direct & indirect ByteBuffers
    - ByteBuffer != byte[]
    ```
     new byte[] { 0x1, 0x3, 0xf }    
    ```
    - new
    ```
     ByteBuffer get(int index, byte[] dst);
     ByteBuffer get(int index, byte[] dst, int offset, int length); 
     
     ByteBuffer put(int index, byte[] src);
     ByteBuffer put(int index, byte[] src, int offset, int length);
    ```
- Unicode    
- Unicode 12.1 Support
  - 4 new scripts
  - 555 new characters
  - 61 new emoji characters
- CLDR 35.1: Japanese new era, Reiwa
- API Removal    
  - javax.security.cert
    ```
    old
    - javax.security.cert.Certificate
    - javax.security.cert.X509Certificate
    new
    - java.security.cert.Certificate
    - java.security.cert.X509Certificate
    ```
- ZGC: Uncommit Unused Memory
  ```
  -XX:ZUncommitDelay=<seconds>
  ```
- String API Changes
  ```
  //@Depreceted //remove later
  html.stripIndent()
  
  \"Hello\tWorld\"\n //input.txt
  String text = Files.readString(Path.of("input.txt"));
  System.out.println(text); //\"Hello\tWorld\"\n
  
  //@Depreceted //remove later
  //translateEscapes()
  System.out.println(text.translateEscapes());
  
  //@Depreceted //remove later
  //.formatted(str)
  System.out.println("""
               <html>
                <head><head>
                <body>%s</body>
               </html>
               """.formatted("Hello"));
  ``` 
- Platform changes
  - Reimplementation of Socket API
    - java.net.Socket
    - java.net.ServerSocket
    - sun.nio.ch.NioSocketImpl
      - Reuses NIO native code 
      - Build using java.concurrent.lock constructs
      - old implementation: ``` -Djdk.net.usePlainSocketImp ``` 
    - More maintainable  modern implementation
    - Not using stack as I/O buffer
    - Ready for new Java concurrency models (project Loom)
  - Dynamic AppCDS Archives
    - Class Data Sharing
    - start many JVM instance 1
    - ``` java -Xshare:dump ``` JVM instance 1 -> classes.jsa -> JVM instance 2
    - AppCDS: 
      - ``` -XX:DumpLoadedClassList=myapp.lst ```
      - ``` java -XX:ArchiveClassesAtexit=hello.jsa -cp hello.jar Hello ```
      - ``` java -XX:SharedArchiveFile=hello.jsa -cp hello.jar Hello ```
      - Also supports classes in custom class loaders
    - Deprecated flags:
      - ``` -Xverify:none ```
      - ``` -noverify ```

### Java SE 12, [JDK 12](https://openjdk.org/projects/jdk/12/)
- String::indent
- String::transform
- Switch statements vs expressions
- Files.mismatch(...)
- NumberFormat.getCompactNumberInstance()
- Collectors.teeing(...)
- Micro-benchmarking
  - Measure execution time
  - Small pieces of code
  - Compare alternatives
  - Prevent performance regressions
- JVM Constants API  
  - java.lang.constant 

### Java SE 11 Long-term Support (2018-2021), [JDK 11](https://openjdk.org/projects/jdk/11/)
- Java module system fundamentals,
- Modular JDK,
- Services,
- Migrating to modules, 
  - JavaFX moved out of JDK
- Removed
  - Enterprise APIs
  - Applets, Web Start
- the HttpClient API (made official in Java 11).
  - Replacement for java.net.HttpURLConnection
  - Supports HTTP/2, WebSocket
  - Reactive Streams integrations
  - Goal: easy to use in common cases, powerful enough for complex ones
- [Running Java Flight Recorder](https://docs.oracle.com/javacomponents/jmc-5-4/jfr-runtime-guide/run.htm#JFRUH164)
  - ``` java -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:StartFlightRecording=duration=60s,filename=myrecording.jfr MyApp ```
- Unicode 10
  - Upgrade from Unicode 8 in Java 10
  - Adds 16,000+ new Characters as bitcoin \u20BF

### Java SE 10, [JDK 10](https://openjdk.org/projects/jdk/10/)
- the `var` keyword (Java 10).

### Java SE 9, [JDK 9](https://openjdk.org/projects/jdk/9/)
- Module system
- Caching
- jshell

### Java SE 8 Long-term Support, [JDK 8](https://openjdk.org/projects/jdk/8/)
- Lambda
- Streams