package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.domain.Employee;
import no.agitec.fagaften.mellom.oppdrag.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean(name = "employee")
    CommandLineRunner initDatabase(EmployeeRepository employ) {
        return args -> {
            log.info("Preloading " + employ.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + employ.save(new Employee("Frodo", "Baggins", "thief")));
        };
    }

}
