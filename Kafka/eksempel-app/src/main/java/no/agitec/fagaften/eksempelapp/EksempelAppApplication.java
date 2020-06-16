package no.agitec.fagaften.eksempelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EksempelAppApplication {

	public static void main(String... args) {
		//SpringApplication.run(EksempelAppApplication.class, args);

		SpringApplication application = new SpringApplication(EksempelAppApplication.class);
		application.run(args);
		
	}

}
