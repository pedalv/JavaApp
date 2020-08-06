## [Spring for Apache Kafka](https://spring.io/projects/spring-kafka#overview)

- Step 1: Start the Kafka server: Zookeeper og Kafka

> Zookeeper Server: Port 2181

```
kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties     
```

- Step 2.1: Create topic: java_in_use_topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic java_in_use_topic

PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic java_in_use_topic
WARNING: Due to limitations in metric names, topics with a period ('.') or underscore ('_') could collide. To avoid issues it is best to use either, but not both.
Created topic java_in_use_topic.

//Other way
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic java_in_use_topic
```

- step 2.2: Description (Vis)

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic java_in_use_topic

PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic java_in_use_topic
Topic: java_in_use_topic        PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: java_in_use_topic        Partition: 0    Leader: none    Replicas: 0     Isr:
```

- Step 3: Start the consumer listening to the java_in_use_topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic java_in_use_topic --from-beginning
```

- Step 4:  Start the Spring Boot Application - EksempelAppApplication.java

- Step 5:  

```
curl -X GET http://localhost:8080/javainuse-kafka/producer?message=test
```