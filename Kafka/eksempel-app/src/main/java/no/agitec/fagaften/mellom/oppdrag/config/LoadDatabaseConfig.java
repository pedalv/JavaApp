package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.domain.*;
import no.agitec.fagaften.mellom.oppdrag.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
public class LoadDatabaseConfig {

    @Bean(name = "employee")
    CommandLineRunner initDatabase(EmployeeRepository employ) {
        return (args) -> {
            log.info("Preloading " + employ.saveAndFlush(new Employee("Carl", "Kristian Eriksen", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Francois", "Allix", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Frode", "Johansen", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Maria", "Selivanova", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Pedro", "Alves", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Runar", "Opsahl", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Steinar", "Haug", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Ståle", "Sannerud", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Torfinn", "Lie", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Thorleif", "Stene", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Andre", "Aubert", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Fred", "Inge Henden", "Seniorutvikler")));

            log.info("Preloading " + employ.saveAndFlush(new Employee("Bjørn", "Jåsund", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Aneela", "Liaquat", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Beatriz", "Perez", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Bjarne", "Stensrød", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Ingvild", "Frogner", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Nicholas", "Larsson", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Silje", "Eidsli", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Wenche", "Skavnes", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Lene", "Bråtesveen", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Kjell", "Nybråthen", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Nina", "Olsen", "Administrasjon")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Stig", "Falste", "Leader")));

        };
    }

    @Bean(name = "customer")
    CommandLineRunner customer(CustomerRepository customers) {
        return (args) -> {
            // save a few customers
            customers.saveAndFlush(new Customer("NAV", "Automastisk Frikort"));
            customers.saveAndFlush(new Customer("Apotek 1", "Nagara"));
            customers.saveAndFlush(new Customer("Direktoratet for e-helse ", "Digital skjema RØF, TOD"));
            customers.saveAndFlush(new Customer("Garantikassen for fiskere", "GFF ELSAM 2015"));
            customers.saveAndFlush(new Customer("NAV/Helsedirektoratet", "KUKR/SAPO"));
            customers.saveAndFlush(new Customer("Senter for pasientmedvirkning og samhandlingsforskning (SPS)", "SpsWebPage, ReConnect-App og -Web"));
            customers.saveAndFlush(new Customer("Statnett", "Responsive desegn av internettløsning"));
            customers.saveAndFlush(new Customer("Norges Forskningsråd", "Forvaltning av nettsider prosjekter"));
            customers.saveAndFlush(new Customer("Gjensidige Forsikring", "Forvaltning"));
            customers.saveAndFlush(new Customer("A-Pressen Digital Medier (Amedia)", "Nettaviser, Zett.no"));
            customers.saveAndFlush(new Customer("More Software Solutions", "Digital Skjema"));
            customers.saveAndFlush(new Customer("UDP AS", "Involvert i et internt prosjekt"));

            // fetch all customers
            log.info("== Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customers.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Optional<Customer> customer = customers.findById(0L);
            //Customer customer = customers.findById(0L);
            log.info("== Customer found with findById(0L):");
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
    @Order(1)
    CommandLineRunner roles(RoleRepository roles) {
        return (args) -> {
            // save a few roles
            roles.saveAndFlush(new Role("USER"));
            roles.saveAndFlush(new Role("ADMIN"));

            // fetch all roles
            log.info("== Role found with findAll():");
            log.info("-------------------------------");
            for (Role role : roles.findAll()) {
                log.info(role.toString());
            }
            log.info("");
            // fetch roles by name
            log.info("== Role found with findByRoleName('USER'):");
            log.info("-------------------------------");
            for (Role role : roles.findByRoleName("USER")) {
                log.info(role.toString());
            }
            log.info("");
        };
    }

    @Bean(name = "user")
    @Order(2)
    CommandLineRunner user(UserRepository users, RoleRepository roles, UserRoleRepository userroles) {
        return (args) -> {
            User u;
            UserRole ur;
            Long userId;
            Long rolerId;

            // save a few users

            //u = new User("user", "password", roleUser);
            u = new User("user", "password");
            u = users.saveAndFlush(u);
            userId = u.getUserId();
            List<Role> roleUser = roles.findByRoleName("USER");
            rolerId = roleUser.get(0).getRoleId();
            log.info("userId: " + userId + ", rolerId: " + rolerId);
            ur = new UserRole(userId, rolerId);
            userroles.saveAndFlush(ur);

            //u = new User("admin", "password", roleAdmin);
            u = new User("admin", "password");
            u = users.saveAndFlush(u);
            userId = u.getUserId();
                log.info("userId: " + userId + ", rolerId: " + rolerId);
                ur = new UserRole(userId, rolerId);
                userroles.saveAndFlush(ur);
            List<Role> roleAdmin = roles.findByRoleName("ADMIN");
            rolerId = roleAdmin.get(0).getRoleId();
            log.info("userId: " + userId + ", rolerId: " + rolerId);
            ur = new UserRole(userId, rolerId);
            userroles.saveAndFlush(ur);

            // fetch all users
            log.info("== User found with findAll():");
            log.info("-------------------------------");
            for (User user : users.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch all UserRole
            log.info("== UserRole found with findAll():");
            log.info("-------------------------------");
            for (UserRole userroler : userroles.findAll()) {
                log.info(userroler.toString());
            }
            log.info("");

        };
    }

}
