## [Run Kafka Streams Demo Application](https://kafka.apache.org/25/documentation/streams/quickstart)

- [WordCountDemo](https://github.com/apache/kafka/blob/2.5/streams/examples/src/main/java/org/apache/kafka/streams/examples/wordcount/WordCountDemo.java)
- [Kafka Streams Application Reset Tool](https://cwiki.apache.org/confluence/display/KAFKA/Kafka+Streams+Application+Reset+Tool)

> Step 1 of 2: Local reset (for each application instance)

Call KafkaStreams#cleanUp() in your application code before KafkaStreams#start() to perform a local reset.

> Step 2 of 2: Global reset (for the overall application)

```
$ bin/kafka-streams-application-reset.sh
 
Option (* = required)         Description
---------------------         -----------
* --application-id <id>       The Kafka Streams application ID (application.id)
--bootstrap-servers <urls>    Comma-separated list of broker urls with format: HOST1:PORT1,HOST2:PORT2
                                (default: localhost:9092)
--intermediate-topics <list>  Comma-separated list of intermediate user topics
--input-topics <list>         Comma-separated list of user input topics
--zookeeper <url>             Format: HOST:POST
                                (default: localhost:2181)
Eksempel:
$ .\bin\windows\kafka-streams-application-reset.bat --application-id 0 --bootstrap-servers localhost:9092 --intermediate-topics my_topic,tes,test2 --input-topics my_topic,tes,test2 --zookeeper localhost:2181

```

- Step 1: Download the code

- Step 2: Start the Kafka server: Zookeeper og Kafka

> Zookeeper Server: Port 2181

```
kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

> Kafka Server - Broke

```
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties
```

- Step 3: Prepare input topic and start Kafka producer (we create the input topic named streams-plaintext-input and the output topic named streams-wordcount-output:)

```
> .\bin\windows\kafka-topics.bat --create \
      --bootstrap-server localhost:9092 \
      --replication-factor 1 \
      --partitions 1 \
      --topic streams-plaintext-input

kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-plaintext-input

> .\bin\windows\kafka-topics.bat --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic streams-wordcount-output \
    --config cleanup.policy=compact

kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-wordcount-output --config cleanup.policy=compact

kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic streams-plaintext-input (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic streams-wordcount-output (works)
```

- Step 4: Start the Wordcount Application

```
kafka_2.12-2.5.0> .\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\wordcount\WordCountDemo.java (work)
kafka_2.12-2.5.0> bin/kafka-run-class.sh org.apache.kafka.streams.examples.wordcount.WordCountDemo


- Send some messages - Producer
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic streams-plaintext-input (works)

- Consumer: to receive message
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic streams-wordcount-output --from-beginning --formatter kafka.tools.DefaultMessageFormatter --property print.key=true --property print.value=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic streams-wordcount-output --from-beginning (works)

```

- Step 5: Process some data

| Producer      | Consumer      |
| ------------- |:-------------:|
| Pedro         | pedro   3     |
| pedro         | louren´┐¢o      1      |
| PEDRO         | pils    1     |
| lourenço      | ´┐¢l    1     |
| pils          | b´┐¢k   1     |
| øl            |               |
| bøk           |               |

## Documentation
- [3.6 Kafka Streams Configs](https://kafka.apache.org/25/documentation/#streamsconfigs)