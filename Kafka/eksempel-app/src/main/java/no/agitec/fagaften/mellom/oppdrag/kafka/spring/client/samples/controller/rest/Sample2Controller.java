package no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.controller.rest;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Bar1;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sample-02 - multi-method listener
 *
 * topics = { "foos", "bars" }
 *
 * Sample 2
 * This sample demonstrates a simple producer and a multi-method consumer;
 *  the producer sends objects of types Foo1 and Bar1
 *  and the consumer receives objects of type Foo2 and Bar2 (the objects have the same field, foo).
 *
 * The producer uses a JsonSerializer;
 *  the consumer uses the StringDeserializer that is automatically configured by Spring Boot,
 *  together with a StringJsonMessageConverter which converts to the required type of the listener method argument.
 * We can’t infer the type in this case (because the type is used to choose the method to call).
 * We therefore configure type mapping on the producer and consumer side.
 * See the application.yml for the producer side and the converter bean on the consumer side.
 *
 * The MultiMethods @KafkaListener has 3 methods;
 *  one for each of the known objects
 *  and a fallback default method for others.
 *
 * Run the application and use curl to send some data:
 *
 * $ curl -X GET http://localhost:8080/kafka/sample2/send/foo/bar
 *
 * $ curl -X GET http://localhost:8080/kafka/sample2/send/bar/baz
 *
 * $ curl -X GET http://localhost:8080/kafka/sample2/send/unknown/xxx
 *                http://localhost:8080/kafka/sample2/send/unknown/bbbbb
 *
 * Console:
 * Received: Foo2 [foo=bar] Received: Bar2 [bar=baz] Received unknown: xxx
 *
 */
@RestController
@RequestMapping("/kafka/sample2")
@Slf4j
public class Sample2Controller {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping(path = "/send/foo/{what}")
    //@PostMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        this.template.send("foos", new Foo1(what));
    }

    @GetMapping(path = "/send/bar/{what}")
    //@PostMapping(path = "/send/foo/{what}")
    public void sendBar(@PathVariable String what) {
        this.template.send("bars", new Bar1(what));
    }

    @GetMapping(path = "/send/unknown/{what}")
    //@PostMapping(path = "/send/foo/{what}")
    public void sendUnknown(@PathVariable String what) {
        this.template.send("bars", what);
    }

}
