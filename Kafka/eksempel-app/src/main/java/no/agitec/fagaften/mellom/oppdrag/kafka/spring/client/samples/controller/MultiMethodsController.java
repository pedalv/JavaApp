package no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.controller;

import no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Bar2;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.client.samples.common.Foo2;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "multiGroup", topics = { "foos", "bars" })
public class MultiMethodsController {

    @KafkaHandler
    public void foo(Foo2 foo) {
        System.out.println("Received: " + foo);
    }

    @KafkaHandler
    public void bar(Bar2 bar) {
        System.out.println("Received: " + bar);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Received unknown: " + object);
    }

}
