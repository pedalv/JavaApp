package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.controller.rest;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  sample-01 - simple producer/consumer with dead-letter topic
 *
 *  topics = { "topic1", "topic1.DLT" } === @KafkaListener(id = "fooGroup", topics = "topic1")
 *                                      === @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
 *
 * Sample 1
 * This sample demonstrates a simple producer and consumer;
 *  the producer sends objects of type Foo1
 *  and the consumer receives objects of type Foo2 (the objects have the same field, foo).
 *
 * The producer uses a JsonSerializer;
 *  the consumer uses the StringDeserializer that is automatically configured by Spring Boot,
 *  together with a StringJsonMessageConverter which converts to the type of the listener method argument.
 *
 * Run the application and use curl to send some data:
 *
 * $ curl -X GET http://localhost:8080/kafka/sample1/send/foo/bar
 *
 * Console:
 * 2018-11-05 10:03:40.216 INFO 39766 --- [ fooGroup-0-C-1] com.example.Application : Received: Foo2 [foo=bar]
 *
 * The consumer is configured with a SeekToCurrentErrorHandler
 *  which replays failed messages up to 2 times,
 *  each after a 1 second delay and, after retries are exhausted, sends a bad message to a dead-letter topic.
 *
 * $ curl -X GET http://localhost:8080/kafka/sample1/send/foo/fail
 *
 * A second @KafkaListener consumes the raw JSON from the message.
 * 2018-11-05 10:12:32.552 INFO 41635 --- [ fooGroup-0-C-1] com.example.Application :
 *  Received: Foo2 [foo=fail] 2018-11-05 10:12:32.561
 *  ERROR 41635 --- [ fooGroup-0-C-1] essageListenerContainer$ListenerConsumer :
 *  Error handler threw an exception …​2018-11-05 10:12:33.033 INFO 41635
 *  --- [ fooGroup-0-C-1] com.example.Application : Received: Foo2 [foo=fail] 2018-11-05 10:12:33.033 ERROR 41635
 *  --- [ fooGroup-0-C-1] essageListenerContainer$ListenerConsumer :
 *  Error handler threw an exception …​2018-11-05 10:12:33.537 INFO 41635
 *  --- [ fooGroup-0-C-1] com.example.Application : Received: Foo2 [foo=fail] 2018-11-05 10:12:43.359 INFO 41635
 *  --- [ dltGroup-0-C-1] com.example.Application : Received from DLT: {"foo":"fail"}
 */
@RestController
@RequestMapping("/kafka/sample1")
@Slf4j
public class ProducerSample1Controller {

    @Autowired
    KafkaObjectSender kafkaObjectSender;

    @Autowired
    //private KafkaTemplate<Object, Object> template; //okay
    private KafkaTemplate<String, Object> template; //okay
    //private KafkaTemplate<String, Foo1> template;

    private String kafkaTopic = "topic1";

    @GetMapping(path = "/send/foo/{what}")
    //@PostMapping(path = "/send/foo/{what}")
    public String sendFoo(@PathVariable String what) {

        kafkaObjectSender.sendOkay(what); //OKAY in consumer
        kafkaObjectSender.sendFail(new Foo1(what)); // Foo1 cannot be cast to class java.lang.String
        //return "Message sent to the Kafka Topic topic1 Successfully";

        try {
            //ProducerRecord record = new ProducerRecord(kafkaTopic, new Foo1(what));
            //this.template.send(record);

            this.template.send(kafkaTopic, new Foo1(what));

            return "Message sent to the Kafka Topic topic1 Successfully";
        } catch (Exception e)  {
            log.error(e.getMessage());
            e.getStackTrace();

            //Can't convert value of class no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1
            // to class org.apache.kafka.common.serialization.StringSerializer specified in value.serializer
            // String String : Default - Serdes.String() Serdes.String()
            // String Integer: Serdes.String() Serdes.Long()
            // String Object: Serdes.String() Serdes.serdeFrom(Foo1.class) - How to change it(???)
            // String Foo1: Serdes.String() Serdes.serdeFrom(Foo1.class) - How to change it(???)
        }

        return "Message did not sent to the Kafka Topic topic1!?!";
    }

    @GetMapping(path = "/send/foo2/{what}")
    public String sendFoo2(@PathVariable String what) {

        this.template.send(kafkaTopic, what); //OKAY in consumer but errors in console med @Bean
        return "Message sent to the Kafka Topic topic1 Successfully";

        /*
            //Error in console
            2020-08-07 13:11:56.826 ERROR 15820 --- [ fooGroup-0-C-1] essageListenerContainer$ListenerConsumer : Error handler threw an exception

            org.springframework.kafka.KafkaException: Seek to current after exception;
                nested exception is org.springframework.kafka.listener.ListenerExecutionFailedException:
                    Listener failed; nested exception is org.springframework.kafka.support.converter.ConversionException:
                        Failed to convert from JSON; nested exception is com.fasterxml.jackson.core.JsonParseException:
                            Unrecognized token 'bar5':
                                was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
                                    at [Source: (String)"bar5"; line: 1, column: 5]
         */
    }

}





