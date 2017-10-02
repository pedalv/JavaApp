# Apache CXF
- Apache CXF™ is an open source services framework. 
- CXF helps you build and develop services using frontend programming APIs, like JAX-WS and JAX-RS. 
- These services can speak a variety of protocols such as SOAP, XML/HTTP, RESTful HTTP, or CORBA and work over a variety of transports such as HTTP, JMS or JBI.

# History - Defining Web Services - SOAP
- In 2002, Sun released their first web service specification, JSR 101 -> JAX-RCP SOAP
- In 2006, Sun released JSR 224, JAX-WS 2.0
- In 2008, Sun introduced JSR 311 -> JAX-RS
- to 2013, Sun improved with the realise of JSR 339 -> JAX-RS version 2.0
- [Apache CXF](http://cxf.apache.org/) 

# Pre-requisites
- Java
- Java EE (Servlets)
- Spring Core
- XML

# Module
## Create a CXF Web Services project with maven
- Dependency Management
- IDE Integration
- Plug-ins
- Build Management
```bash
$  mvn archetype:generate -Dfilter=org.apache.cxf.archetype:
```
Note: Includes Java-first web service
## Deploy the prosject to Toomcat
## Execute the web service in Eclipse

# CXF Archetype Project Structure
- Main Java Source
- Test Java Source
- WEB-INF
- pom.xml (Project configuration, Dependencies, Build configuration)

# CXF Architecture Overview
1. Bus
2. Transports
- Frontends
- Data Bindings
- Protocol Bindings
- WS-*

1.1 Introduction to the CXF Bus
- Spring-based registry of components
- Highly customizable
- Minimal configuration
1.2 CXF Bus Class
- cxf-rt-core
- cxf-api
1.3 Interceptors
- Follows Interceptor design pattern
- Provides message and fault handlers
- Can be chained together
1.3.1 Interceptor Phases
- Incomming chains
- Outgoing chains
- Post-processing chains
1.4 Messages
- Container for data to be passed through interceptor chains
2.1 CXF Transport Options
- HTTP 
- JMS
- Local
- UDP
- Apache Camel

2.1.1 HTTP Transport Options
- Deploy web services to a web container
- Deploy web services with an embedded web container

2.1.2 CXF Servlets
- Request processing for web service endpoints
- Available in the cxf-rt-transports-http library
- Supports the creation of Spring's application context

2.2.3 CXF Web Container Supports
- Apache Tomcat
- Jetty
- JBoss Application Server
- WebLogic
- WebSphere Application Server
- Glassfish Application Server

2.2.4 CXF Frontr End Options
- JAX-WS
- JAX-RS
- JavaScript

2.2.4.1 JAX-WS
-
-
-






# Links with some examples
- [Open book-order](http://localhost:8080/book-order)
- [Open HelloWorld wsdl](http://localhost:8080/book-order/HelloWorld?wsdl)
- [Open Service Orders wsdl](http://localhost:8080/book-order/services/orders?wsdl)
- [Open Service Orders](http://www.bookcontract.com/service/Orders/)
- [Open Client](http://localhost:8080/book-order-theclient/processOrderPlacement)

# Documentation for fix some problems
- [Adding maven dependencies in the project's web deployment assembly](https://stackoverflow.com/questions/6210757/java-lang-classnotfoundexception-org-springframework-web-context-contextloaderl)

# [Web Services Tutorial](https://www.javatpoint.com/web-services-tutorial)
## Web Service components
- SOAP
> SOAP is an acronym for Simple Object Access Protocol.

> SOAP is a XML-based protocol for accessing web services.

> SOAP is a W3C recommendation for communication between applications.

> SOAP is XML based, so it is platform independent and language independent. In other words, it can be used with Java, .Net or PHP language on any platform.

- WSDL
> WSDL is an acronym for Web Services Description Language.

> WSDL is a xml document containing information about web services such as method name, method parameter and how to access it.

> WSDL is a part of UDDI. It acts as a interface between web service applications.

- UDDI
> UDDI is an acronym for Universal Description, Discovery and Integration.

> UDDI is a XML based framework for describing, discovering and integrating web services.

> UDDI is a directory of web service interfaces described by WSDL, containing information about web services. 

## SOAP Web Services
> SOAP stands for Simple Object Access Protocol. 

> It is a XML-based protocol for accessing web services.

> SOAP is a W3C recommendation for communication between two applications.

> SOAP is XML based protocol. 

> (+) It is platform independent and language independent: SOAP web services can be written in any programming language and executed in any platform.

> By using SOAP, you will be able to interact with other programming language applications.

> (+) WS Security: SOAP defines its own security known as WS Security.

> HTTP POST, [JMS](https://www.javatpoint.com/jms-tutorial), etc

> (-) Slow: SOAP uses XML format that must be parsed to be read. It defines many standards that must be followed while developing the SOAP applications. So it is slow and consumes more bandwidth and resource.

> (-) WSDL dependent: SOAP uses WSDL and doesn't have any other mechanism to discover the service.

- [http://localhost:8080/ListManagerWebServices/UserSoapService?wsdl](http://localhost:8080/ListManagerWebServices/UserSoapService/UserSoapService.wsdl)
- [http://localhost:8080/ListManagerWebServices/ListItemSoapService?wsdl](http://localhost:8080/ListManagerWebServices/ListItemSoapService?ListItemSoapService.wsdl)
- [SoapUI tool for testing SOAP and RESTful web services](https://www.soapui.org/)

## RESTful web services
> REST stands for REpresentational State Transfer.

> REST is an architectural style not a protocol.

> HTTP-Based

> (+) Fast: RESTful Web Services are fast because there is no strict specification like SOAP. It consumes less bandwidth and resource.

> (+) Language and Platform independent: RESTful web services can be written in any programming language and executed in any platform.

> (+) Can use SOAP: RESTful web services can use SOAP web services as the implementation.

> (+) Permits different data format: RESTful web service permits different data format such as Plain Text, HTML, XML and JSON.

- [http://localhost:9080/ListManagerWebServices/rest/user/?username=pedro](http://localhost:8080/ListManagerWebServices/rest/user/?username=pedro)
- [http://localhost:9080/ListManagerWebServices/rest/user/1/listItem](http://localhost:9080/ListManagerWebServices/rest/user/1/listItem)
- [Poster for firefox browser](https://addons.mozilla.org/en-us/firefox/addon/poster/)
- [Postman extension for Chrome](https://www.getpostman.com/)

## [SOAP vs Web Services ](https://www.javatpoint.com/soap-vs-rest-web-services)
