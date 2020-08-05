package no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.controller.rest;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  sample-01 - simple producer/consumer with dead-letter topic
 *  topics = { "topic1", "topic1.DLT" } === @KafkaListener(id = "fooGroup", topics = "topic1")
 *                                      === @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
 */
@RestController
@RequestMapping("/kafka/sample1")
@Slf4j
public class Sample1Controller {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping(path = "/send/foo/{what}")
    //@PostMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        this.template.send("topic1", new Foo1(what));
    }

}
