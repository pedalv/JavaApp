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

}
