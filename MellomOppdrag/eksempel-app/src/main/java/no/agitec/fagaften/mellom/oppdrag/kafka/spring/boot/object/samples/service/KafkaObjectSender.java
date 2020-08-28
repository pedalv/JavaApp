package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.service;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Producer
 * Define the KafkaSender class to send message to the kafka topic named as java_in_use-topic.
 *
 * Goal:
 * - Send and receive messagem without CMD
 * - Send message via a form: GET, the message is an Object of type Foo1 in Producer
 * - Received message sendt: KafkaListener in consumer
 *
 * Fail:
 * - send (Producer): Can't convert value of class
 *  no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1 to class org.apache.kafka.common.serialization.StringSerializer
 *  - received (Consumer):  Failed to convert from JSON; nested exception is com.fasterxml.jackson.core.JsonParseException: Unrecognized token 'bar5':
 *      Maybe because is wait for receive Foo1 object (bar5 is a String) and return Foo2 object
 *
 * Solution
 * -  kafkaTemplate.send(kafkaTopic, message): looks like is only possible send those types
 *         Serdes.String()
 *         Serdes.Long()
 *         Serdes.ByteArray() //Object
 *         Serdes.ByteBuffer() //Object
 *         Serdes.Double()
 *         Serdes.Integer()
 *         Serdes.Float()
 *         Serdes.Short()
 *         Serdes.UUID()
 *         Serdes.serdeFrom(...) //Object
 *         // String String : Default - Serdes.String() Serdes.String()
 *         // String Integer: Serdes.String() Serdes.Long()
 *         // String Object: Serdes.String() Serdes.serdeFrom(Foo1.class) - How to change it(???)
 *         // String Foo1: Serdes.String() Serdes.serdeFrom(Foo1.class) - How to change it(???)
 *
 * Future
 * - If Producer is a Object som Class, File, Json === How to send a message type object without CMD ?!?
 * See PageViewTypedDemo.java class in package no.agitec.fagaften.mellom.oppdrag.kafka.quickstart.streams.examples.pageview
 * - How get message received in Consumer without CMD === How to receive a message without CMD ?!?
 * See Spring for Apache Kafka about KafkaListener
 *
 * See WordCountDemo.java class in package no.agitec.fagaften.mellom.oppdrag.kafka.quickstart.streams.examples.wordcount
 *  to see information send and received with CMD (in createWordCountStream method)
 */
@Service
@Slf4j
public class KafkaObjectSender {
    @Autowired
    //private KafkaTemplate<Object, Object> template; //ERROR (Foo1) - OKAY (String)
    private KafkaTemplate<String, Object> kafkaTemplate; //ERROR (Foo1) - OKAY (String)
    //private KafkaTemplate<String, Foo1> kafkaTemplate; //ERROR (Foo1)

    @Autowired
    private KafkaTemplate<String, Foo1> kafkaTemplateObj;

    @Value("${kafka.topic.object}")
    private String kafkaTopicObject;

    //private String kafkaTopic = "java_in_use_topic";
    private String kafkaTopic = "topic1";

    /**
     *  public
     *      org.springframework.util.concurrent.ListenableFuture<org.springframework.kafka.support.SendResult<K,V>>
     *          send(java.lang.String topic, @org.springframework.lang.Nullable V data) { ... }
     * @param message
     */
    public void sendOkay(String message) {
        log.info(String.format("#### -> Producing String message -> %s", message));
        kafkaTemplate.send(kafkaTopic, message);
    }

    /**
     *         //"error":"Internal Server Error",
     *         //"trace":"org.apache.kafka.common.errors.SerializationException:
     *         // Can't convert value of class no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1
     *         // to class org.apache.kafka.common.serialization.StringSerializer
     *         // specified in value.serializer\r\nCaused by: java.lang.ClassCastException:
     *         // class no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1
     *         // cannot be cast to class java.lang.String
     *         // (no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1
     *         // is in unnamed module of loader org.springframework.boot.devtools.restart.
     *
     *   public
     *      org.springframework.util.concurrent.ListenableFuture<org.springframework.kafka.support.SendResult<K,V>>
     *          send(java.lang.String topic, @org.springframework.lang.Nullable V data) { ... }
     *
     *
     * @param message
     */
    public void sendFail(Foo1 data) {
        log.info("#### -> Producing object message for sending data='{}' to topic='{}'", data, kafkaTopic);

        Message<Foo1> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build();

        kafkaTemplate.send(message);

        //kafkaTemplate.send(kafkaTopic, message); //Foo1 cannot be cast to class java.lang.String

        //Solution: https://www.baeldung.com/jackson-object-mapper-tutorial
        //kafkaTemplate.send(kafkaTopic, objectMapper.writeValueAsString(message));

    }

    /*
    //https://www.baeldung.com/jackson-object-mapper-tutorial

    ObjectMapper objectMapper = new ObjectMapper();
    Car car = new Car("yellow", "renault");
    //Object to String
    String carAsString = objectMapper.writeValueAsString(car); ////{"color":"yellow","type":"renault"}

    //String til Object
    String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
    Car car = objectMapper.readValue(json, Car.class);


    //Spring Segurity
    private final ObjectMapper objectMapper;
    objectMapper.writeValueAsString(message)
     */


}
