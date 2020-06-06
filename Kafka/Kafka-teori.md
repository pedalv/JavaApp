## [Getting Started with Apache Kafka](https://app.pluralsight.com/library/courses/apache-kafka-getting-started/table-of-contents)

- [kafka-clients](https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients) | [kafka-streams-test-utils](https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams-test-utils)

```
	<!-- https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients -->
	<dependency>
		<groupId>org.apache.kafka</groupId>
		<artifactId>kafka-clients</artifactId>
		<version>0.10.0.1</version>
		<version>2.5.0</version> 	<!-- kafka: 2.12, kafka-clients: 2.5.0 -->
		<version>0.10.0.1</version> <!-- kafka: 2.11, kafka-clients: 0.10.0.1 -->
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams-test-utils -->
	<dependency>
		<groupId>org.apache.kafka</groupId>
		<artifactId>kafka-streams-test-utils</artifactId>
		<version>2.5.0</version>
		<scope>test</scope>
	</dependency>
```
- [Kafka Download](https://kafka.apache.org/downloads.html)
- [Scala Download](https://www.scala-lang.org/download/)
- [How to enable the Telnet Client in Windows 10](https://www.rootusers.com/how-to-enable-the-telnet-client-in-windows-10/)
- [quickstart](https://kafka.apache.org/quickstart)

#### Goal of Kafka
- Apache Kafka process hundreds of billions of messages per day
- Apache Kafka was designed to address large-scale, data movement problems and has enabled thousands of companies large and small to achieve successes not otherwise achievable with existing messaging systems. 
- Build the next generation big data solutions 

#### The Course
- Understanding of Apache Kafka's architecture and 
- How it has adopted proven distributed systems design principles that enable it to scale and perform reliably. 
- Then, you will breakdown this architecture into individual components and learn about each in great detail. 
- Finally, use the components in action with common scenarios and walkthough how Apache Kafka solutions can be developed in Java. 

#### Kafka
- Distributed messaging system
- Designed to move data at high volumes
- Addresses shortcomings of traditional data movement tools and approaches
- Invented by LinkedIn to address data
growth issues common to many enterprises
- Open-sourced under Apache Software Foundation in 2012
- First-choice adoption for data movement for hundreds of enterprise and internet-scale companies

#### Arkitecture
![Kafka Architecture](https://github.com/pedalv/JavaApp/blob/master/Kafka/kafka-architecture-1.PNG)

![Spring Boot + Kafka](https://github.com/pedalv/JavaApp/blob/master/Kafka/boot-kafka_1.png)

![Spring Boot + Kafka](https://github.com/pedalv/JavaApp/blob/master/Kafka/kafka_concepts.PNG)


- Distributed Systems: 

> Collection of resources that are instructed to achieve a specific goal or function

> Consist of multiple workers or nodes

> The system of nodes require coordination to ensure consistency and progress towards a common goal

> Each node communicates with each other though messages

- Distributed Systems: Communication and Consensus

> Worker node membership and naming

> Configuration management

> Leader election

> Health status

- Apache Kafka is a Pub-Sub messaging system, consisting of:

> Producers and Consumers

> Brokers within a Cluster

- Characteristics of distributed systems

> Worker node roles: Controllers, Leaders, and Followers

> Reliability through replication

> Consensus-based communication

- Role of Apache Zookeeper

> [ZooKeeper: Because coordinating distributed systems is a Zoo](https://cwiki.apache.org/confluence/display/ZOOKEEPER/Index)

> Centralized service for maintaining
metadata about a cluster of distributed nodes

1. Configuration information

2. Heath status

3. Group membership

> Hadoop, HBase, Mesos, Solr, Redis, and Neo4j

> Distributed system consisting of multiple nodes in an “ensemble”

#### Understanding Topics, Partitions, and Brokers

- Basic Apache Kafka installation (DEMO):

> Download the binary package

> Extract the archive

> Explore the installation directory contents

Prerequisites:

> Linux operating system

> Java 8 JDK installed

> Scala 2.11.x installed

- Apache Kafka Topics

> Central Kafka abstraction

> Named feed or category of messages

1. Producers produce to a topic

2. Consumers consume from a topic

> Logical entity

> Physically represented as a log

> Higher order data structures derive from the log - Tables, indexes, views, etc.

> Apache Kafka is publish-subscribe messaging rethought as a distributed commit log.

- Event Sourcing

An architectural style or approach to maintaining an application’s state by capturing all changes as a sequence of time-ordered, immutable events.

- Each Message Content has a:

> Timestamp

> Referenceable identifier

> Payload (binary)

- The Offset, A placeholder:

> Last read message position

> Maintained by the Kafka Consumer

> Corresponds to the message identifier

- Message Retention Policy

> Apache Kafka retains all published messages regardless of consumption 

> Retention period is configurable - Default is 168 hours or seven days

> Retention period is defined on a per-topic basis

> Physical storage resources can constrain message retention


#### [KAFKA DEMO](https://github.com/pedalv/JavaApp/blob/master/Kafka/Kafka-demo.md)
- Kafka Partitions

> Each topic has one or more partitions

> A partition is the basis for which Kafka can: Scale, Become fault-tolerant, and Achieve higher levels of throughput

> Each partition is maintained on at least one
or more Brokers

- Configuration
In general, the scalability of Apache Kafka is determined by the number of partitions being managed by multiple broker nodes.

- Creating a Topic: Single / Multiple Partitions -> ~$ bin/kafka-topics.sh --create --topic my_topic\

```
--zookeeper localhost:2181 \
--partitions 1 \
--replication-factor 1
```

- Partitioning Trade-offs 

> The more partitions the greater the Zookeeper overhead - With large partition numbers ensure proper ZK capacity

> Message ordering can become complex - Single partition for global ordering and Consumer-handling for ordering

> The more partitions the longer the leader fail-over time

- Replication Factor

> Reliable work distribution - Redundancy of messages, Cluster resiliency and Fault-tolerance

> Guarantees - N-1 broker failure tolerance and 2 or 3 minimum

> Configured on a per-topic basis

- Viewing Topic State -> ~$ bin/kafka-topics.sh --describe --topic my_topic\

- Kafka Producer Shell Program -> ~$ bin/kafka-console-producer.sh \

```
--broker-list localhost:9092, localhost:9093 \
--topic my_topic

MyMessage 1
MyMessage 2
```

#### Producing Messages with Kafka and Producers
Kafka Producer instances can only send ProducerRecords that match the key and value serializers types it is configured with.

- Creating a Kafka Producer : Required Properties

> bootstrap.servers - Cluster membership: partition leaders, etc.

> key and value serializers - Classes used for message serialization and deserialization


```
public class KafkaProducerApp {
	public static void main(String[] args){
		Properties props = new Properties();
		props.put(“bootstrap.servers”, “BROKER-1:9092, BROKER-2:9093”);
		props.put(“key.serializer”, “org.apache.kafka.common.serialization.StringSerializer”);
		props.put(“value.serializer”, “org.apache.kafka.common.serialization.StringSerializer”);
		KafkaProducer myProducer = new KafkaProducer(props);
		
		props.put(“value.serializer”, “org.apache.kafka.common.serialization.StringSerializer”)
		ProducerRecord myMessage = new ProducerRecord(“my_topic”,“My Message 1”);
	}
}
```

- Kafka Producer Shell Program

```
~$ bin/kafka-console-producer.sh \
> --broker-list localhost:9092, localhost:9093 \
> --topic my_topic
MyMessage 1
MyMessage 2
```

- ProducerRecord: Required Properties

KafkaProducer instances can only send ProducerRecords that match the key and value serializers types it is configured with.


> topic - Topic to which the ProducerRecord will be sent

> value - The message content (matching the serializer type for value)

```
	props.put(“value.serializer”, “org.apache.kafka.common.serialization.StringSerializer”)
	ProducerRecord myMessage = new ProducerRecord(“my_topic”,“My Message 1”);
	
	ProducerRecord myMessage = new ProducerRecord(“my_topic”,3.14159);
	SerializationException: Can’t convert value of class ...
		
```

- ProducerRecord: Optional Properties

> partition - specific partition within the topic to send ProducerRecord

> timestamp - the Unix timestamp applied to the record

> key - a value to be used as the basis of determining the partitioning strategy to be employed by the Kafka Producer


```
	ProducerRecord(String topic, Integer partition, Long timestamp, K key, V value);
	// Example:
	ProducerRecord(“my_topic”, 1, 124535353325, “Course-001”,“My Message 1”);
	// Defined in server.properties:
	log.message.timestamp.type = [CreateTime, LogAppendTime]
	// CreateTime: producer-set timestamp used.
	// LogAppendTime: broker-set timestamp used when message is appended to commit log.
```

- Best Practice: Define a Key

Two useful purposes:

> Additional information in the message

> Can determine what partitions the message will be written to

Downside:

> Additional overhead

> Depends on the serializer type used

- Making Messaging Magic

```
public class KafkaProducerApp {

	public static void main(String[] args){
	
		Properties props = new Properties();
		props.put(“bootstrap.servers”, “BROKER-1:9092, BROKER-2:9093”);
		props.put(“key.serializer”, “org.apache.kafka.common.serialization.StringSerializer”);
		props.put(“value.serializer”, “org.apache.kafka.common.serialization.StringSerializer”);
		
		KafkaProducer myProducer = new KafkaProducer(props);
		ProducerRecord myRecord = new ProducerRecord(“my_topic”, “Course-001”, “My Message 1”);
		myProducer.send(myRecord); // Best practice: try..catch
		
	}
	
}
```

- Micro-batching in Apache Kafka

At scale, efficiency is everything. Small, fast batches of messages:

> Sending (Producer)

> Writing (Broker)

> Reading (Consumer)

Modern operating system functions:

> Pagecache

> Linux sendfile() system call (kernel)

Amortization of the constant cost

- Delivery Guarantees

Broker acknowledgement (“acks”)

> 0: fire and forget

> 1: leader acknowledged

> 2: replication quorum acknowledged

Broker responds with error

> “retries”

> “retry.backoff.ms”

- Ordering Guarantees

Message order by partition

> No global order across partitions

Can get complicated with errors

> retries, retry.backoff.ms

> max.in.flight.request.per.connection

Delivery semantics

> At-most-once, at-least-once, only-once


#### Producing Messages with Kafka - Sumary

Kafka Producer Internals

> Properties -> ProducerConfig

> Message -> ProducerRecord

> Processing Pipeline: Serializers and

Partitioners

> Micro-batching -> Record Accumulator and RecordBuffer

Delivery and Ordering Guarantees

Java-based Producer


#### Consuming Messages with Kafka - Consumers and Consumer Groups

- http://kafka.apache.org/documentation.html#consumerconfigs
- Kafka Consumer: Required Properties

> bootstrap.servers - Cluster membership: partition leaders, etc.

> key and value deserializers - Classes used for message deserialization

```
Properties props = new Properties();
props.put(“bootstrap.servers”, “BROKER-1:9092, BROKER-2:9093”);
props.put(“key.deserializer”, “org.apache.kafka.common.serialization.StringDeserializer”);
props.put(“value.deserializer”, “org.apache.kafka.common.serialization.StringDeserializer”);
```

- Creating a Kafka Consumer

```
public class KafkaConsumerApp {
	public static void main(String[] args){
		Properties props = new Properties();
		props.put(“bootstrap.servers”, “BROKER-1:9092, BROKER-2:9093”);
		props.put(“key.deserializer”, “org.apache.kafka.common.serialization.StringDeserializer”);
		props.put(“value.deserializer”, “org.apache.kafka.common.serialization.StringDeserializer”);
		
		1. Creating a Kafka Consumer
		KafkaConsumer myConsumer = new KafkaConsumer(props);
		
		2. Subscribing to Topics
		myConsumer.subscribe(Arrays.asList(“my-topic”));
		// Alternatively, use regular expressions:
		myConsumer.subscribe(“my-*”);
		
		// Initial subscription:
		myConsumer.subscribe(Arrays.asList(“my-topic”));
		// Later, add another topic to the subscription (intentional):
		myConsumer.subscribe(Arrays.asList(“my-other-topic”));
		// Better for incremental topic subscription management:
		ArrayList<String> topics = new ArrayList<String>();
		topics.add(“myTopic”);
		topics.add(“myOtherTopic”);
		myConsumer.subscribe(topics);
		
		3. Un-subscribing to Topics
		ArrayList<String> topics = new ArrayList<String>();
		topics.add(“myTopic”);
		topics.add(“myOtherTopic”);
		myConsumer.subscribe(topics);
		myConsumer.unsubscribe();
		// Less-than-intuitive unsubscribe alternative:
		topics.clear(); // Emptying out the list
		myConsumer.subscribe(topics); // passing the subscribe() method a list of empty strings

		4. Manual Partition Assignment
		// Similar pattern as subscribe():
		TopicPartition partition0 = new TopicPartition(“myTopic”, 0);
		ArrayList<TopicPartition> partitions = new ArrayList<TopicPartition>();
		partitions.add(partition0);
		
		myConsumer.assign(partitions); // Remember this is NOT incremental!

		5. Starting the Poll Loop
		// Set the topic subscription or partition assignments:
		myConsumer.subscribe(topics);
		myConsumer.assign(partitions);
		try {
			while (true) {
				ConsumerRecords<String, String> records = myConsumer.poll(100);
				// Your processing logic goes here...
			}
			finally {
				myConsumer.close();
			}
		}
	}
}
```

- subscribe()

> For topics (dynamic/automatic

> One topic, one-to-many partitions

> Many topics, many more partitions

- assign()

> For partitions

> One or more partitions, regardless of topic

>  Manual, self-administering mode


- The Poll Loop

> Primary function of the Kafka Consumer - poll()

> The poll() process is a single-threaded operation.

> Continuously polling the brokers for data

> Single API for handling all Consumer-Broker interactions - A lot of interactions beyond message retrieval

> The extent in which your system can be tolerant of eventually consistency is determined by its reliability.

- Offset Behavior

> Read != Committed

> Offset commit behavior is configurable

1. enable.auto.commit = true (default)

2.  auto.commit.interval.ms = 5000 (default)

3. auto.offset.reset = “latest” (default) - “earliest” or “none”

> Single Consumer vs. Consumer Group

- Offset Management

> Automatic vs. Manual : enable.auto.commit = false

> Full control of offset commits : commitSync() or commitAsync()

> commitSync

- Synchronous : blocks until receives response from cluster

- Retries until succeeds or unrecoverable error : retry.backoff.ms (default: 100)

- commitAsync

> Asynchronous : non-blocking but non-deterministic

> No retries

> Callback option

```
try {
	for (...) { // Processing batches of records... }
		// Commit when you know you’re done, after the batch is processed:
		myConsumer.commitSync();
	} catch (CommitFailedException) {
		log.error(“there’s not much else we can do at this point...”);
	}
	
	// Not recommended:
	myConsumer.commitAsync();

	// Recommended:
	myConsumer.commitAsync(new OffsetCommitCallback() {
		public void onComplete(..., ..., ...) { // do something...}
	});
	
```
- Going It Alone (database)

> Consistency control : When is “done” 

> Atomicity : Exactly once vs. At-least-once 

- Consumer Groups

> Kafka’s solution to Consumer-side scaleout

> Independent Consumers working as a team : “group.id” setting

> Sharing the message consumption and processing load

1. Parallelism and throughput

2. Redundancy

3. Performance

- Group Coordinator

> Evenly balances available Consumers to partitions -> 1:1 Consumer-to-partition ratio, and Can’t avoid over-provisioning

> Initiates the rebalancing protocol -> Topic changes (partition added) and Consumer failure

- Consumer Configuration

> fetch.min.bytes

> max.fetch.wait.ms

> max.partition.fetch.bytes

> max.poll.records

- Advanced Topics

> Consumer position control : seek(), seekToBeginning() and seekToEnd()

> Flow control : pause() and resume

> Rebalance Listeners

- Summary

> Kafka Consumer Internals

1. Properties -> ConsumerConfig

2. Message -> ConsumerRecord

3. Subscriptions and assigments

4. Message polling and consumption

5. Offset management

> Consumer Groups

> Consumer Configuration

> Java-based Consumer


#### Exploring the Kafka Ecosystem and Its Future
- Kafka Schema Registry

> Apache Avro serialization format

> First-class Avro serializers and deserializers

> Schema registry and version management

> RESTful service discovery

> Compatibility broker

> Open source with Apache license

- Apache Kafka Connect

> Common framework for integration - Standardization of common approaches
and Producers and Consumers

> Platform Connectors - Oracle, HP, etc.

> Connector Hub

- Kafka Streams

> Leverages existing Kafka machinery

> Single infrastructure solution - At least for streaming-based processing

> Embeddable within existing applications
