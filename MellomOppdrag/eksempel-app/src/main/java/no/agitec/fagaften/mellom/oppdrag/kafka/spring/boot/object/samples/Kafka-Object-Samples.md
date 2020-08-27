#### [Spring for Apache Kafka Samples](https://github.com/spring-projects/spring-kafka/tree/master/samples)

## [Spring for Apache Kafka](https://spring.io/projects/spring-kafka#overview)

- Step 1: Start the Kafka server: Zookeeper og Kafka

> Zookeeper Server: Port 2181

```
kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties     

```

- Step 2: Topic created automatic - Description topic (Vis)
```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 (works)

// -----Sample 1
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic1 (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic1.DLT (works)

PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic1
Topic: topic1   PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: topic1   Partition: 0    Leader: 0       Replicas: 0     Isr: 0
        
PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic1.DLT
Topic: topic1.DLT       PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: topic1.DLT       Partition: 0    Leader: 0       Replicas: 0     Isr: 0


// -----Sample 2
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic foos (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic bars (works)

PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic foos
Topic: foos     PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: foos     Partition: 0    Leader: 0       Replicas: 0     Isr: 0

PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic bars
Topic: bars     PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: bars     Partition: 0    Leader: 0       Replicas: 0     Isr: 0

// -----Sample 3
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic2 (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic3 (works)

PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic2
Topic: topic2   PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: topic2   Partition: 0    Leader: 0       Replicas: 0     Isr: 0

PS D:\kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic3
Topic: topic3   PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: topic3   Partition: 0    Leader: 0       Replicas: 0     Isr: 0

```


- Step 3: Start the consumer listening to <topic_name>
```
===   @KafkaListener(id = "fooGroup", topics = "topic1")
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic1 --from-beginning

===   @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic1.DLT --from-beginning

===   @KafkaListener(id = "fooGroup2", topics = "topic2")
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic2 --from-beginning

===   @KafkaListener(id = "fooGroup3", topics = "topic3")
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic3 --from-beginning
```

- Step 3: Process some data

```
// Sample 1

curl -X GET http://localhost:8080/kafka/sample1/send/foo/bar
curl -X GET http://localhost:8080/kafka/sample1/send/foo/fail

// Sample 2

curl -X GET http://localhost:8080/kafka/sample2/send/foo/bar
curl -X GET http://localhost:8080/kafka/sample2/send/bar/baz
curl -X GET http://localhost:8080/kafka/sample2/send/unknown/xxx

// Sample 3
curl -X GET http://localhost:8080/kafka/sample3/send/foos/a,b,c,d,e
```
