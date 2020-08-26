package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.string.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * For å sende og motta beskje ved Spring Kafka
 *
 * - Begynne zookeeper og kafka tjeneste
 * .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 * .\bin\windows\kafka-server-start.bat .\config\server.properties
 * 1. SpringApacheKafkaApplicationConfig
 * - Opprett topic
 * - MessagingMessageConverter
 * 2. KafkaSender (Producer)
 * 3. KafkaConsumer
 *
 * - Resultat
 * curl -X GET http://localhost:8080/kafka/string/producer?message=test
 * 2020-08-26 16:00:00.791  INFO 11884 --- [nio-8080-exec-3] n.a.f.m.o.k.s.b.s.sample.KafkaSender     : #### -> Producing message -> test
 * 2020-08-26 16:00:00.795  INFO 11884 --- [eTopic_ID-0-C-1] n.a.f.m.o.k.s.b.s.sample.KafkaConsumer   : #### -> Consumed message -> test
 *
 */
@RestController
@RequestMapping(value = "/kafka/string/")
public class ApacheKafkaWebController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        kafkaSender.send(message); //OKAY
        //kafkaSender.send(new String(message)); //OKAY

        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }

}
