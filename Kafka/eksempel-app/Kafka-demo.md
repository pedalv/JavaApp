## Example: Basic

> Step 1: Start the server - Zookeeper

```
kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

> Test zookeeper environment

```
telnet localhost 2181
stat
```

> Step 2: Start the Kaftka - Broker

```
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties
```

> Step 3: Create a Topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --topic my_topic --zookeeper localhost:2181 --replication-factor 1 --partitions 1 


- fra quicstart
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
```

> Logs are locate in C:\tmp\kafka-logs\my_topic\*.log

> Change a old topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --alter --topic my_topic --partitions 4 
```

> Show all topics created

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181


- fra quicstart
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

```

> Step 4: Producer: to send message 

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic my_topic

- fra quicstart
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

> Step 5: Consumer: to receive message

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --zookeeper localhost:2181 --topic my_topic --from-beginning


- fra quicstart
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```

## Example: Multi-broker kafka Setup, Single Partition Topic
> Step 6: Start several Kaftka - multi-Broker

```

config/server-1.properties:
    broker.id=1
    listeners=PLAINTEXT://:9093
    log.dirs=/tmp/kafka-logs-1
 
config/server-2.properties:
    broker.id=2
    listeners=PLAINTEXT://:9094
    log.dirs=/tmp/kafka-logs-2

kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server-1.properties
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server-2.properties
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server-3.properties
```

> Create a Topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --topic replicated_topic --zookeeper localhost:2181 --replication-factor 3 --partitions 1 

- fra quicstart
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 1 --topic my-replicated-topic
```

> Information about a Topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe replicated_topic --zookeeper localhost:2181

- fra quicstart
bin/kafka-topics.sh --describe --bootstrap-server localhost:9092 --topic my-replicated-topic
bin/kafka-topics.sh --describe --bootstrap-server localhost:9092 --topic test
```

> Information about all topics created

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --describe
```

> Producer: to send message 

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic replicated_topic

- fra quicstart
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-replicated-topic
```

> Consumer: to receive message

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --zookeeper localhost:2181 --topic replicated_topic --from-beginning


- fra quicstart
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --from-beginning --topic my-replicated-topic
```


> Let's kill Broker 1 

```
- on LINUX use:
> ps aux | grep server-1.properties
7564 ttys002    0:15.91 /System/Library/Frameworks/JavaVM.framework/Versions/1.8/Home/bin/java...
> kill -9 7564

- On Windows use:
> wmic process where "caption = 'java.exe' and commandline like '%server-1.properties%'" get processid
ProcessId
6016
> taskkill /pid 6016 /f
```


> Generate messages

```
kafka_2.12-2.5.0> .\bin\windows\kafka-producer-perf-test.bat --topic my-other-topic --num-records 50 --record-size 1 throughput 10 producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer
```


> Step 7: Use Kafka Connect to import/export data 

- Kafka Connect:  connectors that import data from a file to a Kafka topic and export data from a Kafka topic to a file.


- Step 1: Creating some seed data to test with:

```
- on LINUX use:
> echo -e "foo\nbar" > test.txt

- on WINDOWS use:
> echo foo> test.txt
> echo bar>> test.txt

> more test.sink.txt
foo
bar
...
> echo Another line>> test.txt
```


- Step 2: Start two connectors running in standalone mode, which means they run in a single, local, dedicated process
```
> bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties

> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning
{"schema":{"type":"string","optional":false},"payload":"foo"}
{"schema":{"type":"string","optional":false},"payload":"bar"}

```

> Step 8: Use [Kafka Streams](https://kafka.apache.org/25/documentation/streams/) to process data

- Kafka Streams is a client library for building mission-critical real-time applications and microservices, where the input and/or output data is stored in Kafka clusters. 
- Kafka Streams combines the simplicity of writing and deploying standard Java and Scala applications on the client side with the benefits of Kafka's server-side cluster technology to  make these applications highly scalable, elastic, fault-tolerant, distributed, and much more. 
