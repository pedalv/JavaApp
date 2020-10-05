package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.string.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Producer
 * Define the KafkaSender class to send message to the kafka topic named as java_in_use-topic.
 *
 * Message work okay for type string
 */
@Service
@Slf4j
public class KafkaSender {

    @Autowired
    //private KafkaTemplate<String, String> kafkaTemplate; //OKAY
    private KafkaTemplate<String, Object> kafkaTemplate; //OKAY

    private static final String kafkaTopic = "java_in_use_topic";

    public void send(String message) {
        log.info(String.format("#### -> Producing message -> %s", message));
        kafkaTemplate.send(kafkaTopic, message);
    }

}


/*
TIPS

ConnectionFactory - speak with Broker
ProducerFactory - see Sending Messages
ConsumerFactory - see Receiving Messages
KafkaAdmin - see Configuring Topics
 */