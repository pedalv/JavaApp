package no.agitec.fagaften.mellom.oppdrag.kafka.spring.online.sample;

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
public class KafkaSender {

    @Autowired
    //private KafkaTemplate<String, String> kafkaTemplate; //OKAY
    private KafkaTemplate<String, Object> kafkaTemplate; //OKAY

    String kafkaTopic = "java_in_use_topic";

    public void send(String message) {
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