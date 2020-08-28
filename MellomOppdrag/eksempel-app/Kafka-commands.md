
- Start Zookeeper Server: Port 2181 - [ZooKeeper Operations](https://docs.confluent.io/current/zookeeper/operations.html) - [ZooKeeper: Because coordinating distributed systems is a Zoo](https://cwiki.apache.org/confluence/display/ZOOKEEPER/Index) - [Monitor and Manage](https://docs.confluent.io/current/control-center/brokers.html)

```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

- Start Kaftka Server - [Broker Configurations](https://docs.confluent.io/current/installation/configuration/broker-configs.html)

> Broker: Port 9092

```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

> Multi-broker: Port 9092|3|4|n - [3.6 Kafka Streams Configs](https://kafka.apache.org/25/documentation/#streamsconfigs)

```
.\bin\windows\kafka-server-start.bat .\config\server-n.properties  => (--replication-factor n)

.\bin\windows\kafka-server-start.bat .\config\server-0.properties  => (--replication-factor 0)
.\bin\windows\kafka-server-start.bat .\config\server-1.properties  => (--replication-factor 1)
.\bin\windows\kafka-server-start.bat .\config\server-2.properties  => (--replication-factor 2)
```

-  Create a Topic - [Topic Configurations](https://docs.confluent.io/current/installation/configuration/topic-configs.html)

```
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my_topic
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my_topic --config cleanup.policy=compact

.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic my_topic
```

Topic: my_topic PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: my_topic Partition: 0    Leader: 0       Replicas: 0     Isr: 0


```
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 1 --topic my-replicated-topic 
```

Topic: my-replicated-topic      PartitionCount: 1       ReplicationFactor: 2    Configs:
        Topic: my-replicated-topic      Partition: 0    Leader: 1       Replicas: 1,0   Isr: 1,0


- Show descriprion of one or all topics created

```
.\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
.\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181

.\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic my_topic
```

- Change an old topic

```
.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --alter --topic my_topic --partitions 4
```

- Producer - [Producer Configurations](https://docs.confluent.io/current/installation/configuration/producer-configs.html): 

> Send some messages

```
.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my_topic 
```

> Start (Pipe - LineSplit - WorldCount) Application

```
.\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\wordcount\WordCountDemo.java 

.\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\myapp\Line.java 
.\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\myapp\LineSplit.java 
.\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\myapp\WordCount.java 
```

> Spring Boot

```
Start the Spring Boot Application - EksempelAppApplication.java

- String: Work
curl -X GET http://localhost:8080/kafka/string/producer?message=test

- Object: not work
curl -X GET http://localhost:8080/kafka/sample1/send/foo/bar
curl -X GET http://localhost:8080/kafka/sample1/send/foo/fail

curl -X GET http://localhost:8080/kafka/sample2/send/foo/bar
curl -X GET http://localhost:8080/kafka/sample2/send/bar/baz
curl -X GET http://localhost:8080/kafka/sample2/send/unknown/xxx

curl -X GET http://localhost:8080/kafka/sample3/send/foos/a,b,c,d,e
```

- Consumer - [Consumer Configurations](https://docs.confluent.io/current/installation/configuration/consumer-configs.html): Receive message

```
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my_topic --from-beginning
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my_streams_topic --from-beginning --formatter kafka.tools.DefaultMessageFormatter --property print.key=true --property print.value=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
```

- Reset kafka streams application

> Local reset (for each application instance)

```
Call KafkaStreams#cleanUp() in your application code before KafkaStreams#start() to perform a local reset.
```

> Global reset (for the overall application)

```
.\bin\windows\kafka-streams-application-reset.bat --application-id 0 --bootstrap-servers localhost:9092 --intermediate-topics my_topic,tes,test2 --input-topics my_topic,tes,test2 --zookeeper localhost:2181

.\bin\windows\kafka-streams-application-reset.bat 
    --application-id 0 
    --bootstrap-servers localhost:9092 
    --intermediate-topics my_topic,tes,test2 
    --input-topics my_topic,tes,test2 
    --zookeeper localhost:2181

Option (* = required)         Description
---------------------         -----------
* --application-id <id>       The Kafka Streams application ID (application.id)
--bootstrap-servers <urls>    Comma-separated list of broker urls with format: HOST1:PORT1,HOST2:PORT2
                                (default: localhost:9092)
--intermediate-topics <list>  Comma-separated list of intermediate user topics
--input-topics <list>         Comma-separated list of user input topics
--zookeeper <url>             Format: HOST:POST
                                (default: localhost:2181)
```
 
- Check and Kill an application

> WINDOWS

```
netstat -ano | findstr :<yourPortNumber>
taskkill /PID <typeyourPIDhere> /F
```
> LINUX

```
sudo netstat -pnlt | grep :8080
kill -9 19467
```

> MAC

```
netstat -vanp tcp | grep 8080
```
