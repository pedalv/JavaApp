## [TUTORIAL: WRITE APP](https://kafka.apache.org/25/documentation/streams/tutorial)

- Step 1: Download the code

- Step 2: Start the Kafka server: Zookeeper og Kafka

> Zookeeper Server: Port 2181

```
kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

#### Pipe - LineSplit - WordCount

> Kafka Server - Broke

```
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties     
=> --topic streams-plaintext-input
=> --topic streams-pipe-output
=> --topic streams-linesplit-output
=> --topic streams-wordcount-output
```

- Step 3: Prepare input topic and start Kafka producer (we create the input topic named streams-plaintext-input and the output topic named streams-pipe-output:)

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
    --topic streams-pipe-output \
    --config cleanup.policy=compact

kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-pipe-output --config cleanup.policy=compact

> .\bin\windows\kafka-topics.bat --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic streams-linesplit-output \
    --config cleanup.policy=compact

kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-linesplit-output --config cleanup.policy=compact

> .\bin\windows\kafka-topics.bat --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic streams-wordcount-output \
    --config cleanup.policy=compact

kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-wordcount-output --config cleanup.policy=compact

- Description (Vis)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic streams-plaintext-input (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic streams-pipe-output (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic streams-linesplit-output (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic streams-wordcount-output (works)

```

- Step 4: Start the Pipe - LineSplit - WorldCount Application

```
kafka_2.12-2.5.0> .\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\myapp\Line.java (work)
kafka_2.12-2.5.0> .\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\myapp\LineSplit.java (work)
kafka_2.12-2.5.0> .\bin\windows\kafka-run-class.bat  ..\Workspace\JavaApp\MellomOppdrag\eksempel-app\src\main\java\no\agitec\fagaften\eksempelapp\kafka\streams\examples\myapp\WordCount.java (work)


- Send some messages - Producer
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic streams-plaintext-input (works)

- Consumer: to receive message
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic streams-pipe-output --from-beginning (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic streams-linesplit-output --from-beginning (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic streams-wordcount-output --from-beginning --formatter kafka.tools.DefaultMessageFormatter --property print.key=true --property print.value=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer (works)
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