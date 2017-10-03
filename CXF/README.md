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
## Deploy the project to TomCat
## Execute the web service in Eclipse

# CXF Archetype Project Structure
- Main Java Source
- Test Java Source
- WEB-INF
- pom.xml (Project configuration, Dependencies, Build configuration)

# CXF Architecture Overview
1. Bus
2. Transports
3. Frontends
4. Data Bindings
5. Protocol Bindings
6. WS-*

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
1.3.2 Requirements for a Custom Interceptor
- Add additional processing to a chained
> Auditing
> SOAP message enhancement
- Skip a processing step
> Non-standard web services
1.3.3 Designing a Custom Interceptor
- Determine inbound or outbound
- Select a phase
- Determine where it fits in the order of phase processing
- Implement message and fault handling
1.4 Messages
- Container for data to be passed through interceptor chains
1.4.1 Message state
- Stream, marshalled, un-marshalled...

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

3 CXF Front End Options
- JAX-WS
- JAX-RS
- JavaScript
3.1.1 JAX-WS
- Specification for Java XML-based web services
- Typically implemented using a WSDL with SOAP over HTTP
- CXF provides full support for JAX-WS
3.1.2 Implementing JAX-WS
- Availablle in the cxf-rt-frontend-jaxws library
- Supported by a variety of transports
- Configured through Spring application context
3.1.2.1 JAX-WS Endpoint Bean Configuration
```bash
<jaxws:endpoint 
	id="" 
	implementor="" 
	address=""
	bindingUri=""
	bus=""
	endpointName=""
	implementorClass=""
	publish=""
	publishedEndpointUrl=""
	serviceName=""
	transportId=""
	wsdlLocation="" >
	
	<jaxws:databinding />
	<jaxws:features />
	<jaxws:handlers />
	<jaxws:inInterceptors />
	<jaxws:inFaultInterceptors />
	<jaxws:outInterceptors />
	<jaxws:outFaultInterceptors />
	<jaxws:properties />
	
</jaxws:endpoint>
```
3.2.1 JAX-RS
- Specification for Java RESTful web services
> Supports plain old Java objects (POJO) through URIs
- CXF Support for JAX-RS versionss
> JAX-RS 2.0 2.0: CXF 2.x mostly supports, CXF 3.x fully supports
> JAX-RS 1.1: CXF 2.x+ fully supports
3.2.2 Implementing JAX-RS
- Available in the cxf-rt-frontend-jaxrs library
- Supported by the HTTP transport and CXF Servlet
- Configured through Spring application context
```bash
<jaxrs:server id="" address"" >
	<jaxrs:serviceBeans>
		<bean class="" />
	</jaxrs:serviceBeans>
	<jaxrs:providers>
		<bean class="" />
	</jaxrs:providers>
</jaxrs:server>
```
3.3 JAX-WS  vs JAX-RS
| Distributed component integrarion | Mobile and web view integration 	|  
| Complex operations 				| Simple transactions 				|
| Standars-based  					| Limited constrainsts  			|  
| Multiple transports  				| HTTP transport  					|  

4. Data Binding
- JAXB
- Aegis
- SDO
- XMLBeans
4.1.1 JAXB
- Java architecture for XML binding
- Binding based on XLM schema definition
- Unmarshal and marshal
4.1.2 JAXB Configuration
```bash
<jaxws:endpoint id="" implementor="" address"">
	<jaxws:dataBinding>
		<bean class="" />
	</jaxws:dataBinding>
</jaxws:endpoint>
```
4.2 CXF XJC Maven Plugin
- XJC is a binding compiler executed through a command prompt
- Generates Java code based on an XSD
- CXF supports XJC through a Maven plug-in

5. CXF Protocol Binding Options
- SOAP 
- MTOM
- Pure XML
5.1.1 SOAP Protocol Binding
- Language that defines service message format
- Data is passed in an envelope that contains a header and body
- Configured as part of the WSDL binding section
5.1.2 SOAP Protocol Configuration
```bash
<wsdl:binding name="" type="">
	<soap:binding transport=""" style="" />
	<wsdl:operation name="">
		<soap:operation soapAction=""" style="" />
		<wsdl:input name="">
			<soap:body use="">
		</wsdl:input>
		<wsdl:output name="">
			<soap:body use="">
		</wsdl:output>
	</wsdl:operation>
</wsdl:binding>
```

