package no.agitec.fagaften.mellom.oppdrag.kafka.spring.online.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Producer
 * Define the KafkaSender class to send message to the kafka topic named as java_in_use-topic.
 */
@Service
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    String kafkaTopic = "java_in_use_topic";

    public void send(String message) {
        kafkaTemplate.send(kafkaTopic, message);
    }

}
