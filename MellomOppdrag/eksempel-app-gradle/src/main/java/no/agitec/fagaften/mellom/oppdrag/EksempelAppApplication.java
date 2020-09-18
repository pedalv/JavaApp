package no.agitec.fagaften.mellom.oppdrag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * SpringBootApplication === @Configuration + @EnableAutoConfiguration + @ComponentScan
 *
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 *
 * @Configuration: Tags the class as a source of bean definitions for the application context.
 *
 * @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
 *
 * @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
 *
 */
@SpringBootApplication
@Slf4j
public class EksempelAppApplication {

	/**
	 *
	 * Caused by: java.lang.IllegalArgumentException:
	 * LoggerFactory is not a Logback LoggerContext but Logback is on the classpath.
	 * Either remove Logback or the competing implementation
	 * (class org.slf4j.impl.SimpleLoggerFactory loaded from
	 * file:/C:/Users/p/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-simple/1.7.30/e606eac955f55ecf1d8edcccba04eb8ac98088dd/slf4j-simple-1.7.30.jar).
	 *
	 * If you are using WebLogic you will need to add 'org.slf4j' to prefer-application-packages in
	 * WEB-INF/weblogic.xml: org.slf4j.impl.SimpleLoggerFactory
	 *
	 *
	 * @param args
	 */
	public static void main(String... args) {
		//SpringApplication.run(EksempelAppApplication.class, args);

		SpringApplication application = new SpringApplication(EksempelAppApplication.class);
		application.run(args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			log.info("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}


	/*
	//name: ben and password: benspassword --- NOT WORK => name: []
	//LADP: Ldap server does not run
	//Caused by:
	// org.springframework.beans.factory.UnsatisfiedDependencyException:
	// Error creating bean with name 'eksempelAppApplication':
	// Unsatisfied dependency expressed through field 'personLdapRepository';
	// nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException:
	// Error creating bean with name 'personLdapRepository':
	// Unsatisfied dependency expressed through field 'ldapTemplate';
	// nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException:
	// Error creating bean with name 'ldapTemplate' defined in class path resource
	// [org/springframework/boot/autoconfigure/ldap/LdapAutoConfiguration.class]:
	// Unsatisfied dependency expressed through method 'ldapTemplate' parameter 0;
	// nested exception is org.springframework.beans.factory.BeanCreationException:
	// Error creating bean with name 'directoryServer' defined in class path resource
	// [org/springframework/boot/autoconfigure/ldap/embedded/EmbeddedLdapAutoConfiguration.class]:
	// Bean instantiation via factory method failed;
	// nested exception is org.springframework.beans.BeanInstantiationException:
	// Failed to instantiate [com.unboundid.ldap.listener.InMemoryDirectoryServer]:
	// Factory method 'directoryServer' threw exception;
	// nested exception is LDAPException(resultCode=82 (local error),
	// errorMessage='An error occurred while attempting to start listener 'ldap':
	// BindException(Address already in use: bind),
	// ldapSDKVersion=4.0.14, revision=c0fb784eebf9d36a67c736d0428fb3577f2e25bb')

	@Autowired
	private PersonLdapRepository personLdapRepository;

	@PostConstruct
	public void setup(){
		log.info("Spring LDAP + Spring Boot Configuration Example");

		List<String> names = personLdapRepository.getAllPersonNames();
		log.info("names: " + names);

	}
	 */


}
