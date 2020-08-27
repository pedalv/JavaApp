package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.controller.rest;

import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * sample-03 - transactions
 *
 *
 *
 * Sample 3
 * This sample demonstrates the use of transactions,
 *  including container-managed transactions on the consumer side.
 * The listener receives a batch of messages
 *  and sends them to another topic, all within one transaction.
 *
 * Run the application and use curl to send some data:
 *
 * $ curl -X GET http://localhost:8080/kafka/sample3/send/foos/a,b,c,d,e
 *
 * Console:
 * 2018-11-05 11:50:29.244 INFO 60437 --- [fooGroup2-0-C-1] com.example.Application :
 *  Received: [Foo2 [foo=a], Foo2 [foo=b], Foo2 [foo=c], Foo2 [foo=d], Foo2 [foo=e]]
 * 2018-11-05 11:50:29.247 INFO 60437 --- [fooGroup2-0-C-1] com.example.Application :
 *  Messages sent, hit enter to commit tx
 * 2018-11-05 11:50:33.045 INFO 60437 --- [fooGroup3-0-C-1] com.example.Application :
 *  Received: [A, B, C, D, E]
 *
 */
@RestController
@RequestMapping("/kafka/sample3")
public class ProducerSample3Controller {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    private String kafkaTopic = "topic2";

    @GetMapping(path = "/send/foos/{what}")
    //@PostMapping(path = "/send/foos/{what}")
    public String sendFoo(@PathVariable String what) {
        this.template.executeInTransaction(
                kafkaTemplate -> {
                    StringUtils.commaDelimitedListToSet(what)
                            .stream()
                            .map(Foo1::new) // === .map(s -> new Foo1(s))
                            .forEach(foo -> kafkaTemplate.send(kafkaTopic, foo));
                    return "Message sent to the Kafka Topic topic2 Successfully";
                });
        return "Message sent to the Kafka Topic topic2 Successfully";
    }

}
