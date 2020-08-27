package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.Foo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FooConsumer {

    //@KafkaListener(topics = "${app.topic.example}")
    @KafkaListener(topics = "topic1", id = "topic1_ID")
    @SendTo // use default replyTo expression
    public void receive(@Payload Foo data,
                        @Headers MessageHeaders headers) {
        log.info("received data='{}'", data);

        headers.keySet().forEach(key -> log.info("{}: {}", key, headers.get(key)));

    }

}
