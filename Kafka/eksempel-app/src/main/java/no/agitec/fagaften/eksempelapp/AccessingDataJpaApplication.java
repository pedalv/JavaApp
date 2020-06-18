package no.agitec.fagaften.eksempelapp;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.eksempelapp.domain.Customer;
import no.agitec.fagaften.eksempelapp.domain.Partner;
import no.agitec.fagaften.eksempelapp.repository.CustomerRepository;
import no.agitec.fagaften.eksempelapp.repository.PartnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@Slf4j
public class AccessingDataJpaApplication {

    @Bean(name = "customer")
    public CommandLineRunner customer(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("NAV", "Bauer"));
            repository.save(new Customer("Apotek 1", "O'Brian"));
            repository.save(new Customer("Direktoratet for e-helse ", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("== Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("== Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("== Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

    @Bean(name = "partner")
    public CommandLineRunner partner(PartnerRepository repository) {
        return (args) -> {
            // save a few partners
            repository.save(new Partner("Agitec"));
            repository.save(new Partner("Decisive"));
            repository.save(new Partner("Experis"));

            // fetch all partners
            log.info("== Partners found with findAll():");
            log.info("-------------------------------");
            for (Partner partner : repository.findAll()) {
                log.info(partner.toString());
            }
            log.info("");

            // fetch an individual partner by ID
            Optional<Partner> partner = repository.findById(1L);
            log.info("== Customer found with findById(1L):");
            log.info("--------------------------------");
            partner.ifPresent(value -> log.info(value.toString()));
            log.info("");

            // fetch partners by last name
            log.info("== Partner found with findByName('Agitec'):");
            log.info("--------------------------------------------");
            repository.findByName("Agitec").forEach(agitec -> log.info(agitec.toString()));
            // for (Partner agitec : repository.findByName("agitec")) {
            //  log.info(agitec.toString());
            // }
            log.info("");
        };
    }

}
