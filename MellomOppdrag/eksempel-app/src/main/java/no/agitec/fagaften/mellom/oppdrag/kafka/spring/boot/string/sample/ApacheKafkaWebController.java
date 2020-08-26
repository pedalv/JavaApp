package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.string.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka/string/")
public class ApacheKafkaWebController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        kafkaSender.send(message); //OKAY
        //kafkaSender.send(new String(message)); //OKAY

        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }

}