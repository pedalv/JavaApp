## What's new in Java
- Java long term support: Java 8 (2015-2018), Java 11 (2018-2021), Java 17 (2021-2024), Java 23 (2024-2027) === every three years

Top five of new features since Java 9: 
- the `var` keyword (Java 10), 
- the HttpClient API (made official in Java 11), 
- the new ZGC garbage collector (still experimental, but approaching GA state in Java 14 and later), 
- Switch expressions (Java 14), and 
- the Records preview feature in Java 14.

### [Java Platform, Standard Edition Documentation](https://docs.oracle.com/en/java/javase/index.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 20 API Specification](https://docs.oracle.com/javase/20/docs/api/overview-summary.html)
  - [JDK 20 Documentation](https://docs.oracle.com/en/java/javase/20/) 
- [Java® Platform, Standard Edition & Java Development Kit Version 19 API Specification](https://docs.oracle.com/javase/19/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 18 API Specification](https://docs.oracle.com/javase/18/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 17 API Specification](https://docs.oracle.com/javase/17/docs/api/overview-summary.html)
  - [JDK 17 Documentation](https://docs.oracle.com/en/java/javase/17/) 
- [Java® Platform, Standard Edition & Java Development Kit Version 16 API Specification](https://docs.oracle.com/en/java/javase/16/docs/api/index.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 15 API Specification](https://docs.oracle.com/javase/16/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 14 API Specification](https://docs.oracle.com/javase/15/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 13 API Specification](https://docs.oracle.com/javase/14/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 12 API Specification](https://docs.oracle.com/javase/13/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 11 API Specification](https://docs.oracle.com/javase/12/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 10 API Specification](https://docs.oracle.com/javase/11/docs/api/overview-summary.html)
- [Java® Platform, Standard Edition & Java Development Kit Version 9 API Specification](https://docs.oracle.com/javase/9/docs/api/overview-summary.html)
  - [Overview of What’s New in JDK 9](https://docs.oracle.com/javase/9/whatsnew/toc.htm) 
  - [Java 9 Modularity](https://javamodularity.com/)
    - [Java 9 Modularity link2](https://bit.ly/java9book)
    - [Java 9 Modularity link2](http://branchandbound.net/blog/java/2016/08/java9-modularity-oreilly-early-access-release/)
  - [Java 9 Modularity: First look](bit.ly/java9course)
- [Java™ Platform, Standard Edition 8 API Specification](https://docs.oracle.com/javase/8/docs/api/overview-summary.html)

### Platforms
- Azul, IBM, AdoptOpenJDK,...
- **[temurin](https://adoptium.net/)**,
  - [Eclipse Temurin™ Latest Releases](https://adoptium.net/temurin/releases/?version=17)
- GitHub Action: [Setup Java JDK](https://github.com/marketplace/actions/setup-java-jdk)
- [Foojay Today](https://foojay.io/)
  - [Download OpenJDK](https://foojay.io/download/)
  - [OpenJDK Update & Release Details](https://foojay.io/java-20/?version=20.0.1&quarter=042023&tab=component)
- Root Certificates
  - cacerts
  - Oracle's Root CA program, to be ported to OpenJDK
  - CA,Certification Authorities
  - [JEP 319: Root Certificates](https://openjdk.org/jeps/319)

### Tips
- [Reactive Streams](http://www.reactive-streams.org/)
- [Concatenating Strings In Java](https://www.baeldung.com/java-strings-concatenation)
- [Java String Concatenation: Best Practices and Performance Optimization](https://copyprogramming.com/howto/java-string-concatenation-best-practices-and-performance-optimization)

### Java SE 29 Long-term Support (2027-2030)
- It's coming

### Java SE 23 Long-term Support (2024-2027), [JDK 23 - NOT AVAILABLE](https://openjdk.org/projects/jdk/23/)
- It's coming

### Java SE 22, [JDK 22 - NOT AVAILABLE](https://openjdk.org/projects/jdk/22/)
- It's coming

### Java SE 21, [JDK 21](https://openjdk.org/projects/jdk/21/), [New APIs in Java 21](https://javaalmanac.io/jdk/21/apidiff/17/)
- --enable-preview --release 21
- Early access: JDK 21, Generational ZGC, JavaFX 21, Jextract, Loom, Metropolis, Panama, & Valhalla

### Java SE 20, [JDK 20](https://openjdk.org/projects/jdk/20/), [New APIs in Java 20](https://javaalmanac.io/jdk/20/apidiff/17/)
- --enable-preview --release 20
- Ready for use: JDK 20, JDK 19, JavaFX 20, JMC 8

### Java SE 18 & 19, [New APIs in Java 19](https://javaalmanac.io/jdk/19/apidiff/17/), [JDK 18](https://openjdk.org/projects/jdk/18/) and , [JDK 19](https://openjdk.org/projects/jdk/19/)
- --enable-preview --release 18|19 
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
- --enable-preview --release 17
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
- --enable-preview --release 16
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
- --enable-preview --release 15
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
- --enable-preview --release 13
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
- --enable-preview --release 12
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
- --enable-preview --release 11
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
- [JEP 309: Dynamic Class-File Constants](https://openjdk.org/jeps/309) 
- Garbage Collection: 
  - G1, 
  - Epsilon: Apps with predictable, bounded memory usage
    - -XX:+UnlockExxperimentalVMOptions
    - -XX:+UseEpsilonGC
  - Z: pause times under 10ms
    - Linux/x64 only
      - -XX:+UnlockExxperimentalVMOptions
      - -XX:+UseZGC
- Security
  - HTTPS: [JEP 332: Transport Layer Security (TLS) 1.3](https://openjdk.org/jeps/332)

### Java SE 10, [JDK 10](https://openjdk.org/projects/jdk/10/)
- --enable-preview --release 10
- the `var` keyword (Java 10), local-variable Type Inference
- Java Flight Recorder
- Java Mission Control
- Z Garbage Collector
- G1 Garbage Collector
- -XX:ParallelGCThreads
  - Java 9: serial full GC
  - Java 10: parallel full GC
- Application Class Data Sharing 
  - [cl4cds](https://github.com/simonis/cl4cds)
- Improved Container Awareness
  - Linux & Docker only
  - -XX:ActiveProcessorCount=<n>
  - -XX:InitialRAMPercentage
  - -XX:MaxRAMPercentage
  - -XX:MinRAMPercentage

### Java SE 9, [JDK 9](https://openjdk.org/projects/jdk/9/), [Project Jigsaw](https://openjdk.org/projects/jigsaw/)
- --enable-preview --release 9
- Module system
  - [JEP 261: Module System](https://openjdk.org/jeps/261#Relaxed-strong-encapsulation)
    - [JEP 376: ZGC: Concurrent Thread-Stack Processing](https://openjdk.org/jeps/376)
    - [JEP 200: The Modular JDK](https://openjdk.org/jeps/200)
    - [JEP 282: jlink: The Java Linker](https://openjdk.org/jeps/282)
    - [JEP 220: Modular Run-Time Images](https://openjdk.org/jeps/220)
    - [JEP 260: Encapsulate Most Internal APIs](https://openjdk.org/jeps/260)
  - [JEP 396: Strongly Encapsulate JDK Internals by Default](https://openjdk.org/jeps/396)
  - [Java 17 cannot access class sun.security.pkcs.PKCS7](https://intellij-support.jetbrains.com/hc/en-us/community/posts/5153987456018-Java-17-cannot-access-class-sun-security-pkcs-PKCS7)
  - [Access `sun.security.x509` in JDK 11 without modules?](https://stackoverflow.com/questions/61149455/access-sun-security-x509-in-jdk-11-without-modules)
  - [Interface ModuleFinder](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/module/ModuleFinder.html)
  - --illegal-access=deny Main
  - Exploring the Modular JDK
    - java --list-modules
    - java --describe-module java.sql
    - java.* vs jdk.*

  - > The Modular JDK: Explicit Dependencies, 71 Platform Modules in Java JDK 11
    - ..\..\..\..\Java\jdk-20.0.1\bin\java --list-modules   
    ```
      java.base@20.0.1
      java.compiler@20.0.1
      java.datatransfer@20.0.1
      java.desktop@20.0.1
      java.instrument@20.0.1
      java.logging@20.0.1
      java.management@20.0.1
      java.management.rmi@20.0.1
      java.naming@20.0.1
      java.net.http@20.0.1
      java.prefs@20.0.1
      java.rmi@20.0.1
      java.scripting@20.0.1
      java.se@20.0.1
      java.security.jgss@20.0.1
      java.security.sasl@20.0.1
      java.smartcardio@20.0.1
      java.sql@20.0.1
      java.sql.rowset@20.0.1
      java.transaction.xa@20.0.1
      java.xml@20.0.1
      java.xml.crypto@20.0.1
      jdk.accessibility@20.0.1
      jdk.attach@20.0.1
      jdk.charsets@20.0.1
      jdk.compiler@20.0.1
      jdk.crypto.cryptoki@20.0.1
      jdk.crypto.ec@20.0.1
      jdk.crypto.mscapi@20.0.1
      jdk.dynalink@20.0.1
      jdk.editpad@20.0.1
      jdk.hotspot.agent@20.0.1
      jdk.httpserver@20.0.1
      jdk.incubator.concurrent@20.0.1
      jdk.incubator.vector@20.0.1
      jdk.internal.ed@20.0.1
      jdk.internal.jvmstat@20.0.1
      jdk.internal.le@20.0.1
      jdk.internal.opt@20.0.1
      jdk.internal.vm.ci@20.0.1
      jdk.internal.vm.compiler@20.0.1
      jdk.internal.vm.compiler.management@20.0.1
      jdk.jartool@20.0.1
      jdk.javadoc@20.0.1
      jdk.jcmd@20.0.1
      jdk.jconsole@20.0.1
      jdk.jdeps@20.0.1
      jdk.jdi@20.0.1
      jdk.jdwp.agent@20.0.1
      jdk.jfr@20.0.1
      jdk.jlink@20.0.1
      jdk.jpackage@20.0.1
      jdk.jshell@20.0.1
      jdk.jsobject@20.0.1
      jdk.jstatd@20.0.1
      jdk.localedata@20.0.1
      jdk.management@20.0.1
      jdk.management.agent@20.0.1
      jdk.management.jfr@20.0.1
      jdk.naming.dns@20.0.1
      jdk.naming.rmi@20.0.1
      jdk.net@20.0.1
      jdk.nio.mapmode@20.0.1
      jdk.random@20.0.1
      jdk.sctp@20.0.1
      jdk.security.auth@20.0.1
      jdk.security.jgss@20.0.1
      jdk.unsupported@20.0.1
      jdk.unsupported.desktop@20.0.1
      jdk.xml.dom@20.0.1
      jdk.zipfs@20.0.1
    ```
    - ..\..\..\..\Java\jdk-20.0.1\bin\java --list-modules | grep "java\."
    - ..\..\..\..\Java\jdk-20.0.1\bin\java --describe-module java.sql
  - Increased security
  - Easy deprecation
  - Future-proof 
  - **A module has a name, it groups related code and is self-contained**
    ```
    [open] module <module_name> {
      exports <package>;
      opens <package>;
      requires <module_name>;
    
      uses <package>.<type_name>;
    
      provides <package>.<type_name> with <package>.<type_name>;    
    }
    
    module java.base {
      exports java.lang;
      exports java.util;
      exports java.io;
      // and more 
    
    }
    
    module util {
      exports no.dfo.util to mymodule;
      opens no.dfo.util to mymodule, anothermodule;
    }
    
    other solution is using TRANSITIVE
    
    ..\..\..\..\Java\jdk-17.0.6+10\bin\java --describe-module java.sql
    Windows PowerShell
    java.sql@17.0.6
    exports java.sql
    exports javax.sql
    requires java.transaction.xa transitive
    requires java.xml transitive
    requires java.logging transitive
    requires java.base mandated
    uses java.sql.Driver
    ```
  - JAR Files and the Java Classpath
    - A JAR file is not a module:
    - it has a name, which disappears at run-time
    - it groups code, but without access control
    - it does not describe its dependencies
  - Why modules?
    - Understandability: explicit boundaries and dependencies
    - Maintainability: hiding implementation details
    - Flexibility: decoupling of parts of your system
  - Three Tenets of Modularity
    - Strong encapsulation, hide your internals, be strict about what is public API
    - Well-defined interfaces, when modules interact, use stable and well-defined interfaces
    - Explicit module dependencies, expressed in Module Descriptors, a module lists what it needs from other modules
    - Services build/implemented above module system
    - Reduced footprint 
  - Java Platform Module System
    - Migratin Classpsth Based Applications
    - Encapsulated Types
    - Non-Default Modules
    - [Java 9 Modularity](https://javamodularity.com/)
    - Can access all public types from exported packages because public no longer means public
      1. Do you read the module?
      2. Is the package exported?
      3. Is the type public?
      Note: 
      - Readability is not transitive, does not read === error: warning() in Logger is defined in an inaccessible class or interface for example
      - Solution: requires transitive
      - ![Implied Readability](https://github.com/pedalv/JavaApp/blob/master/CloudComputing/whats-new-in-java/modulo-implied-readability.JPG)
      - ![Implied Readability](https://github.com/pedalv/JavaApp/blob/master/CloudComputing/whats-new-in-java/modulo-aggregator-modules.JPG)
  - Platform Modules
    1. Core Java SE: java.base, java.sql, java.desktop, java.se
    2. JavaFX: javafx.base, javafx.web, javafx.xontrols,
    3. Enterprise (Java Enterprise Edition, JEE): java.corba, java.xml.ws, java.transaction
    4. JDK: jdk.compiler, jdk.httpserver, jdk.jartool
- Caching
- jshell: 
  - Read, type code 
  - Eval, execute code
  - Print, see results
  - Loop, interactively refine
  ```
  PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java> jshell
  |  Welcome to JShell -- Version 11.0.10
  |  For an introduction type: /help intro
  
  /exit or ctrl c
  
  ctrl l : clean screen
  
  ctrl c : interrupt run process
  
  tab : override functions => Thread.sleep( tab
  tab tab : documentation
  
  "ab c".matches("[ab]+b\\sc")
  
  
  /help
  /set feeback verbose
  
  int x = 1
  x = 2
  /vars
  
  Module witchModule(Class clazz) {
   return clazz.getModule();
  }
  witchModule(String.class); //module java.base
  witchModule(java.util.logging.LogManager.class); //module java.logging

  /imports
  import java.util.logging.LogManager
  witchModule(LogManager.class); //module java.logging
  
  /methods
  
  int timeTwo(int i) {
    return i * x;
  }
  timesTwo(2); // x=2 from last change
  
  class Person {
    private String name;
    public Person(String name) {
      this.name = name;
    }
    public String toString() {
      return "[Person: " + name + "]";
    }
  }
  new Person("Pedro")
  
  /types
  
  /save mysession.jsh
  /open mysession.jsh
  
  /open Person.java
  
  jshell --class-path commans-lang3-3-5.jar
  import org.apache.commons.lang3.StringUtils
  StringUtils.leftPad("Indispensible!", 20);
  ```
-  ..\..\..\..\Java\jdk-11.0.14+9\jmods\
- jlink  
  - ..\..\..\..\Java\jdk-11.0.14+9\bin\jlink --version
  - Jlink is a Java command line tool that is used to generate a custom Java runtime environment (JRE). 
  - You can use your customized JRE to run Java applications. 
  - Using jlink, you can create a custom runtime environment that only includes the relevant class file.
  - ..\..\..\..\Java\jdk-11.0.14+9\bin\jlink -h
  - create jar file
  ```
   rm -fr jars && mkfir -p jars 
   jar --create --file jars/easytext.analysis.api.jar -C out/esaytest.analysis.api .
   jar --create --file jars/easytext.jar -C out/production/esaytest .
   jar --create --file jars/easytext.cli.jar --main-class=no.dfo.javamodularity.eadytext.no.dfo.javamodularity.easytext.cli.Main -C out/esaytest.gui .
   rm -rf image && jlink --module-path jars/:$JAVA_HOME/jmods \
                         --add-modules easytext.cli \
                         --strip-debug \
                         --compress=2 \
                         --output image
   image/bin/easytext.cli === to run application from command line
  image/bin/easytext.cli testinput.txt
  ./image/bin/java --list-modules
  rm -rf image && jlink --module-path jars/:$JAVA_HOME/jmods \ 
                        --add-modules easytext.cli \
                        --add-modules easytext.analysis.coleman \
                        --add-modules easytext.analysis.kincaid \
                         --strip-debug \
                         --compress=2 \
                         --output image
    ./image/bin/java --list-modules
    image/bin/easytext.cli testinput.txt === to run application from command line
    rm -rf image && jlink --module-path jars/:$JAVA_HOME/jmods \ 
                        --add-modules easytext.gui \
                        --add-modules easytext.analysis.coleman \
                        --add-modules easytext.analysis.kincaid \
                         --strip-debug \
                         --compress=2 \
                         --output image 
  ```
- Classpath, Modules are optional
  - javac -cp $CLASSPATH ...
  - java -cp $CLASSPATH ...
  - unless...
    1. You use JDK types that have been encapsulated
    2. You use types from non-default Java SE modules
    - Classpath : located on unnamed module for your own application and others in modulo JDK.  
- List of using non-default module
  - java.transaction 
  - java.annotations.common
  - java.xml.bind
  - java.xml.ws
  - java.corba
  - java.activation

### Java SE 8 Long-term Support, [JDK 8](https://openjdk.org/projects/jdk/8/)
- --enable-preview --release 8
- Lambda
- Streams
