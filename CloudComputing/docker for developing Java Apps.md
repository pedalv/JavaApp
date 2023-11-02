# Developing Java Apps with Docker
- Hello.java

```
#LINUX
docker run -v ${PWD}:/hello -w /hello eclipse-temurin:17 javac Hello.Java -> Hello.class
docker run -v ${PWD}:/hello -w /hello eclipse-temurin:17 java Hello -> Hello World

docker run -v $(pwd)/certs:/certificates/ -e USE_SYSTEM_CA_CERTS=1 eclipse-temurin:17

#WINDOWS
docker run -v %cd%:/hello -w /hello eclipse-temurin:17 javac Hello.Java
```

```
docker images
docker container ls -a
docker run --rm
docker system prune -a === delete all stop containers
```

## Dockerfile
- eclipse-temurin:<version>
- eclipse-temurin:<version>-alpine
- eclipse-temurin:<version>-windowsservercore

- vim jar.Dockerfile 
```
FROM eclipse-temurin:17
RUN mkdir /app
#RUN ["executable", "param1", "param2"]
WORKDIR /app
COPY api.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

docker build -f jar.Dockerfile -t my-api .

docker run -p 9000:8080 -it --rm my-api
```

- vim web.Dockerfile
```
FROM tomcat:10
COPY web.war ${CATALINA_HOME}/webapps/ROOT.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]

docker build -f web.Dockerfile -t  my-web-app .

docker run -p 9001:8080 -it --rm my-web-app
```

- vim maven.Dockerfile
```
FROM maven:3.9-eclipse-temurin-17
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src src
RUN mvn package
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/api.jar"]

docker build -f maven.Dockerfile -t  my-api-maven .

docker run -p 9010:8080 -it --rm my-api-maven
docker run -p 9010:8080 -it --rm my-api-maven:v2
```

```
docker run --rm -it \
    -v ${PWD}:/app \
    -v ${HOME}/.m2:/root/.m2 \
    -w /app \
    maven:3.9-eclipse-temurin-17 \

docker run --rm -it -v ${PWD}:/app -v ${HOME}/.m2:/root/.m2 -w /app maven:3.9-eclipse-temurin-17 
docker run --rm -it -v %cd%:/app -v ${HOME}/.m2:/root/.m2 -w /app maven:3.9-eclipse-temurin-17

mvn clean packege
```  

- vim gradle.Dockerfile
```
FROM gradle:8.0-jdk17
WORKDIR /app
RUN chown -R gradle:gradle /app
USER gradle
COPY build.gradle .
COPY src src
RUN gradle build
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/api.jar"]

docker build -f gradle.Dockerfile -t  my-api-gradle .

docker run -p 9011:8080 -it --rm my-api-gradle
docker volume ls
```

```
docker run --rm -it \
    -u gradle \
    -v ${PWD}:/app \
    -v ${HOME}/.gradle:/home/gradle/.gradle \
    -w /app \
    gradle:8.0-jdk17 \

docker run --rm -it -u gradle -v ${PWD}:/app -v ${HOME}/.gradle:/home/gradle/.gradle -w /app gradle:8.0-jdk17 
docker run --rm -it -u gradle -v %cd%:/app -v ${HOME}/.gradle:/home/gradle/.gradle -w /app gradle:8.0-jdk17
gradle build

ls build/libs
```   

- vim maven-multi.Dockerfile
```
FROM maven:3.9-eclipse-temurin-17 as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src src
RUN mvn package

FROM tomcat:10
COPY --from=build /app/target/web.war ${CATALINA_HOME}/webapps/ROOT.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]

docker build -f maven-multi.Dockerfile -t  my-web-maven-multi .

docker run -p 9020:8080 -it --rm my-web-maven-multi
```

