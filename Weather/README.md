# Weather
Weather prosjekt

## External Libraries
- Java 8
- Spring Boot 1.4.1
- JUnit 4.12
- RESTfull, JSON
- AngularJs, CSS, JS, HTML, Gulp, Jasmine, Karma

## Tools
- [Apache Maven](https://maven.apache.org/download.cgi) version: 3.3.9
- [Java version](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html): 1.8.0_111, vendor: Oracle Corporation
- OS name: "windows 10", version: "10.0", arch: "x86", family: "dos"
- Download [IntelliJ IDEA](http://www.jetbrains.com/idea/download/index.html#section=windows)

## Create Oppgaver project from pom file
- [Create pom file](http://start.spring.io/)

## Dokumentasjon
- [Start Spring Boot](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started)
- [Run project from command line](http://stackoverflow.com/questions/16137713/how-to-run-a-java-program-from-the-command-line)
- [§ Appendix A. Common application properties](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- [application-properties junit test](http://stackoverflow.com/questions/29669393/override-default-spring-boot-application-properties-settings-in-junit-test)
- [application-properties junit test file](http://stackoverflow.com/questions/30528255/how-to-access-a-value-defined-in-the-application-properties-file-in-spring-boot)
- [Caching Data with Spring](https://spring.io/guides/gs/caching/)
- [Reading Directly from a URL](https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html)
- [Java DOM Parser - Parse XML Document](https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm)
- [XML Developer's Kit Programmer's Guide](https://docs.oracle.com/cd/B28359_01/appdev.111/b28394/adx_j_parser.htm#ADXDK19101)
- [logging-in-spring-boot](http://blog.netgloo.com/2014/12/11/logging-in-spring-boot/)
- [What Are the Gmail SMTP Settings?](https://www.lifewire.com/what-are-the-gmail-smtp-settings-1170854)
- [javax.mail.AuthenticationFailedException is thrown while sending email in java](http://stackoverflow.com/questions/25341198/javax-mail-authenticationfailedexception-is-thrown-while-sending-email-in-java)
- [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

## Yr.no
1. [yr.no API](http://api.met.no/weatherapi/documentation)
2. [yr.no XML Informasjon](http://om.yr.no/verdata/xml/)
3. [Vilkår for bruk av gratis data frå Yr](http://om.yr.no/verdata/vilkar/)
4. [yr.no Svalbalen varsel] (http://www.yr.no/place/Norway/Sør-Trøndelag/Frøya/Svalbalen/)
5. [yr.no Svalbalen varsel på XML ](http://www.yr.no/sted/Norge/Sør-Trøndelag/Frøya/Svalbalen/varsel.xml)
6. [yr.no Svalbalen varsel døgn](http://www.yr.no/sted/Norge/Sør-Trøndelag/Frøya/Svalbalen/time_for_time.html)
7. [yr.no Svalbalen varsel døgn på XML](http://www.yr.no/sted/Norge/Sør-Trøndelag/Frøya/Svalbalen/varsel_time_for_time.xml)

## Oppgave 1: Vær i Svalbalen via e-post
1. Compile project and create jar file
```bash
$ mvn clean compile package
```
Building jar: ..\oppgave\target\weather-0.0.1-SNAPSHOT.jar

2. Hvordan kjører prosjekt 
2.1 fra en jar fil
```bash
$ java -jar weather-0.0.1-SNAPSHOT.jar 
```
2.2 fra Command line
```bash
mvn spring-boot:run 
```
2.3 fra IDE

- Note: Epost blir sendte hver timer

## Hvordan kjører prosjekt fra en en nettleser:
1. [Kjører opplikasjon uten sikkerhet for å sende epost](https://www.google.com/settings/security/lesssecureapps)
2. [Sende e-post hver timer](http://localhost:8080/weather/report)

- See all dependencies
```bash
$ mvn dependency:tree
```

## Oppgave 2: Vær i Svalbalen via web
1. [RESTful Web Service to return Json weather](http://localhost:8080/api/weather)
2. [vær-side](http://localhost:8080/index.html)

## Dokumentasjon front-end
- [package.json](https://docs.npmjs.com/getting-started/using-a-package.json)
- [angular via Bower](http://stackoverflow.com/questions/17808346/how-can-i-install-angular-version-1-1-5-via-npm)
- [angular](https://www.npmjs.com/package/angular)
- [angular-route](https://www.npmjs.com/package/angular-route)
- [angular-cli](https://www.npmjs.com/package/angular-cli)
- [angular-material](https://www.npmjs.com/package/angular-material)
- [angular-animate](https://www.npmjs.com/package/angular-animate)
- [angular-sanitize](https://www.npmjs.com/package/angular-sanitize)
- [angular-aria](https://www.npmjs.com/package/angular-aria)
- [bootstrap](https://github.com/twbs/bootstrap)
- [Global CSS settings, fundamental HTML elements styled and enhanced with extensible classes, and an advanced grid system](https://getbootstrap.com/css/)
- [unit testing](https://docs.angularjs.org/guide/unit-testing)
- [karma](http://karma-runner.github.io/1.0/index.html)
- [jasmine](https://jasmine.github.io/1.3/introduction.html)

## Opprette front-end
1. npm init
2. npm install bower --save
3. npm install angular angular-route angular-material angular-animate angular-aria angular-sanitize (*) --save 
3.1 (*) Det betyr at de finner mange modules og de er inne package.json i dependencies seksjon- 

## Oppdatere front-end
- Load all libraries
```bash
$ npm install
$ gulp
```

## Run front-end unit test
- Inne tests mapper 
```bash
$ .\run-karma-tests.bat
```
- Hvordan man fikser feiler da man kjører script opp
1. REM Requirements:
REM - NodeJS
REM - Karma (npm install -g karma)
2. REM Maybe you need install
REM - requirejs (npm install -g requirejs)
REM - karma-requirejs (npm install -g karma-requirejs)
REM - karma-jasmine (npm install -g karma-jasmine)
REM - karma-cli (npm install -g karma-cli)
REM - jasmine-core (npm install -g jasmine-core)
REM - angular-mocks (npm install -g angular-mocks)