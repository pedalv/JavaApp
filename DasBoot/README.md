# Das Boot
Das Boot project.

## External Libraries
- Java 8
- Spring Boot 1.4.1
- JUnit 4.12
- H2 Database
- AngularJs 
- JSP, CSS, JS, HTML

## Documentations
- [Spring Tool Suite](https://spring.io/tools)
- [Spring IO](http://spring.io/)
- [Spring Initializr - POM file](http://start.spring.io/)
- [Spring Boot Samples](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples)
- [10.2 Installing the Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html)
```bash
$ ./spring init --dependencies= web myDasApp
```
## [RESTful Web App](git clone https://github.com/dlbunker/ps-spring-boot-resources.git)
Spring MVC REST Controller ngResource for “shipwreck” 
- GET /api/v1/shipwrecks (list) -> [GET](http://localhost:8080/api/v1/shipwrecks) 
- POST /api/v1/shipwrecks (add)
- GET /api/v1/shipwrecks/{id} (view)
- PUT /api/v1/shipwrecks/{id} (udpate)
- DELETE /api/v1/shipwrecks/{id} (delete)
- [Das Index from Github](http://localhost:8080/index.html#/)
> Copy content located on www directory to "Das Boot" project on resources/public.
- [Das Home](http://localhost:8080)

##[§ Appendix A. Common application properties](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- VM arguments: 
```
-Dspring.profiles.active=test
```
## [H2 Database](http://localhost:8080/h2)

## Run test
```
$ mvn test
``` 