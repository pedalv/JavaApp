# Space
- Create a REST interface for a coffee machine
- Coffee machine: 
![alt text](http://www.mewa-kaffee.de/files/automaten/sielaff_kaffeeautomat_cvt.jpg "sielaff kaffeeautomat")

# REST Interface

| HTTP verb | Data operation |
| --------------- | --------------- |
| GET | Retrieve |
| POST | Create |
| PUT | Update (update all fields and use default values for any undefined fields) |
| DELETE | Delete |
| MERGE | Update (update only the fields that are specified and changed from current version) |

# Client

| List of operations | HTTP verb | Data operation | URL
| --------------- | --------------- | --------------- | --------------- |
| 1 | GET | Awake machine, briefing | /api/v1/coffeemachine/briefing |
| 2 | GET | Select product | /api/v1/coffeemachine/product |
| 3 | GET | Product options | /api/v1/coffeemachine/option |
| 4 | POST | Pay | /api/v1/coffeemachine/payment |
| 5 | GET | Product Selected | /api/v1/coffeemachine/product |
| 6 | GET | Cancel order | /api/v1/coffeemachine/product-options |

## Create coffee machine project with Spring Boot
- [Start Spring Boot](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started)
- [Create pom file](http://start.spring.io/)
> Group: no.space.coffeemachine 

> Artifact: coffeemachine

> Name: coffeemachine 

> Description: REST-grensesnitt for en kaffeautomat 

> Package Name: no.space.coffeemachine

> Packaging: Jar

> Java Version: 1.8

> Dependencies: Web 

- Compile project and create jar file
```bash
$ mvn clean compile package
```
Building jar: ../Space/target/coffeemachine-0.0.1-SNAPSHOT.jar

- Run project from IntelliJ IDEA or from command line (below)
```bash
$  java -jar target/coffeemachine-0.0.1-SNAPSHOT.jar 
```
- See all dependencies
```bash
$ mvn dependency:tree
```
- Open [home - '/'](http://localhost:8080/#) in a browser
- Open index.html page [/coffeemachine](http://localhost:8080/coffeemachine/#) in a browser
- Get all [Products](http://localhost:8080/api/v1/product)
