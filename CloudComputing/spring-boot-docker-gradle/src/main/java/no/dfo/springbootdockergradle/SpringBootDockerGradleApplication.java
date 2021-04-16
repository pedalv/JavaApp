package no.dfo.springbootdockergradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDockerGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerGradleApplication.class, args);
	}

}

/*

	java -jar target/spring-boot-docker-mvn-0.0.1-SNAPSHOT.jar

	docker build --build-arg JAR_FILE=build/libs/\*.jar -t pedalv/spring-boot-docker-gradle .
	// How create libs with Gradle === gradle build

	docker build -t pedalv/spring-boot-docker-gradle .
  	docker run -p 8080:8080 pedalv/spring-boot-docker-gradle
	curl http://localhost:8080 === Hello Docker World With Gradle

  	docker push pedalv/spring-boot-docker-gradle

  	docker pull pedalv/spring-boot-docker-gradle
  	docker run -p 8080:8080 pedalv/spring-boot-docker-gradle
  	curl http://localhost:8080/

*/

/*

	https://stackoverflow.com/questions/53375613/why-is-the-java-11-base-docker-image-so-large-openjdk11-jre-slim
	openjdk:8-jre-alpine: 84 MB
	openjdk:11-jre-slim: 283 MB

 */