# JAVA
- [Spring Integration](https://app.pluralsight.com/paths/skill/spring-framework-spring-integration)
- [Java Streams](https://app.pluralsight.com/search/?q=java%20streams&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&query_id=286eab71-6ca8-46f3-a644-f473cd011187&is_auto_suggested=true&source=autocomplete)
- [java rest api](https://app.pluralsight.com/search/?q=java%20rest%20api&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&query_id=6f2677a0-d4e9-4e49-ba62-d2d8fcdde1a8&source=user_typed)
- [spring boot microservices](https://app.pluralsight.com/search/?q=spring%20boot%20microservices&type=conference%2Cvideo-course%2Cdemo%2Cguide%2Cwebinar%2Cpath%2Cassessment&m_sort=relevance&query_id=1d3e26e5-c40f-481b-8024-dad768cd4bb0&source=user_typed)
- [Java EE: Working with JSON Using JSON-B and JSON-P](https://app.pluralsight.com/library/courses/java-ee-json-using-jsonp-jsonb/exercise-files)
- [JDK 11 Releases](http://jdk.java.net/11/)
- [javadoc.io](https://javadoc.io/)


## [Jave EE: Working with JSON Using JSON-B and JSON-P](https://app.pluralsight.com/library/courses/java-ee-json-using-jsonp-jsonb/table-of-contents)
* [JSON](https://www.json.org/json-en.html) - The basic for webservices
    - [RFC 8259 by IETF](https://tools.ietf.org/html/rfc8259)
    - [ECMA standard 404](https://www.ecma-international.org/publications-and-standards/standards/ecma-404/)
* Alternative libraries
    - FasterXML Jackson
    - Google GSON
* Java EE - JSON Binding (JSON-B)
    - Convert Java Objects to and from JSON
    - Higher-level
    - Similar to JAXB
    - [JSR 367](https://jcp.org/en/jsr/detail?id=367)
    - Java EE === OLD
    ```
    <dependency>
        <groupId>javax.json.bind</groupId>
        <artifactId>javax.json.bind-api</artifactId>
        <version>1.0</version>
    </dependency>
    ```
    - Jakarta EE === NEW
      ```
      <dependency>
            <groupId>jakarta.json.bind</groupId>
            <artifactId>jakarta.json.bind-api</artifactId>
            <version>2.0.0</version>
      </dependency>
      ```
      - JSON (Number, String, Boolean, null, Object, Array) <=> Java (byte, short, int, long, floast,  double, char, boolean, Interfaces, classes, enum)
* JAVA EE - JSON Processing (JSON-P)
    - Lower-level
    - Streaming API
        * JSON as a stream of events / StAX
    - Object model API
        * JSON as a tree of objects /DOM
    - [JSR 374](https://www.jcp.org/en/jsr/detail?id=374)
* JSON-B Annotations
    - @JsonbPropertyOrder
    -  @JsonbTransient
        * get : WriteJson, Java Value -> jsonb.toJson() === Serializer -> JSON Value 
        * set : ReadJson, JSON Value -> jsonb.fromJson() === Deserializer -> Java Value
    - @JsonbNumberFormat(value = "0.00", locale = "fr-FR")
    - @JsonbDateFormat("MM/dd/yyyy")
    - @JsonbProperty(value = "order-comment", nillable = true)
    - @JsonbCreator
    - @JsonbNillable
    - @JsonbVisibility(HideCommentsVisibilityStrategy.class)
    - @JsonbTypeSerializer(ItemMapSerializer.class)
    - @JsonbTypeDeserializer(ItemMapDeserializer.class)

## [Spring WebFlux: Getting Started](https://app.pluralsight.com/library/courses/getting-started-spring-webflux/table-of-contents)
- [reactor-core 3.4.5](https://projectreactor.io/docs/core/release/api/)
- [Non Blocking Reactive Foundation For The JVM](https://mvnrepository.com/artifact/io.projectreactor/reactor-core)
- [Reactive Streams](https://github.com/reactive-streams/reactive-streams-jvm)
- [Reactor 3 Reference Guide](https://projectreactor.io/docs/core/snapshot/reference/)  
- [Appendix A: Which operator do I need?](https://projectreactor.io/docs/core/3.4.5/reference/index.html#which-operator)
- [Appendix C: FAQ, Best Practices, and "How do I…?"](https://projectreactor.io/docs/core/3.4.5/reference/index.html#faq)
- [Lite Rx API Hands-on](https://github.com/reactor/lite-rx-api-hands-on)  
- [1.4. Annotated Controllers](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-controller)
- [Spring Boot: ApplicationRunner and CommandLineRunner](https://dzone.com/articles/spring-boot-applicationrunner-and-commandlinerunne)
- [Using server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events)
- [MongoDB Repositories](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.repositories)
- PersonHandler
- PersonEndpoints
- PersonWebClient