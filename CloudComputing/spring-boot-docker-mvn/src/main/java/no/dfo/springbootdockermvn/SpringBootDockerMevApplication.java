package no.dfo.springbootdockermvn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDockerMevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerMevApplication.class, args);
	}

}

/*

	java -jar target/spring-boot-docker-mvn-0.0.1-SNAPSHOT.jar

	docker build -t pedalv/spring-boot-docker .


	https://stackoverflow.com/questions/53375613/why-is-the-java-11-base-docker-image-so-large-openjdk11-jre-slim
	openjdk:8-jre-alpine: 84 MB
	openjdk:11-jre-slim: 283 MB

 */