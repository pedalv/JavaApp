package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.service;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.model.Customer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage(Customer customer) {
        log.info("received content = " + customer);
        System.out.println("received content = " + customer);
    }

}
