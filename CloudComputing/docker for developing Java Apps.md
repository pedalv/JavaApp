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

docker run -p 9011:8080 -it --rm my-api-gradle (.)
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
