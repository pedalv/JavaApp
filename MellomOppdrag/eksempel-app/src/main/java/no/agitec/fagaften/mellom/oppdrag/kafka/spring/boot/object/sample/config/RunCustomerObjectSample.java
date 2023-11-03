package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.service.KafkaProducer;
import no.agitec.fagaften.mellom.oppdrag.repository.EmployeeRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://grokonez.com/spring-framework/spring-kafka/how-to-use-spring-kafka-jsonserializer-jsondeserializer-to-produceconsume-java-objects
 */
//@Configuration
@Slf4j
public class RunCustomerObjectSample {

    //@Autowired
    //KafkaProducer producer;

    @Bean
    public NewTopic jsaKafkaTopic() {
        return new NewTopic("jsa-kafka-topic", 1, (short) 1);
    }


    @Bean(name = "customerobjectsample")
    CommandLineRunner initDatabase(EmployeeRepository employ) {
        return (args) -> {

            log.info("GERE");
            /*
            // Send Mary customer
            Customer mary = new Customer("Mary", 31);
            producer.send(mary);

            // Send Peter customer
            Customer peter = new Customer("Peter", 24);
            producer.send(peter);

             */
        };
    }

}
