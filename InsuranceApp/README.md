# InsuranceApp
Insurance contract project via one request through many services

## External Libraries
- Java 8
- Spring Boot 1.4.1
- JUnit 4.12
- RESTfull, JSON

## How To Run it
1. [Run](https://github.com/pedalv/InsuranceApp/blob/master/src/main/java/no/insurance/InsuranceAppApplication.java) from IntelliJ IDEA 
2. [Open database](http://localhost:8080/h2/)
2.1 [application.properties](https://github.com/pedalv/InsuranceApp/blob/master/src/main/resources/application.properties)
2.1 [Create database](https://github.com/pedalv/InsuranceApp/tree/master/src/main/resources/db.migration)
3. Open [http://localhost:8080/insurance](http://localhost:8080/insurance) 
3.1 Output will be: Product_id: <nnn>, State: 4
3.1.1 Code located on [insurance method](https://github.com/pedalv/InsuranceApp/blob/master/src/main/java/no/insurance/controller/HomeController.java)

## Tools
- [Apache Maven](https://maven.apache.org/download.cgi) version: 3.3.9
- [Java version](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html): 1.8.0_101, vendor: Oracle Corporation
- OS name: "windows 10", version: "10.0", arch: "x86", family: "dos"
- Download [IntelliJ IDEA](http://www.jetbrains.com/idea/download/index.html#section=windows)

## Create project
- [Start Spring Boot](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started)
- [Create pom file](http://start.spring.io/)
- Compile project and create jar file
```bash
$ mvn clean compile package
```
Building jar: ..\InsuranceApp\target\InsuranceApp-0.0.1-SNAPSHOT.jar
- Run project from IntelliJ IDEA or from command line (below)
```bash
$ java -jar InsuranceApp-0.0.1-SNAPSHOT.jar 
```
- See all dependencies
```bash
$ mvn dependency:tree
```
- Open the projet [InsuranceApp](http://localhost:8080) in a browser

## Config application properties
- [§ Appendix A. Common application properties](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

## Documentation
- [Testing the Web Layer](https://spring.io/guides/gs/testing-web/)
- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
- [Getting started with Spring Data JPA](https://github.com/pedalv/InsuranceApp)
- [Embedding H2 in an Application](http://h2database.com/html/quickstart.html)
- [Flyway](https://github.com/flyway/flyway)
-- [Flyway First steps](https://flywaydb.org/getstarted/firststeps/maven)
- [Creating Asynchronous Methods](https://spring.io/guides/gs/async-method/)

## Task Description
- The client would like estabelish an insurance contract with a company that give him/her the best deal.
- An expert team will help him/her to find the best product available in the market from several companies.
- A letter will return to client from the company that gave him/her the best deal.

## Identities
- Klient: Person looks for an insurance contract. 
- Integrasjonslag: Expert team responsavel to find the best product from all companies available.
- Fagsystem: Products(1) available in Gjensidige, If, etc in accordance with clients needs.
- Brevtjeneste: Letter(2) with the information service return to the must happy client.

(1) List with all products available from company A located in their DB.

(2) List of services with all details located in a common DB.

## REST API
#### Letter Stub
- GET /api/v1/letterstub (list) -> [GET](http://localhost:8080/api/v1/letterstub) 
- POST /api/v1/letterstub (add)
- GET /api/v1/letterstub/{id} (view)
- PUT /api/v1/letterstub/{id} (udpate)
- DELETE /api/v1/letterstub/{id} (delete)

#### Letter
- GET /api/v1/letter (list) -> [GET](http://localhost:8080/api/v1/letter) 
- POST /api/v1/letter (add) 
- GET /api/v1/letter/{id} (view) 
- PUT /api/v1/letter/{id} (udpate) 
- DELETE /api/v1/letter/{id} (delete)

#### Product
- GET /api/v1/product (list) -> [GET](http://localhost:8080/api/v1/product) 
- POST /api/v1/product (add)
- GET /api/v1/product/{id} (view)
- PUT /api/v1/product/{id} (udpate)
- DELETE /api/v1/product/{id} (delete)

#### User
- GET /api/v1/user (list) -> [GET](http://localhost:8080/api/v1/user) 
- POST /api/v1/user (add)
- GET /api/v1/user/{id} (view)
- PUT /api/v1/user/{id} (udpate)
- DELETE /api/v1/user/{id} (delete)

## Overall flow
#### Opprett avtale: Klient -> Integrasjonslag
+ Model:  type of product user want, information about user.
+ GET /api/v1/productuser (What is the product user want + user information - form) 
+ POST /api/v1/productuser (Send the product user want + user information - create) 

#### Opprett kunde: Integrasjonslag -> Fagsystem
+ Model: create user in the company with best deal available.
+ POST /api/v1/user (Send user information to create client in company A - create)

#### Kundenummer: Fagsystem -> Integrasjonslag
+ GET eller POST /api/v1/user (Send user client information - return clientnumber)

#### Opprett avtale: Integrasjonslag -> Fagsystem
+ Model: type of product user want
+ POST /api/v1/product (Send information about product user want - form) 

#### avtalenummer: Fagsystem -> Integrasjonslag
+ GET eller POST /api/v1/product (Send number of the best product available - return productnumber) 

#### Send avtale til kunde: Integrasjonslag(Brevtjneste) -> Klient 
+ Model: type of service user get
+ GET eller POST /api/v1/letter (Get letter information from  productnumber - return letterinformation)

#### Status på utsendelse: Klient -> Integrasjonslag(Brevtjneste) 
+ Model: product was paid by user
+ GET /api/v1/letter-status (Get confirmation of payment - Status) 

#### Oppdater status til "avtale sendt": Integrasjonslag -> Fagsystem
+ Model: product is update
+ GET /api/v1/product-status (Get confirmation of payment from user - update Status) 

#### avtalestatus: Fagsystem -> Integrasjonslag 
+ Model: service status from company A - Insurance is active
+ GET /api/v1/insurance-status (Insurance is active now - update Status) 

#### avtalenummer og status: Integrasjonslag -> Klient
+ Model: product-id information and status is active
+ GET eller POST /api/v1/letter-status (Get confirmation that insurance is active now - return product-id+Status)

## Model
- Product: What product user want, Product description
- User: User information 
- Letter: product information
- Insurance: Type of insurance available
- State: payment by user and service status, Pending, Active, Cancel 