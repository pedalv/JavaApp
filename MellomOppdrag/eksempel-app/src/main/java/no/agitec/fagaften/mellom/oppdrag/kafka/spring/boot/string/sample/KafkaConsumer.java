package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.string.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "java_in_use_topic", id = "JavaInUseTopic_ID")
    @SendTo // use default replyTo expression
    public void consume(String message)  {
        log.info(String.format("#### -> Consumed message -> %s", message));
    }

}