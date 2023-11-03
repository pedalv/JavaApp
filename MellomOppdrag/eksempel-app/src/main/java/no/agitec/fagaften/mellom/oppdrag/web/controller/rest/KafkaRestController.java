package no.agitec.fagaften.mellom.oppdrag.web.controller.rest;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.string.sample.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@Slf4j
public class KafkaRestController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping("/string")
    public ResponseEntity<?> string(@RequestParam(name="message", required = false, defaultValue = "Kafka") String message) {

        log.info("== API Kafka String Sample");
        kafkaSender.send(message);

        return ResponseEntity.ok().build();
    }

}
