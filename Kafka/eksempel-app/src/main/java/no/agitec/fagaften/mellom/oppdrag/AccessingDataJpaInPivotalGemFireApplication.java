package no.agitec.fagaften.mellom.oppdrag;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.domain.Person;
import no.agitec.fagaften.mellom.oppdrag.repository.PersonRepository;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import static java.util.Arrays.asList;

@ClientCacheApplication(name = "AccessingDataGemFireApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = Person.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
@Slf4j
public class AccessingDataJpaInPivotalGemFireApplication {

    @Bean(name = "person")
    ApplicationRunner run(PersonRepository personRepository) {

        return args -> {

            Person alice = new Person("Adult Alice", 40);
            Person bob = new Person("Baby Bob", 1);
            Person carol = new Person("Teen Carol", 13);

            log.info("== Before accessing data in Pivotal GemFire...");
            log.info("-------------------------------");
            asList(alice, bob, carol).forEach(person -> System.out.println("\t" + person));

            log.info("");

            log.info("== Saving Alice, Bob and Carol to Pivotal GemFire...");
            personRepository.save(alice);
            personRepository.save(bob);
            personRepository.save(carol);
            log.info("== Lookup each person by name...");
            log.info("-------------------------------");
            asList(alice.getName(), bob.getName(), carol.getName())
                    .forEach(name -> System.out.println("\t" + personRepository.findByName(name)));

            log.info("");

            log.info("== Query adults (over 18):");
            log.info("-------------------------------");
            personRepository.findByAgeGreaterThan(18).forEach(person -> System.out.println("\t" + person));

            log.info("");

            log.info("== Query babies (less than 5):");
            log.info("-------------------------------");
            personRepository.findByAgeLessThan(5).forEach(person -> System.out.println("\t" + person));

            log.info("");

            log.info("== Query teens (between 12 and 20):");
            log.info("-------------------------------");
            personRepository.findByAgeGreaterThanAndAgeLessThan(12, 20).forEach(person -> System.out.println("\t" + person));

            log.info("");

            log.info("== Query all persons:");
            log.info("-------------------------------");
            personRepository.findAll().forEach(person -> System.out.println("\t" + person.toString()));

        };
    }

}
