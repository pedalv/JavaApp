package no.agitec.fagaften.eksempelapp.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.eksempelapp.domain.Employee;
import no.agitec.fagaften.eksempelapp.repository.EmployeeRepository;
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
