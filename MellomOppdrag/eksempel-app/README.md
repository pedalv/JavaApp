## Prosjekt: eksempel-app
Bygg kompetanse for bevis for konsept POC med Spring, Apache Kafka, Java, Kotlin, React, ...

## Start App

```
kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties

eksempel-app> mvn clean install
Run: EksempelAppApplication 
```

##  WebApp - [Spring Boot](https://start.spring.io/)
- Lombok: https://projectlombok.org/features/all 
- Spring Web: Restful, Spring MVC, Apche Tomcat as default embedded container
- Rest Repositories: Fetch data
- Spring HATEOAS: RESTful APIs
- Thymeleaf: Server-side Java template engine 
- Spring Data JPA: Persist data in SQL
- H2 Database: In-memory database
- Spring Boot DevTools: config
- Spring Segurity: Authentication and access-control


#### For å Vise
- pom fil
- MVC Config
- JPA Examples

> Domain: Comment, Store, others

> Load Database Config: OneToOne, OneToMany, ManyToMany

-  Web Security Config

> UserDetailsServiceImp

> CreatePassword

> How Encode password on Server and Client side?


## Kafka
- [KAFKA TEORI](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app/Kafka-teori.md)
- [KAFKA QUICK DEMO](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app/Kafka-demo.md)
- [Word Count Sample Demo](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app/src/main/java/no/agitec/fagaften/mellom/oppdrag/kafka/quickstart/streams/examples/wordcount/Kafka-Streams-WordCountDemo.md)
- [Object Sample Demo](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app/src/main/java/no/agitec/fagaften/mellom/oppdrag/kafka/quickstart/streams/examples/wordcount/Kafka-Spring-SampleDemo.md)
- [String Sample Demo med Spring Apache](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app/src/main/java/no/agitec/fagaften/mellom/oppdrag/kafka/quickstart/streams/examples/wordcount/Kafka-Online-SampleDemo.md)
