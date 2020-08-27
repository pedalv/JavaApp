package no.agitec.fagaften.mellom.oppdrag.web.controller;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.string.sample.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    @Autowired
    KafkaSender kafkaSender;

    @Value("${value.from.file}")
    private String valueFromFile;

    @ModelAttribute
    public void addKafkaModel(Model model) {
        log.info("== addKafkaModel");

        model.addAttribute("isSend", false);
    }

    @GetMapping()
    public String mainkafka(Model model) {
        log.info("== Kafka page!");
        return "kafka";
    }

    @GetMapping("/string")
    public String string( @RequestParam(name="message", required = false, defaultValue = "Kafka") String message,
                          Model model) {

        log.info("== Kafka String Sample");
        kafkaSender.send(message);
        model.addAttribute("isSend", true);

        return "kafka";
    }
}
