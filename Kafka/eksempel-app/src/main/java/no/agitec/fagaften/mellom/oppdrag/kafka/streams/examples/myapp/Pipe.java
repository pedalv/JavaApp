package no.agitec.fagaften.mellom.oppdrag.kafka.streams.examples.myapp;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * (works)
 */
public class Pipe {

    public static final String INPUT_TOPIC = "streams-plaintext-input";
    public static final String OUTPUT_TOPIC = "streams-pipe-output";

    static Properties getStreamsConfig() {
        final Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        // Note: To re-run the demo, you need to use the offset reset tool:
        // https://cwiki.apache.org/confluence/display/KAFKA/Kafka+Streams+Application+Reset+Tool
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

    static void createWordCountStream(final StreamsBuilder builder) {
        /*
        Kilde: WordCountDemo
        final KStream<String, String> source = builder.stream(INPUT_TOPIC);

        final KTable<String, Long> counts = source
            .flatMapValues(value -> Arrays.asList(value.toLowerCase(Locale.getDefault()).split(" ")))
            .groupBy((key, value) -> value)
            .count();

        // need to override value serde to Long type
        counts.toStream().to(OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.Long()));
        */

        /*
        final KStream<String, String> source = builder.stream(INPUT_TOPIC);
        === Refactoring 1
        */
        /*
        KStream<String, String> source = builder.stream("streams-plaintext-input");
        source.to("streams-pipe-output");
        ===
         */
        // Refactoring 1:
        builder.stream(INPUT_TOPIC).to(OUTPUT_TOPIC);
    }

    public static void main(String[] args) {

        final Properties props = getStreamsConfig();
        //https://kafka.apache.org/25/documentation/#streamsconfigs
        final StreamsBuilder builder = new StreamsBuilder();
        createWordCountStream(builder);
        final Topology topology = builder.build();
        System.out.println(topology.describe());
        /*
        Topologies:
           Sub-topology: 0
            Source: KSTREAM-SOURCE-0000000000 (topics: [streams-plaintext-input]) --> KSTREAM-SINK-0000000001
            Sink: KSTREAM-SINK-0000000001 (topic: streams-pipe-output)            <-- KSTREAM-SOURCE-000000000

            (the --> and <-- arrows dictates the downstream and upstream processor nodes of this node,
                i.e. "children" and "parents" within the topology graph)


        A stream processor
            is a node in the processor topology;
            it represents a processing step to transform data in streams by receiving one input record
                at a time from its upstream processors in the topology, applying its operation to it,
                and may subsequently produce one or more output records to its downstream processors.

        There are two special processors in the topology:
        - Source Processor: A source processor is a special type of stream processor
            that does not have any upstream processors. It produces an input stream to its topology
            from one or multiple Kafka topics by consuming records from these topics
            and forwarding them to its down-stream processors.
        - Sink Processor: A sink processor is a special type of stream processor
            that does not have down-stream processors. It sends any received records
            from its up-stream processors to a specified Kafka topic.
         */

        final KafkaStreams streams = new KafkaStreams(topology, props);
        final CountDownLatch latch = new CountDownLatch(1);

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-pipe-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (final Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}

/*
Topologies:
   Sub-topology: 0
    Source: KSTREAM-SOURCE-0000000000 (topics: [streams-plaintext-input])
                --> KSTREAM-SINK-0000000001
    Sink: KSTREAM-SINK-0000000001 (topic: streams-pipe-output)
                <-- KSTREAM-SOURCE-0000000000

08:35:08.618 [main] INFO org.apache.kafka.streams.StreamsConfig - StreamsConfig values:
	application.id = streams-pipe
	application.server =
	bootstrap.servers = [localhost:9092]
	buffered.records.per.partition = 1000
	built.in.metrics.version = latest
	cache.max.bytes.buffering = 10485760
	client.id =
	commit.interval.ms = 30000
	connections.max.idle.ms = 540000
	default.deserialization.exception.handler = class org.apache.kafka.streams.errors.LogAndFailExceptionHandler
	default.key.serde = class org.apache.kafka.common.serialization.Serdes$StringSerde
	default.production.exception.handler = class org.apache.kafka.streams.errors.DefaultProductionExceptionHandler
	default.timestamp.extractor = class org.apache.kafka.streams.processor.FailOnInvalidTimestamp
	default.value.serde = class org.apache.kafka.common.serialization.Serdes$StringSerde
	max.task.idle.ms = 0
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	num.standby.replicas = 0
	num.stream.threads = 1
	partition.grouper = class org.apache.kafka.streams.processor.DefaultPartitionGrouper
	poll.ms = 100
	processing.guarantee = at_least_once
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	replication.factor = 1
	request.timeout.ms = 40000
	retries = 0
	retry.backoff.ms = 100
	rocksdb.config.setter = null
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	state.cleanup.delay.ms = 600000
	state.dir = /tmp/kafka-streams
	topology.optimization = none
	upgrade.from = null
	windowstore.changelog.additional.retention.ms = 86400000

08:35:08.817 [main] INFO org.apache.kafka.streams.KafkaStreams - stream-client [streams-pipe-b0a4b2f8-f15b-4a2d-903d-350c26f85542] Kafka Streams version: 2.5.0
08:35:08.817 [main] INFO org.apache.kafka.streams.KafkaStreams - stream-client [streams-pipe-b0a4b2f8-f15b-4a2d-903d-350c26f85542] Kafka Streams commit ID: 66563e712b0b9f84
08:35:08.862 [main] INFO org.apache.kafka.clients.admin.AdminClientConfig - AdminClientConfig values:
	bootstrap.servers = [localhost:9092]
	client.dns.lookup = default
	client.id = streams-pipe-b0a4b2f8-f15b-4a2d-903d-350c26f85542-admin
	connections.max.idle.ms = 300000
	default.api.timeout.ms = 60000
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 2147483647
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.2
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS

08:35:08.998 [main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values:
	allow.auto.create.topics = true
	auto.commit.interval.ms = 5000
	auto.offset.reset = none
	bootstrap.servers = [localhost:9092]
	check.crcs = true
	client.dns.lookup = default
	client.id = streams-pipe-b0a4b2f8-f15b-4a2d-903d-350c26f85542-StreamThread-1-restore-consumer
	client.rack =
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = false
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = null
	group.instance.id = null
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = false
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.ByteArrayDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 1000
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	session.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.2
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.ByteArrayDeserializer

08:35:09.059 [main] INFO org.apache.kafka.clients.producer.ProducerConfig - ProducerConfig values:
	acks = 1
	batch.size = 16384
	bootstrap.servers = [localhost:9092]
	buffer.memory = 33554432
	client.dns.lookup = default
	client.id = streams-pipe-b0a4b2f8-f15b-4a2d-903d-350c26f85542-StreamThread-1-producer
	compression.type = none
	connections.max.idle.ms = 540000
	delivery.timeout.ms = 120000
	enable.idempotence = false
	interceptor.classes = []
	key.serializer = class org.apache.kafka.common.serialization.ByteArraySerializer
	linger.ms = 100
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metadata.max.idle.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 2147483647
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.2
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.ByteArraySerializer

  08:35:09.142 [main] DEBUG org.apache.kafka.streams.processor.internals.InternalTopicManager - stream-thread [main] Configs:
	retries = 2147483647
	replication.factor = 1
	windowstore.changelog.additional.retention.ms = 86400000
 */