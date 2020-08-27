## Mål MellomOppdrag prosjekt
Agitec AS er det sterk fokus på å få alle ut i oppdrag og i mellomtiden jobbes det med faglig utvikling og kompetanseheving.

## Prosjekt: [eksempel-app](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app)
Bygg kompetanse for bevis for konsept POC med Spring, Apache Kafka, Java, Kotlin, React, ...  

## Spring 

#### [Spring Boot](https://spring.io/projects/spring-boot)

- Opprett prosjekt: [spring initializr](https://start.spring.io/)

```
https://start.spring.io/#!type=maven-project
&language=java
&platformVersion=2.3.1.RELEASE
&groupId=no.agitec.fagaften
&artifactId=eksempel-app
&name=eksempel-app
&description=Demo%20project%20for%20Spring%20Boot
&packageName=no.agitec.fagaften.eksempel-app
&packaging=jar
&jvmVersion=14
&dependencies=
Lombok, 
Spring Web, 
Thymeleaf, 
Spring Data JPA,
H2 Database,
Rest Repositories,
Spring Boot DevTools,
Spring HATEOAS,
Spring for Apache Kafka,
Spring for Apache kafka Streams
-
Spring Data Neo4j
MySQL Driver
Spring Data MongoDB
```

> [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)

> [Spring Boot 2.3.0](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes)

> [Spring Boot 2.3.0 available now](https://spring.io/blog/2020/05/15/spring-boot-2-3-0-available-now)

> [Spring Getting Started](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html)


#### [Spring Segurity](https://spring.io/projects/spring-security)

> [Securing a Web Application](https://spring.io/guides/gs/securing-web/)

> [Spring Security Architecture](https://spring.io/guides/topicals/spring-security-architecture/)

> [10. Security](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-security)

> [9.5. Security Filters](https://docs.spring.io/spring-security/site/docs/5.3.5.BUILD-SNAPSHOT/reference/html5/#features)


#### [Spring Data](https://spring.io/projects/spring-data)

> [Accessing Data in Pivotal GemFire](https://spring.io/guides/gs/accessing-data-gemfire/)

> [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

> [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)

> [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql)

> [MySQL Community Downloads](https://dev.mysql.com/downloads/)

#### [Spring Framework](https://spring.io/projects/spring-framework)

> [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)

> [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)

> [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

> [Spring Framework Documentation](https://docs.spring.io/spring/docs/current/spring-framework-reference/)

> REST API build on top of HTTP

- Suitable actions (GET, POST, PUT, DELETE, …​)
- Caching
- Redirection and forwarding -> Support backward compatibility
- Security (encryption and authentication) -> Securable services
- Evolvable APIs
- Scaleable services
- A spectrum of stateless to stateful services -> RESTful

## [Apache Kafka](https://kafka.apache.org/)
- Course
> [Quickstart](https://kafka.apache.org/quickstart)

> Bevis av konsept (poc) prosjekt for [Getting Started with Apache Kafka](https://app.pluralsight.com/library/courses/apache-kafka-getting-started/table-of-contents)

- [KAFKA TEORI](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app/Kafka-teori.md)
- [KAFKA DEMO](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/eksempel-app/Kafka-demo.md)

> [Apache Kafka: Build, Deploy, and Monitor Your First Real-world Application](https://app.pluralsight.com/library/courses/kafka-build-deploy-monitor-real-world-application/table-of-contents)

> [Spring Boot + Apache Kafka Hello World Example](https://www.javainuse.com/spring/spring-boot-apache-kafka-hello-world)

> [javaBin Online  : Apache Kafka and ksqlDB in Action with Robin Moffatt](https://www.meetup.com/javaBin/events/270058786/)
-[confluentinc / demo-scene](https://github.com/confluentinc/demo-scene)


- Tutorial

> [Documentation](http://kafka.apache.org/documentation.html)

> [3.6 Kafka Streams Configs](https://kafka.apache.org/25/documentation/#streamsconfigs) 

> [Topic Configurations](https://docs.confluent.io/current/installation/configuration/topic-configs.html)

> [14. Messaging](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-messaging)

> [Enterprise Plans](https://www.cloudkarafka.com/plans.html)

> [ZooKeeper: Because coordinating distributed systems is a Zoo](https://cwiki.apache.org/confluence/display/ZOOKEEPER/Index)

> [Kafka Clients - Producers | Consumers](https://jaceklaskowski.gitbooks.io/apache-kafka/kafka-clients.html) 

> [Kafka Clients](https://docs.confluent.io/current/clients/index.html)

> [clients 2.6.0 API](https://javadoc.io/doc/org.apache.kafka/kafka-clients/latest/index.html)

> [Testing Kafka Streams](https://kafka.apache.org/22/documentation/streams/developer-guide/testing.html)



- Version

> [STEP 1: GET ZooKeeper and kafka](https://kafka.apache.org/quickstart)

> [DOWNLOAD KAFKA](https://kafka.apache.org/downloads.html) 


How The Kafka Project Handles Clients

> [kafka-clients](https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients)

Producer API and Consumer API and Admin API

```
		<dependency>
			<groupId>org.apache.kafka</groupId>
			<artifactId>kafka-clients</artifactId>
			<version>${kafka.version}</version>
		</dependency>

```

Kakfa Streams is a client library for building applications and microservices, where the input and output data are stored in Kafka clusters 

> [kafka-streams-test-utils](https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams-test-utils) 

Streams API

```
		<dependency>
			<groupId>org.apache.kafka</groupId>
			<artifactId>kafka-streams</artifactId>
			<version>${kafka.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.kafka</groupId>
			<artifactId>kafka-streams-test-utils</artifactId>
			<version>${kafka.version}</version>
			<scope>test</scope>
		</dependency>

```

The Spring for Apache Kafka (spring-kafka) project applies core Spring concepts to the development of Kafka-based messaging solutions.

> [Spring for Apache Kafka](https://spring.io/projects/spring-kafka)

```
   		<dependency>
			<groupId>org.springframework.kafka</groupId>
			<artifactId>spring-kafka</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.kafka</groupId>
			<artifactId>spring-kafka-test</artifactId>
			<scope>test</scope>
		</dependency>
```

> [4.1. Using Spring for Apache Kafka](https://docs.spring.io/spring-kafka/docs/2.5.4.RELEASE/reference/html/#reference)