- vim gradle-multi.Dockerfile
```
FROM gradle:8.0-jdk17 as build
WORKDIR /app
RUN chown -R gradle:gradle /app
USER gradle
COPY build.gradle .
COPY src src
RUN gradle build

FROM tomcat:10
COPY --from=build /app/build/libs/web.war ${CATALINA_HOME}/webapps/ROOT.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]

docker build -f gradle-multi.Dockerfile -t  my-web-gradle-multi .

docker run -p 9021:8080 -it --rm my-web-gradle-multi
```

Since 18.09 release
- Cache mounts should only be used for better performance.
- The build should work with any contents of the cache.
```
RUN --mount=type=cache,target=/root/.m2 mvn clean package

docker builder prune
```

Example:
```
cp maven-multi.Dockerfile maven-cache.Dockerfile
```

- vim gradle-cache.Dockerfile
```
FROM maven:3.9-eclipse-temurin-17 as build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN --mount=type=cache,target=/root/.m2 mvn package

FROM tomcat:10
COPY --from=build /app/target/web.war ${CATALINA_HOME}/webapps/ROOT.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]

docker build -f maven-cache.Dockerfile -t  my-web-maven-cache .

docker run -p 9020:8080 -it --rm my-web-maven-cache
```
##Fabric8 Docker Maven plugin
- [fabric8io/docker-maven-plugin](https://github.com/fabric8io/docker-maven-plugin)
- [fabric8io/docker-maven-plugin](http://dmp.fabric8.io/#maven-goals)
  - mvn clean package
  - mvn docker:run 
```
cat target/docker/fabric8-dmp/v2/build/Dockerfile
```

##Benjamin Muschko's Gradle docker plugin
- docker-remote-api
  ```
  docker startContainer
  docker ps
  docker stop <container-id>
  ``` 
- docker-java-application  
- docker-spring-boot-application
  ``` 
  gradle dockerBuildImage
  docker images
  ```
- [bmuschko/gradle-docker-plugin](https://github.com/bmuschko/gradle-docker-plugin)
- [Gradle Docker Plugin User Guide & Examples](https://bmuschko.github.io/gradle-docker-plugin/)
 
```
plugins {
    ...
    id 'com.bmuschko.docker-spring-boot-application' version '9.3.0'
    id 'com.bmuschko.docker-remote-api' version '9.3.0'
    ...
}
```

## Spring Boot 2.3 and Above
- Buildpacks
  ```
  mvn spring-boot:build-image
  gradle bootBuildImage
  ```
- Layered JARs
  ```
  java -Djarmode=layertools -jar my-app.jar command
  command: list|extract|help
  ```

Example:
```
gradle bootBuildImage --imageName=layers-gradle
docker images
docker run -it --rm -p 9030:8080 layers-gradle
java -Djarmode=layertools -jar build/libs/api.jar list
gradle clean build
java -Djarmode=layertools -jar build/libs/api.jar list
java -Djarmode=layertools -jar build/libs/api.jar extract
ls hibernate-deps/BOOT-INF/lib
```

```
vim layers-gradle.Dockerfile

FROM gradle:8.0-jdk17 as build
WORKDIR /app
RUN chown -R gradle:gradle /app
USER gradle
COPY build.gradle .
COPY src src
RUN gradle build
RUN java -Djarmode=layertools -jar build/libs/api.jar extract

FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/dependencies/ ./
COPY --from=build /app/hibernate-deps/ ./
COPY --from=build /app/spring-boot-loader/ ./
COPY --from=build /app/snapshot-dependencies/ ./
COPY --from=build /app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

docker build -f layers-gradle.Dockerfile -t custom-layers-gradle .
docker -it --rm -p 9031:8080 custom-layers-gradle 
```

### Google Jib, Spring Boot before 2.5 didn't support projects with WAR packaging 
Build and Push the image to a Container Registry
```
mvn compile jib:build -Dimage=$IMAGE_PATH
gradle jib --image=$IMAGE_PATH
```
Requires authorization credentials for the registry
- Credential helpers
- CLI tools
- auth parameter is plugin's configuration
- Maven settings

Build Image with Local Docker Installation
```
mvn compile jib:dockerBuild
gradle jibDockerBuild
```

Example:
```
mvn package com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=jib-web-maven
docker images
docker history jib-web-maven[docker for developing Java Apps.md](docker%20for%20developing%20Java%20Apps.md)
docker run -it --rm -p 9040:8080 jib-web-maven

mvn jib:dockerBuild -f pom-jib.xml

gradle jibDockerBuild
docker run -it --rm -p 9041:8080 jib-web-gradle
```

## Docker Compose
- To manage more than one container at the same time for the same application
- Uses a docker-compose.yml file for configuration
- Uses the docker compose command to manage the containers of an application

1. docker network, there are 6 drivers as:
- Bridge
- Host
- Overlay
- IPvlan
- Macvlan
- None
- docker network create|Is|inspect|connect|disconnect|rm|prune
```
docker network create web-db
docker network ls
docker network inspect web-db 
docker run --network-alias <alias>
docker run -it --rm -p 5432:5432 -e POSTGRESS_PASSWORD=1234 -e POSTGRES_DB=bookdb -v ${PWD}/db:/var/lib/postgresql/data --net web-db --name db postgres
docker run -it --rm -p 5432:5432 -e POSTGRESS_PASSWORD=1234 -e POSTGRES_DB=bookdb -v %cd%/db:/var/lib/postgresql/data --net web-db --name db postgres
docker build -f web.Dockerfile -t web-app-db .
docker run -it --rm -p 8080:8080 --net web-db web-app-db
#No exception
```

2. docker run commands
```
# JPA
spring.jpa.open-in-view=false
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.jakarta.persistence.sharedCache.mode=NONE
spring.jpa.database=POSTGRESQL
spring.datasource.url=jdbc:postgresql://db:5432/bookdb
#spring.datasource.url=jdbc:postgresql://localhost:5432/bookdb
spring.datasource.username=postgres
spring.datasource.password=1234

docker run -it --rm -p 5432:5432 -e POSTGRESS_PASSWORD=1234 -e POSTGRES_DB=bookdb -v ${PWD}/db:/var/lib/postgresql/data postgres
docker run -it --rm -p 5432:5432 -e POSTGRESS_PASSWORD=1234 -e POSTGRES_DB=bookdb -v %cd%/db:/var/lib/postgresql/data postgres
gradle clean bootRun  

docker build -f web.Dockerfile -t web-app .
docker run -it --rm -p 8080:8080 web-app
#PSQLException: Connection to localhost:5432 refused
```
3. docker compose configuration, yml fil
- Dockerfile
- YAML configuration file, docker-compose.yml (or.yaml)
- Manager containers
  - docker compose build|config|up|down|start|stop|ps|top|kill 
```
docker compose config
docker compose config -q
docker compose build
docker compose
rm -r db
docker compose up 
docker compose up --build
docker container ls
docker network ls
docker compose ps
docker compose top
docker compose kill
docker container ls -a
docker compose rm 
docker container ls -a
docker compose up -d
docker compose stop
docker compose start
docker compose down
docker compose down --rmi all
```

## Configuring Java Applications in Containers

```
gradle package
java -jar target/api.jar
curl localhost:8080/env -> NO_ENVIRONMENT

docker build -f api-env.Dockerfile -t api-app-dev .
docker run -it --rm -p 8081:8081 api-app-dev
curl localhost:8081/env -> DEV

docker run -it --rm -e SPRING_PROFILES_ACTIVE=test -p 8082:8082 api-app-dev
curl localhost:8082/env -> TEST

docker run -it --rm -p 8082:8082 api-app-dev --spring.profiles.active=test
curl localhost:8082/env -> TEST
```

```
docker run -it --rm -p 8082:8082 api-app-dev -Dspring.profiles.active=test
#Do not work -> DEV, Se rules for CMD and ENTRYPOINT
#See solution in "- Defining Java System Properties" 

- Overeeiding CMD
docker run [OPTIONS] IMAGE[:TAG] [COMMAND] [ARG...]

ENTRYPOINT ["java", "-jar", "app.jar"]
CMD --server.port=8081
docker run my-image --server.port=8082
jar -jar app.jar --server.port=8082

- Overringen ENTRYPOINT
docker run --entrypoint /bin/bash my-image

- Defining Java System Properties
ENV JAVA_OPTS
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar ${0} ${@}"]

docker build -f api-shell.Dockerfile -t api-app-shell .
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test -p 8082:8082 api-app-shell
curl localhost:8082/env -> TEST
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test -p 8082:8082 api-app-shell --enviroment.label=HI
curl localhost:8082/env -> HI
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test -p 8082:8082 api-app-shell --enviroment.label=HI --spring.main.banner-mode=console
```
- [features.external-config](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)
- [entrypoint](https://docs.docker.com/engine/reference/builder/#entrypoint)

## Mounting External Properties Files
```
docker build -f api.Dockerfile -t api-app-external . 
docker run -it --rm -p 8083:8083 -e spring_config_additional-location=/config/ext_application.properties -v ${PWD}/ext_application.properties:/config/ext_application.properties api-app-external
docker run -it --rm -p 8083:8083 -e spring_config_additional-location=/config/ext_application.properties -v %cd%/ext_application.properties:/config/ext_application.properties api-app-external
curl localhost:8083/env -> EXTERNAL
```

##Overriding Docker compose configuration files
```
docker build -f api.Dockerfile -t api-app .
docker componse -f docker-compose.yml -f socker-compose-dev.yml config
docker componse -f docker-compose.yml -f socker-compose-dev.yml up -> 8081  Network api_default|Container api-api-1 Created
docker componse -f docker-compose.yml -f socker-compose-test.yml up -> 8082 Network api_default|Container api-api-1 Recreated
curl localhost:8081/env -> kill/quit
curl localhost:8082/env -> TEST

docker componse -f docker-compose.yml -f socker-compose-dev.yml up -> 8081 === run              Network api_default|Container api-api-1 Created
docker componse -f docker-compose.yml -f socker-compose-test.yml -p api-test up -> 8082 === run Network api-test_default|Container api-test-api-1 Created
curl localhost:8081/env -> DEV
curl localhost:8082/env -> TEST
docker compose down
docker compose -p api-test down
```

## Managing Application Logs with Docker
docker logs [OPTIONS] CONTAINER
- docker Logs --details|--follow|--since|-tail|-timestamps|--until
- --since|--until: 2021-01-01T00:00:00Z or 10m

docker compose logs [OPTIONS] [SERVICE...]
- docker compose logs --no-color|--follow|--tail|--timestamps

```
docker build -f api.Dockerfile -t my-app-log .
docker run -it --rm -p 8080:8080 --name api my-app-log
docker logs api
docker logs -f api

docker run -it --rm -p 24224:24224 -v ${PWD}:/fluentd/etc/ -e FLUENTD_CONF=fluent.conf fluent/fluentd:v1.15
docker run -it --rm p 8080:8080 --log-driver=fluentd --log-opt tag="{{.Name}}.{{.ImageName}}" --name api my-app-log
```
### Multiline Log Problem when an exception occurred: [fluent-plugin-concat](https://github.com/fluent-plugins-nursery/fluent-plugin-concat)
```
vim fluent-ml.conf
vim fluentd.Dockerfile
docker build -f fluentd.Dockerfile -t my-fluentd .
docker run -it --rm -p 24224:24224 -v ${PWD}:/fluentd/etc/ -e FLUENTD_CONF=fluent.conf my-fluentd
docker run -it -d p 8080:8080 --log-driver=fluentd --log-opt tag="{{.Name}}.{{.ImageName}}" --name api my-app-log
```

- Setting up Elastiscsearch, Kibana and Fluentd
```
vim fluent-efk.conf
vim docker-compose.yml
docker stop api
docker stop my-fluentd
docker container ls -a
docker compose up
#fetch data fra en of apis
#visit kibana at localhost port 5601, go Analytics -> Discover (click create index patern, type fluent og choice timestamp)
```
