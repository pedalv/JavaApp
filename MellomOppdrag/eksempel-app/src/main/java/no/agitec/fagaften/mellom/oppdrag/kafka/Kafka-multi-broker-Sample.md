## Kafka Multi Broker Sample

- zookeeper server start
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

- kafka server start
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
.\bin\windows\kafka-server-start.bat .\config\server-1.properties
.\bin\windows\kafka-server-start.bat .\config\server-2.properties
.\bin\windows\kafka-server-start.bat .\config\server-3.properties
```

- create topic: multi broker
```
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 1 --topic topic-multi
```

- describe topic
```
.\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181
.\bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic topic-multi
```

```
Topic: topic-multi      PartitionCount: 1       ReplicationFactor: 2    Configs:
        Topic: topic-multi      Partition: 0    Leader: 3       Replicas: 3,2   Isr: 3,2
```

- change topic
```
.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --alter --topic topic-multi --partitions 4
```
- WARNING:
```
 If partitions are increased for a topic that has a key, the partition logic or ordering of the messages will be
 affected
Adding partitions succeeded!
```
- changed topic (partition === replicationfactor)
```
Topic: topic-multi      PartitionCount: 4       ReplicationFactor: 2    Configs:
        Topic: topic-multi      Partition: 0    Leader: 3       Replicas: 3,2   Isr: 3,2
        Topic: topic-multi      Partition: 1    Leader: 0       Replicas: 0,1   Isr: 0,1
        Topic: topic-multi      Partition: 2    Leader: 1       Replicas: 1,2   Isr: 1,2
        Topic: topic-multi      Partition: 3    Leader: 2       Replicas: 2,3   Isr: 2,3
```

- old topic
```
Topic: topic-multi      PartitionCount: 1       ReplicationFactor: 2    Configs:
        Topic: topic-multi      Partition: 0    Leader: 3       Replicas: 3,2   Isr: 3,2
```

- After kill kafka: server-1 (down) server-2 (up) server-3 (down)
```
Topic: topic-multi      PartitionCount: 4       ReplicationFactor: 2    Configs:
        Topic: topic-multi      Partition: 0    Leader: none    Replicas: 3,2   Isr: 2
        Topic: topic-multi      Partition: 1    Leader: 1       Replicas: 0,1   Isr: 1
        Topic: topic-multi      Partition: 2    Leader: 1       Replicas: 1,2   Isr: 1
        Topic: topic-multi      Partition: 3    Leader: none    Replicas: 2,3   Isr: 2
```

- Consule producer
```
.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic topic-multi
```

- Consule Consumer
```
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic-multi --from-beginning
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

- Kafka Partition: In general, the scalability of Apache Kafka is determined by the number of partitions being managed by multiple broker nodes.

> The more partitions the greater the Zookeeper overhead
> - With large partition numbers ensure proper ZK capacity

> Message ordering can become complex
> - Single partition for global ordering
> - Consumer-handling for ordering

> The more partitions the longer the leader fail-over time

- Replication Factor

> Reliable work distribution
> - Redundancy of messages
> - Cluster resiliency
> - Fault-tolerance

> Guarantees
> - N-1 broker failure tolerance
> - 2 or 3 minimum

> Configured on a per topic basis
