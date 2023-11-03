/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.agitec.fagaften.mellom.oppdrag.kafka.quickstart.streams.examples.wordcount;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Demonstrates, using the high-level KStream DSL, how to implement the WordCount program
 * that computes a simple word occurrence histogram from an input text.
 * <p>
 * In this example, the input stream reads from a topic named "streams-plaintext-input", where the values of messages
 * represent lines of text; and the histogram output is written to topic "streams-wordcount-output" where each record
 * is an updated count of a single word.
 * <p>
 * Before running this example you must create the input topic and the output topic (e.g. via
 * {@code bin/kafka-topics.sh --create ...}), and write some data to the input topic (e.g. via
 * {@code bin/kafka-console-producer.sh}). Otherwise you won't see any data arriving in the output topic.
 */
public final class WordCountDemo {

    public static final String INPUT_TOPIC = "streams-plaintext-input";
    public static final String OUTPUT_TOPIC = "streams-wordcount-output";

    static Properties getStreamsConfig() {
        // Configuring a Streams Application: https://kafka.apache.org/25/documentation/streams/developer-guide/config-streams.html
        final Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        // Note: To re-run the demo, you need to use the offset reset tool:
        // https://cwiki.apache.org/confluence/display/KAFKA/Kafka+Streams+Application+Reset+Tool
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // * @deprecated Streams Security: https://kafka.apache.org/25/documentation/streams/developer-guide/security.html
        /*
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "/etc/security/tls/kafka.client.truststore.jks");
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "test1234");
        props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "/etc/security/tls/kafka.client.keystore.jks");
        props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "test1234");
        props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, "test1234");
        */



        return props;
    }

    /**
     * The Kafka Streams DSL (Domain Specific Language) is built on top of the Streams Processor API.
     *
     * Built-in abstractions for streams and tables in the form of KStream, KTable, and GlobalKTable.
     *
     * Declarative, functional programming style with
     *  stateless transformations (e.g. map and filter)
     *  as well as stateful transformations such as
     *  aggregations (e.g. count and reduce),
     *  joins (e.g. leftJoin),
     *  and windowing (e.g. session windows).
     *
     * See examples about:
     * Stateless transformations
     * Stateful transformations
     *
     * Streams DSL: https://kafka.apache.org/25/documentation/streams/developer-guide/dsl-api.html
     *
     * Package org.apache.kafka.streams: https://kafka.apache.org/25/javadoc/org/apache/kafka/streams/package-summary.html
     *
     * KStream  === INSERT => input
     * KTable  === UPDATE (not exist INSERT) => output
     * GlobalKTable === output from all partitions of the topic
     *
     * Input topics: StreamsBuilder#stream(), StreamsBuilder#table() and Topology#addSource().
     * Output topics: KStream#to(), KTable.to() and Topology#addSink().
     * Intermediate (input and output) topics: KStream#through().
     *
     * Stateless transformations: do not require state for processing and they do not require a state store associated with the stream processor.
     *  stream.toTable(), table.toStream(), stream.selectKey(...), stream.print(), stream.peek(...), stream1.merge(stream2),
     *  stream.mapValues(...), stream.map(...), stream.groupBy(...), stream.groupByKey(), stream.foreach(...),
     *  sentences.flatMapValues(...), stream.flatMap(...), stream.filterNot(...), stream.filter(...), stream.filter(...)
     *
     * Stateful transformations: depend on state for processing inputs and producing outputs and require a state store associated with the stream processor.
     * ... see examples ...
     *
     * Windowing: lets you control how to group records that have the same key for stateful operations such as aggregations or joins into so-called windows.
     *
     * Exemple of Querying local key-value stores:
     * https://kafka.apache.org/25/documentation/streams/developer-guide/interactive-queries.html#streams-developer-guide-interactive-queries-local-key-value-stores
     *
     * -----------------------------
     * Processor API: https://kafka.apache.org/25/documentation/streams/developer-guide/processor-api.html
     * Data Types and Serialization: https://kafka.apache.org/25/documentation/streams/developer-guide/datatypes.html
     *          (https://github.com/apache/kafka/tree/2.5/clients/src/main/java/org/apache/kafka/common/serialization)
     *      JSON: https://github.com/apache/kafka/blob/2.5/streams/examples/src/main/java/org/apache/kafka/streams/examples/pageview/PageViewTypedDemo.java#L83
     * Interactive Queries: https://kafka.apache.org/25/documentation/streams/developer-guide/interactive-queries.html#streams-developer-guide-interactive-queries-custom-stores
     *
     * @param builder
     */
    static void createWordCountStream(final StreamsBuilder builder) {
        final KStream<String, String> source = builder.stream(INPUT_TOPIC);

        final KTable<String, Long> counts = source
            .flatMapValues(value -> Arrays.asList(value.toLowerCase(Locale.getDefault()).split(" ")))
            .groupBy((key, value) -> value)
            .count();

        // need to override value serde to Long type
        counts.toStream().to(OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.Long()));

    }

    public static void main(final String[] args) {
        //Step 1 : Config Properties
        final Properties props = getStreamsConfig();

        //Step 2 : Create StreamsBuilder
        final StreamsBuilder builder = new StreamsBuilder(); // using DSL
        //Step 3 : Key Value - count like work => ord1 2 - ord2 5 - ...
        createWordCountStream(builder);
        //Step 4 : Create and start KafkaStreams and CountDownLatch
        // Writing a Streams Application: https://kafka.apache.org/25/documentation/streams/developer-guide/write-streams.html
        final KafkaStreams streams = new KafkaStreams(builder.build(), props);
        final CountDownLatch latch = new CountDownLatch(1);

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-wordcount-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        // To catch any unexpected exceptions, you can set an java.lang.Thread.UncaughtExceptionHandler
        // before you start the application. This handler is called whenever a stream thread is terminated by an unexpected exception:
        streams.setUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {
            // here you should examine the throwable/exception and perform an appropriate action!
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
