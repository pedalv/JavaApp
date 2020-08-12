package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.domain.*;
import no.agitec.fagaften.mellom.oppdrag.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@Slf4j
public class LoadDatabaseConfig {

    @Bean(name = "employee")
    CommandLineRunner initDatabase(EmployeeRepository employ) {
        return (args) -> {
            log.info("Preloading " + employ.save(new Employee("Carl", "Kristian Eriksen", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Francois", "Allix", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Frode", "Johansen", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Maria", "Selivanova", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Pedro", "Alves", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Runar", "Opsahl", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Steinar", "Haug", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Ståle", "Sannerud", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Torfinn", "Lie", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Thorleif", "Stene", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Andre", "Aubert", "Seniorutvikler")));
            log.info("Preloading " + employ.save(new Employee("Fred", "Inge Henden", "Seniorutvikler")));

            log.info("Preloading " + employ.save(new Employee("Bjørn", "Jåsund", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Aneela", "Liaquat", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Beatriz", "Perez", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Bjarne", "Stensrød", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Ingvild", "Frogner", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Nicholas", "Larsson", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Silje", "Eidsli", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Wenche", "Skavnes", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Lene", "Bråtesveen", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Kjell", "Nybråthen", "Leader")));
            log.info("Preloading " + employ.save(new Employee("Nina", "Olsen", "Administrasjon")));
            log.info("Preloading " + employ.save(new Employee("Stig", "Falste", "Leader")));

        };
    }

    @Bean(name = "customer")
    CommandLineRunner customer(CustomerRepository customers) {
        return (args) -> {
            // save a few customers
            customers.save(new Customer("NAV", "Automastisk Frikort"));
            customers.save(new Customer("Apotek 1", "Nagara"));
            customers.save(new Customer("Direktoratet for e-helse ", "Digital skjema RØF, TOD"));
            customers.save(new Customer("Garantikassen for fiskere", "GFF ELSAM 2015"));
            customers.save(new Customer("NAV/Helsedirektoratet", "KUKR/SAPO"));
            customers.save(new Customer("Senter for pasientmedvirkning og samhandlingsforskning (SPS)", "SpsWebPage, ReConnect-App og -Web"));
            customers.save(new Customer("Statnett", "Responsive desegn av internettløsning"));
            customers.save(new Customer("Norges Forskningsråd", "Forvaltning av nettsider prosjekter"));
            customers.save(new Customer("Gjensidige Forsikring", "Forvaltning"));
            customers.save(new Customer("A-Pressen Digital Medier (Amedia)", "Nettaviser, Zett.no"));
            customers.save(new Customer("More Software Solutions", "Digital Skjema"));
            customers.save(new Customer("UDP AS", "Involvert i et internt prosjekt"));

            // fetch all customers
            log.info("== Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customers.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Optional<Customer> customer = customers.findById(26L);
            //Customer customer = customers.findById(26L);
            log.info("== Customer found with findById(26L):");
            log.info("--------------------------------");
            customer.ifPresent(value -> log.info(value.toString()));
            //log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("== Customer found with findByProject('Nagara'):");
            log.info("--------------------------------------------");
            customers.findByProject("Nagara").forEach(c -> log.info(c.toString()));
            for (Customer c : customers.findByProject("Nagara")) {
              log.info(c.toString());
            }
            log.info("");
        };
    }


    @Bean(name = "partner")
    CommandLineRunner partner(PartnerRepository partners) {
        return (args) -> {
            // save a few partners
            partners.save(new Partner("Verama"));
            partners.save(new Partner("Centric"));
            partners.save(new Partner("Know IT"));
            partners.save(new Partner("EPICO-IT A/S"));
            partners.save(new Partner("Decisive"));
            partners.save(new Partner("Experis"));

            // fetch all partners
            log.info("== Partners found with findAll():");
            log.info("-------------------------------");
            for (Partner partner : partners.findAll()) {
                log.info(partner.toString());
            }
            log.info("");

            // fetch an individual partner by ID
            Optional<Partner> partner = partners.findById(37L);
            log.info("== Customer found with findById(37L):");
            log.info("--------------------------------");
            partner.ifPresent(value -> log.info(value.toString()));
            log.info("");

            // fetch partners by last name
            log.info("== Partner found with findByName('Centric'):");
            log.info("--------------------------------------------");
            partners.findByName("Centric").forEach(centric -> log.info(centric.toString()));
            for (Partner p : partners.findByName("Centric")) {
              log.info(p.toString());
            }
            log.info("");
        };
    }

    @Bean(name = "role")
    CommandLineRunner roles(RoleRepository roles) {
        return (args) -> {
            // save a few roles
            roles.save(new Role("USER"));
            roles.save(new Role("ADMIN"));

            // fetch all roles
            log.info("== Role found with findAll():");
            log.info("-------------------------------");
            for (Role role : roles.findAll()) {
                log.info(role.toString());
            }
            log.info("");

        };
    }

    @Bean(name = "user")
    CommandLineRunner user(UserRepository users) {
        return (args) -> {
            // save a few users
            users.save(new User("user", "password"));
            users.save(new User("admin", "password"));

            // fetch all users
            log.info("== User found with findAll():");
            log.info("-------------------------------");
            for (User user : users.findAll()) {
                log.info(user.toString());
            }
            log.info("");

        };
    }

}
