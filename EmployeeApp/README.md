# EmployeeApp
EmployeeApp from [Oracle](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/basic_app_embedded_tomcat/basic_app-tomcat-embedded.html#overview).

## External Libraries
- Java 8
- JSTL 1.2
- JUnit 4.12, Hamcrest 1.3
- Tomcat 7.070
- JSP, CSS, JS, HTML

## Create jar file
```bash
$ mvn clean compile package
```
## Run  project from Target directory
```bash
$ java -jar employeesApp-1.0-SNAPSHOT-jar-with-dependencies.jar 
```
- In chrome open: [http://localhost:8080](http://localhost:8080)

## Documentation
- [Run tomcat forum](http://stackoverflow.com/questions/17229674/adding-tomcat-server-in-intellij)
- [Run tomcat Dzone](https://dzone.com/articles/headless-setup-java-project)