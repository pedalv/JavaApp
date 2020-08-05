package no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.controller.rest;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Bar1;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * sample-02 - multi-method listener
 * topics = { "foos", "bars" }
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
