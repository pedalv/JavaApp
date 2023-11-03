package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaObjectConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "topic1", id = "fooTopic1_ID")
    @SendTo // use default replyTo expression
    public void consume(String jsonString)  {
        Foo1 foo = null;
        if(jsonString.contains("foo")) {
            try {
                foo = objectMapper.readerFor(Foo1.class).readValue(jsonString); //OKAY
                foo = objectMapper.readValue(jsonString, Foo1.class); //OKAY
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        log.info(String.format("#### -> Consumed (OBJECT) message -> %s", jsonString));
    }


}
