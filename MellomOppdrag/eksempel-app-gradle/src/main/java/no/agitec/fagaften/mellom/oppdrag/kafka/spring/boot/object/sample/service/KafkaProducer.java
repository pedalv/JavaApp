package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.service;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    @Value("${jsa.kafka.topic}")
    String kafkaTopic = "jsa-test";

    public void send(Customer customer) {
        log.info("sending data=" + customer);
        System.out.println("sending data=" + customer);
        kafkaTemplate.send(kafkaTopic, customer);
    }

}