6. WS-* Specification Options
- Addressing
- Discovery
- Metadata Exchange
- Policy
- Reliable Messaging
- Secure Conversation
- Security
- Security Policy
- Trust
6.1 WS-Addressing
- Provides a standard way of adding address information to a SOAP header
- Intended to support more complex enterprise-level solutions
- Include an endpoint reference and endpoint reference properties
- CXF supports as part of the JAX-WS endpoint schema
6.2 WS-Discovery
- Provides support for a multicast protocol that auto-discovers services on a local network
- Leverages the UDP protocol for communication
- CXF supports discovery through an API
- Available across two dependencies, cxf-services-ws-discovery-service and cxf-services-ws-discovery-api
6.3 WS-MetadataExchange
- Defines how metadata is represented for a web service endpoint
- Configured in the SOAP header
- Available through the dependency cxf-rt-ws-mex
6.4 WS-Policy
- A framework and model for web service policies
> Domain-specific capabilities
> Requirements
> General characteristics
- Configured in CXF through WSDL, Spring or API
- Available through the dependency cxf-rs-ws-policy
6.5 WS-ReliableMessaging
- Defines a protocol for reliable message delivery between distributed systems
- Available through the dependency cxf-rt-ws-mex
6.6 WS-Security
- Provides security features beyond the transport level protocol
- Available through the dependency cxf-rt-ws-security
6.7 WS-SecurityPolicy
- Provides an easier, Standars-bases way to configure security
- Uses policies based on the web service policy framework
- Available through the dependency cxf-rt-ws-security
6.8 WS-SecureConversation
- Part of the WS-SecurityPolicy specification
- Provides a better performing approach for encrypted communication
- Available through the dependency cxf-rs-ws-security
6.9 - WS-Trust
- Part of the WS-SecurityPolicy specification
- Supports the issuing, renewing and validation of security tokens
- Available through the dependency cxf-rt-ws-security

## [Why Contract First Web Service?](https://docs.spring.io/spring-ws/site/reference/html/why-contract-first.html)
- Inventory of services and schemas defined early in a design phase
- Condidered best practice
> Schema types are portable
> Supports logic-to-contract coupling

## Contract-First Design Considerations
- Contract granularity
> Breadth of business context
> Amount of work
> Amount of data
> Amount of constraints
- Re-usability
- Transparency

# Case study: Order Web Service
- Central place where their clients can place orders
- Each request requires three inputs
> Account
> Book
> Order Inquiry
- Each response provide two outputs
> Account information
> order information

# Documentation for fix some problems
- [Adding maven dependencies in the project's web deployment assembly](https://stackoverflow.com/questions/6210757/java-lang-classnotfoundexception-org-springframework-web-context-contextloaderl)

# Links to case study - Bokk Order Placement
- [Open book-order](http://localhost:8080/book-order)
- [Open HelloWorld wsdl](http://localhost:8080/book-order/HelloWorld?wsdl)
- [Open Service Orders wsdl](http://localhost:8080/book-order/services/orders?wsdl)
- [Open Service Orders](http://www.bookcontract.com/service/Orders/)
- [Open Client](http://localhost:8080/book-order-theclient/processOrderPlacement)

# Testing a CXF Web Service
- CXF™
- jUnit
> common framework for supporting Java testing
> Full support in IDEs and frameworks
> Supports testing at the unit and integration test level
- Spring
> Supports loading Spring's application context
> Framework agnostic
> Annotations for test case support
- JAX-WS Server Bean Configuration
```bash
<jaxws:server 
	id="" 
	address=""
	serviceBean=""
	serviceClass="" >
</jaxws:server>
```
- JAX-WS Client Bean Configuration
```bash
<jaxws:client 
	id="" 
	address=""
	serviceClass="" >
</jaxws:client>
```

## SOAP Fault
- Contains errors and status information in a standard format
> Fault code tells the nature of the errors
> Fault string tells the description of the errors
- Wrapped by CXF into an exception

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
