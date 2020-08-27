package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.SimpleKafkaHeaderMapper;
import org.springframework.kafka.support.converter.MessagingMessageConverter;

@Configuration
@Slf4j
public class KafkaStringSampleConfig {

    /*******************************************************************************************************************
     STRING SAMPLE: no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.string.sample
     ******************************************************************************************************************/

    @Bean
    public NewTopic javaInUseTopic() {
        return new NewTopic("java_in_use_topic", 1, (short) 1);
    }

    /**
     * KafkaListener
     *
     * @return
     */
    @Bean // not required if Jackson is on the classpath
    public MessagingMessageConverter simpleMapperConverter() {
        MessagingMessageConverter messagingMessageConverter = new MessagingMessageConverter();
        messagingMessageConverter.setHeaderMapper(new SimpleKafkaHeaderMapper());
        return messagingMessageConverter;
    }


}
