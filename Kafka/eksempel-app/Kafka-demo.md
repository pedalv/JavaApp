## Example: Basic
- Source: [Quickstart](https://kafka.apache.org/quickstart#quickstart_consume)

> Step 1: 
- kafka_2.12-2.5.0: /d/Workspace/JavaApp/Kafka/kafka_2.12-2.5.0/bin
- Kafka WIN Path (Important): D:\kafka_2.12-2.5.0   -> \bin\windows

> Step 2: Start the server on PowerShell
- Zookeeper Server: Port 2181

```
kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
kafka_2.12-2.5.0> bin/zookeeper-server-start.sh config/zookeeper.properties
```

> Test zookeeper environment
```
telnet localhost 2181
stat
```

- Kaftka Server - Broker:

```
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties
kafka_2.12-2.5.0> bin/kafka-server-start.sh config/server.properties
```

> Step 3: Create a Topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --topic my_topic --zookeeper localhost:2181 --replication-factor 1 --partitions 1 (not use)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
kafka_2.12-2.5.0> bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
                  

Result:
- Show all topics created
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181 (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 (not work)
kafka_2.12-2.5.0> bin/kafka-topics.sh --list --bootstrap-server localhost:9092
- Logs are locate in D:\tmp\kafka-logs
- Change an old topic
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --alter --topic my_topic --partitions 4
```

> Step 4: Send some messages - Producer 

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic my_topic (not work)
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my_topic (works) 
kafka_2.12-2.5.0> bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test
                  
```

> Step 5: Consumer: to receive message

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --zookeeper localhost:2181 --topic my_topic --from-beginning (not use)
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my_topic --from-beginning (works)
kafka_2.12-2.5.0> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
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
```

- Kaftka Server - Broker:

```
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties (works) => (--replication-factor 0)
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server-1.properties (works) => (--replication-factor 1)
kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server-2.properties (works) => (--replication-factor 2)

```

> Create a Topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --topic replicated_topic --zookeeper localhost:2181 --replication-factor 3 --partitions 1 (not use)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 2 --partitions 1 --topic my-replicated-topic (works) 
kafka_2.12-2.5.0> bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 1 --topic my-replicated-topic

```

> Information about a Topic

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic my-replicated-topic (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic my_topic (works)
kafka_2.12-2.5.0> bin/kafka-topics.sh --describe --bootstrap-server localhost:9092 --topic my-replicated-topic

"leader" is the node responsible for all reads and writes for the given partition. Each node will be the leader for a randomly selected portion of the partitions.
"replicas" is the list of nodes that replicate the log for this partition regardless of whether they are the leader or even if they are currently alive.
"isr" is the set of "in-sync" replicas. This is the subset of the replicas list that is currently alive and caught-up to the leader.

Topic: my-replicated-topic      PartitionCount: 1       ReplicationFactor: 2    Configs:
        Topic: my-replicated-topic      Partition: 0    Leader: 1       Replicas: 1,0   Isr: 1,0
Topic: my_topic PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: my_topic Partition: 0    Leader: 0       Replicas: 0     Isr: 0
```

> Send some messages - Producer

``` 
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my-replicated-topic (works)
kafka_2.12-2.5.0> bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic my-replicated-topic
```

> Consumer: to receive message


```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-replicated-topic --from-beginning (works)
kafka_2.12-2.5.0> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --from-beginning --topic my-replicated-topic
```

> Let's kill Broker 1 

```
kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic my-replicated-topic (works)
Topic: my-replicated-topic      PartitionCount: 1       ReplicationFactor: 2    Configs:
        Topic: my-replicated-topic      Partition: 0    Leader: 1       Replicas: 1,0   Isr: 1,0

- on LINUX use:
> ps aux | grep server-1.properties
7564 ttys002    0:15.91 /System/Library/Frameworks/JavaVM.framework/Versions/1.8/Home/bin/java...
> kill -9 7564

- On Windows use:
> wmic process where "caption = 'java.exe' and commandline like '%server-1.properties%'" get processid
ProcessId
6016
> taskkill /pid 6016 /f


kafka_2.12-2.5.0> .\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic my-replicated-topic (works)
Topic: my-replicated-topic      PartitionCount: 1       ReplicationFactor: 2    Configs:
        Topic: my-replicated-topic      Partition: 0    Leader: 0       Replicas: 1,0   Isr: 0
```

> Generate messages and Send some messages - Producer

```
kafka_2.12-2.5.0> .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my-replicated-topic (works)
kafka_2.12-2.5.0> .\bin\windows\kafka-producer-perf-test.bat --bootstrap-server localhost:9092 --topic my-replicated-topic --num-records 50 --record-size 1 throughput 10 producer-props key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer (not work)
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
kafka_2.12-2.5.0> .\bin\windows\connect-standalone.bat .\config\connect-standalone.properties .\config\connect-file-source.properties .\config\connect-file-sink.properties (not work)
kafka_2.12-2.5.0> bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties


> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning
{"schema":{"type":"string","optional":false},"payload":"foo"}
{"schema":{"type":"string","optional":false},"payload":"bar"}

```

> Step 8: Use [Kafka Streams](https://kafka.apache.org/25/documentation/streams/) to process data

- Kafka Streams is a client library for building mission-critical real-time applications and microservices, where the input and/or output data is stored in Kafka clusters. 
- Kafka Streams combines the simplicity of writing and deploying standard Java and Scala applications on the client side with the benefits of Kafka's server-side cluster technology to  make these applications highly scalable, elastic, fault-tolerant, distributed, and much more. 
- The Kafka Treams API transforms and enriches data 
- [Mirror of Apache Kafka](https://github.com/apache/kafka)