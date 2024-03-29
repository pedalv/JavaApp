package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.common.Bar2;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.common.Foo2;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.*;
import org.springframework.util.backoff.FixedBackOff;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * 5. Tips, Tricks and Examples: https://docs.spring.io/spring-kafka/docs/2.5.4.RELEASE/reference/html/#tips-n-tricks
 * ---
 * IMPORTANT TO RUN APPLICATION Zookeeper OG Kafka SERVER MUST BE RUNN
 * - kafka_2.12-2.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 * - kafka_2.12-2.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties
 * ---
 * log.dirs=/tmp/kafka-logs-online ==== server.properties
 *
 * FEIL:
 *  [2020-08-13 13:33:35,262] WARN [ReplicaManager broker=0] Broker 0 stopped fetcher for partitions
 *   and stopped moving logs for partitions  because they are in the failed log directory
 *   D:\tmp\kafka-logs-online. (kafka.server.ReplicaManager)
 *
 * SOLUTION:
 *  https://stackoverflow.com/questions/51644409/kafka-broker-fails-because-all-log-dirs-have-failed/57036581
 *
 */
@Configuration
@Slf4j
public class KafkaObjectSamplesConfig {

    // Sample 1
    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    // Sample 3
    private final static CountDownLatch LATCH = new CountDownLatch(1);

    // Sample 3
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    /**
     * Sample 1
     * Run one time only to create topic
     * @return
     */
    @Bean
    public NewTopic topic() {
        return new NewTopic("topic1", 1, (short) 1);
    }

    /**
     * Sample 1
     * Run one time only to create topic
     * @return
     */
    @Bean
    public NewTopic dlt() {
        return new NewTopic("topic1.DLT", 1, (short) 1);
    }

    /**
     * Sample 2
     * Run one time only to create topic
     * @return
     */
    @Bean
    public NewTopic foos() {
        return new NewTopic("foos", 1, (short) 1);
    }

    /**
     * Sample 2
     * @return
     */
    @Bean
    public NewTopic bars() {
        return new NewTopic("bars", 1, (short) 1);
        /*
        return TopicBuilder.name("bars")
                    .partitions(1)
                    .replicas(1)
                    .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                    .build();
        */
    }

    /**
     * Sample 3
     * Run one time only to create topic
     * @return
     */
    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("topic2").partitions(1).replicas(1).build();
    }

    /**
     * Sample 3
     * Run one time only to create topic
     * @return
     */
    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name("topic3").partitions(1).replicas(1).build();
    }

    /**
     * Sample 1 og 2
     * @param template
     * @return
     */
    @Bean
    public SeekToCurrentErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {
        return new SeekToCurrentErrorHandler(
                new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
    }

    /**
     * Sample 1 og 2
     *
     * @return
     */
    @Bean
    public ApplicationRunner runner() {
        return args -> {
            System.out.println("Hit Enter to terminate...");
            //System.in.read();
        };
    }

    /**
     * Sample 1
     * @param foo
     */
    @KafkaListener(id = "fooGroup", topics = "topic1")
    public void listen(Foo2 foo) {
        log.info("Received: " + foo);
        if (foo.getFoo().startsWith("fail")) {
            throw new RuntimeException("failed");
        }
        this.exec.execute(() -> System.out.println("Hit Enter to terminate topic1..."));
    }

    /**
     *  Sample 1
     * @param in
     */
    @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
    public void dltListen(String in) {
        log.info("Received from DLT: " + in);
        this.exec.execute(() -> System.out.println("Hit Enter to terminate topic1.DLT..."));
    }

    /**
     * Sample 3
     * @param foos
     * @throws IOException
     */
    @KafkaListener(id = "fooGroup2", topics = "topic2")
    public void listen1(List<Foo2> foos) /*throws IOException*/ {
        log.info("Received: " + foos);
        foos.forEach(f -> kafkaTemplate.send("topic3", f.getFoo().toUpperCase()));
        log.info("Messages sent, hit Enter to commit tx topic2");
        //System.in.read();
    }

    /**
     * Sample 3
     * @param in
     */
    @KafkaListener(id = "fooGroup3", topics = "topic3")
    public void listen2(List<String> in) {
        log.info("Received: " + in);
        LATCH.countDown();
    }

    /**
     * Sample 3
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaObjectSamplesConfig.class, args);
        LATCH.await();
        Thread.sleep(5_000);
        context.close();
    }

    /**
     * Sample 3
     * @return
     */
    @Bean
    public BatchMessagingMessageConverter batchConverter() {
        return new BatchMessagingMessageConverter(converter());
    }

    @Bean
    public RecordMessageConverter converter() {
        //Sample 1 og 3
        //return new StringJsonMessageConverter();

        //Sample 2
        /* */
        StringJsonMessageConverter converter = new StringJsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        typeMapper.addTrustedPackages("no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common");
        Map<String, Class<?>> mappings = new HashMap<>();
        mappings.put("foo", Foo2.class);
        mappings.put("bar", Bar2.class);
        typeMapper.setIdClassMapping(mappings);
        converter.setTypeMapper(typeMapper);
        return converter;

    }

}

 /*
    // OTHERS EXEMPLES: 4. Reference - https://docs.spring.io/spring-kafka/docs/2.5.4.RELEASE/reference/html/#reference


    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        configs.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        //Caused by: java.lang.IllegalArgumentException: Unknown class for built-in serializer. Supported types are: String, Short, Integer, Long, Float, Double, ByteArray, ByteBuffer, Bytes, UUID
        //  public static <T> org.apache.kafka.common.serialization.Serde<T> serdeFrom(java.lang.Class<T> type) { ... }
        //  public static <T> org.apache.kafka.common.serialization.Serde<T> serdeFrom(org.apache.kafka.common.serialization.Serializer<T> serializer, org.apache.kafka.common.serialization.Deserializer<T> deserializer) { ... }
        //  public static org.apache.kafka.common.serialization.Serde<java.lang.Long> Long() { ... }
        //  public static org.apache.kafka.common.serialization.Serde<java.lang.String> String() { ... }
        configs.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.serdeFrom(Foo1.class));
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new KafkaAdmin(configs);
        }

    // AdminClient client = AdminClient.create(admin.getConfigurationProperties());

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Serdes.String().getClass().getName()); //StringSerializer.class
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Serdes.Long().getClass().getName()); //LongSerializer.class
        // See https://kafka.apache.org/documentation/#producerconfigs for more properties
        return props;
    }

   @Bean
   public KafkaTemplate<Integer, String> kafkaTemplate() {
        return new KafkaTemplate<Integer, String>(producerFactory());
   }

   //--

    @Bean
    public KafkaTemplate<String, String> stringTemplate(ProducerFactory<String, String> pf) {
        return new KafkaTemplate<>(pf);
    }

    @Bean
    public KafkaTemplate<String, Foo1> bytesTemplate(ProducerFactory<String, Foo1> pf) {
        return new KafkaTemplate<>(pf,
                Collections.singletonMap(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Foo1.class));
    }


 */
