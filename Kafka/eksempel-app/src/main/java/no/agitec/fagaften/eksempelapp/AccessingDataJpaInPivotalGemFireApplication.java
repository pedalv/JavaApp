package no.agitec.fagaften.eksempelapp;

import no.agitec.fagaften.eksempelapp.domain.Person;
import no.agitec.fagaften.eksempelapp.repository.PersonRepository;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import static java.util.Arrays.asList;

@ClientCacheApplication(name = "AccessingDataGemFireApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = Person.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
public class AccessingDataJpaInPivotalGemFireApplication {

    @Bean
    ApplicationRunner run(PersonRepository personRepository) {

        return args -> {

            Person alice = new Person("Adult Alice", 40);
            Person bob = new Person("Baby Bob", 1);
            Person carol = new Person("Teen Carol", 13);

            System.out.println("Before accessing data in Pivotal GemFire...");

            asList(alice, bob, carol).forEach(person -> System.out.println("\t" + person));

            System.out.println("Saving Alice, Bob and Carol to Pivotal GemFire...");

            personRepository.save(alice);
            personRepository.save(bob);
            personRepository.save(carol);

            System.out.println("Lookup each person by name...");

            asList(alice.getName(), bob.getName(), carol.getName())
                    .forEach(name -> System.out.println("\t" + personRepository.findByName(name)));

            System.out.println("Query adults (over 18):");
            personRepository.findByAgeGreaterThan(18).forEach(person -> System.out.println("\t" + person));

            System.out.println("Query babies (less than 5):");
            personRepository.findByAgeLessThan(5).forEach(person -> System.out.println("\t" + person));

            System.out.println("Query teens (between 12 and 20):");
            personRepository.findByAgeGreaterThanAndAgeLessThan(12, 20).forEach(person -> System.out.println("\t" + person));

        };
    }

}
