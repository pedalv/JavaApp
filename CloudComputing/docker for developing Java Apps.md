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
docker history jib-web-maven
docker run -it --rm -p 9040:8080 jib-web-maven

mvn jib:dockerBuild -f pom-jib.xml

gradle jibDockerBuild
docker run -it --rm -p 9041:8080 jib-web-gradle
```

## Docker Compose
- To manage more than one container at the same time for the sa,e application
- Uses a docker-compose.yml file for configuration
- Uses the docker compose command to manage the containers of an application