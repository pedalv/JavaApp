# Apache CXF
- Apache CXF™ is an open source services framework. 
- CXF helps you build and develop services using frontend programming APIs, like JAX-WS and JAX-RS. 
- These services can speak a variety of protocols such as SOAP, XML/HTTP, RESTful HTTP, or CORBA and work over a variety of transports such as HTTP, JMS or JBI.

# History
- In 2002, Sun released their first web service specification, JSR 101 -> JAX-RCP SOAP
- In 2006, Sun released JSR 224, JAX-WS 2.0
- In 2008, Sun introduced JSR 311 -> JAX-RS
- to 2013, Sun improved with the realise of JSR 339 -> JAX-RS version 2.0
- [Apache CXF](http://cxf.apache.org/): CXF Bus (cxf-rt-core and cxf-api) 

# Create project
```bash
$  mvn archetype:generate -Dfilter=org.apache.cxf.archetype:
```
- [Open](http://localhost:8081/) and [open HelloWorld](http://localhost:8081/HelloWorld?wsdl)

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
