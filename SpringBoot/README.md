# Sprint Boot
Project to start with Sprint Boot - Hello World.

## Location
Hello World project is located on [https://github.com/pedalv/JavaApp/tree/master/SpringBoot](https://github.com/pedalv/JavaApp/tree/master/SpringBoot)

## Create project
- [Start](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started)
- Create [pom.xml](http://start.spring.io/) file from Start documentation for import Sprint Boot
```bash
$ mvn package
$ mvn dependency:tree
```
- Run "Hello World" from Spring Boot
```bash
$ mvn spring-boot:run
```
- Run "Hello World" from jar file
```bash
$ mvn package
$ jar tvf target/myproject-0.0.1-SNAPSHOT.jar (File is bigger then last one)
$ java -jar target/myproject-0.0.1-SNAPSHOT.jar
```
- In chrome
open: [http://localhost:8080/](http://localhost:8080/)

## Documentation
- [spring.io](http://spring.io/)
- [spring.io guides](http://spring.io/guides/)
- [Tagged Questions](http://stackoverflow.com/tags/spring-boot)
- [spring-boot](https://github.com/spring-projects/spring-boot/tree/master)
- [spring-boot-samples](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples)