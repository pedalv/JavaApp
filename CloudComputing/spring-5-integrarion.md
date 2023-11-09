# Spring 5 Integration 
- An implementation of the Enterprise Integration Patterns based on the Spring Framework
- [Spring Integration 6](https://spring.io/projects/spring-integration)
- [Enterprise Integration Patterns](https://www.enterpriseintegrationpatterns.com/)
- Event - based Sender like: AMQP, Kafka 
  - [SAP Cloud Integration: Asynchronous Messaging Best Practices](https://www.integration-excellence.com/sap-cpi-asynchronous-messaging-best-practices/)
  - Inbound/Outbound communication describe the communication direction from a SAP Cloud into a remote system
  - Inbound Communication Channel to receive Messages
  - Outbound communication refers to message processing from the integration platform to a remote system (where the integration platform is the client)
- The Advanced Message Queuing Protocol (AMQP)
  - MQP is an open source published standard for asynchronous messaging by wire. 
  - AMQP enables encrypted and interoperable messaging between organizations and applications. 
  - The protocol is used in client/server messaging and in IoT device management.

## Enterprise Integrations Patterns
- **Message**
  - Headers (Metadata) + Playload (Application-specific content)
  - The Header contains additional information about the message, such as a correlation ID, sequence ID, expiration time
  - The Payload contains the body of the message

- Message Channel : When two applications wish to exchange data, they do so by sending the data through a channel that connects the two.
  - Point-to-point channel	: one sender, one receiver. Example: Queue
							: A point-to-point semantic states that no more than one consumer can receive each message
  - Publish-subscribe channel	: One sender, multiple receivers. Example: Event notifications
								: A publish-subscribe semantic attempts to broadcast each message to all subscribers	
-  Message endpoint: refers to some peace of code to connects with the messaging system to send or receive messages
  - Channel adapter
  - Gateway: if your primary need is to expose API’s for consumption by external business partners in a secure, scalable fashion, then you may want to consider just using an API gateway.
  - Service activator

- Message transform: from JSON to XML
  - Message translator
  - Content enricher
  - Envelope wrapper
- Message Routing
  - Message filtering

## Spring Integration
- Message Channel
  - Provider (sender)(Publish)(Store/Save/Activator), Consumer (receiver)(Subscribe)(Push/Pull)
  - Subscribable channels (Event-Driven Consumer):
    - Unicasting dispatcher (Point-to-point channel)
      - DirectChannel : It is a subscribable point-to-point channel that enables a single thread to perform operations on both sides of the channel.
					  : Motivation: Transaction Integrity === 	The key motivation for providing a channel implementation with this behavior is to support transactions that must span across the channel while still benefiting from the abstraction and loose coupling that the channel provides.
					  : Senders block on the send() method until the receiver completes processing the message
					  : Best choice for transactional calls that span across a channel, while retaining loose coupling
      - ExecutorChannel : It is a subscribable point-to-point channel that delegates to an instance of TaskExecutor to perform message dispatching.
						: Message handling is performed by different threads controlled by a Task Executor
						: Best choice for non-blocking multithreaded messages
    - Broadcasting dispatcher (Publish-subscribe channel)
      - Publish-SubscribeChannel : it is a subscribable channel that provides a publish-subscribe semantic that broadcasts messages sent to it to all its subscribed handlers.
    - Push: subscribe(MesssageHandler handler)/unsubscribe(MesssageHandler handler)
    - Non-buffering
    - Publish-subscribe channel	: One sender, multiple receivers. Example: Event notifications
								: It is a subscribable channel that provides a publish-subscribe semantic that broadcasts messages sent to it to all its subscribed handlers.
								: As a subscribable channel, the PublishSubscribeChannel does not buffer messages
								: If the subscriber is not present when the message is published, it does not receive the message
								: It is a subscribable channel that publishes messages to all of its subscribers
								: It is best used for Event Messages								
  - Pollable  channels (Polling Consumer)
    - QueueChannel 	: It is a pollable channel that provides a point-to-point semantic by storing its messages in a queue and returning messages to receivers through its receive() method.
					: It is a pollable channel backed by a queue
					: Allows consumers to throttle incoming messages
					: Configure the polling interval
					: Poller Triggers
						- fixedDelay: A delay, in milliseconds, after a message is processed and the channel is polled
						- fixedRate: A rate, in milliseconds, in which the channel is polled
						- cron: A cron time configuration that defines when the channel is polled					
      - Buffers messages in an in-memory queue
      - Unbounded capacity
    - RendezvousChannel : It is a pollable point-to-point channel that enables a “direct-handoff” scenario, wherein a sender blocks until another party invokes the channel’s receive() method. The other party blocks until the sender sends the message.
					    : Only holds a single message and blocks until that message is processed
						: A Queue Channel with a Synchronous Queue
							- Everything you have learned about the Queue Channel applies to the Rendezvous Channel, but with a synchronous queue 
							- A Synchronous Queue is a blocking queue in which each insert operation must wait for a corresponding remove operation by another thread, and vice versa.
						: It is a pollable channel backed by a synchronous queue
						: Senders block on the send() method until the receiver responds
						: Best choice for implementing the Request-Reply Message Pattern
      - Zero-capacity queue
      - Block until sender and receiver meet
    - PriorityChannel 	: It is a pollable and buffered channel that allows for messages to be ordered within the channel based upon a priority
						: Message Prioritization
							- By default, messages are prioritized using their PRIORITY message header
							- Priority is an Integer and messages with the highest priority are handled first 
						: Custom Message Prioritization
							- A Comparator can be passed to the PriorityChannel’s constructor to define custom message ordering
							- In this example we are prioritizing Swag objects by their amount (cost), descending, so the most expensive items will be processed first
						: It is a pollable channel backed by a priority blocking queue 
						: Messages are prioritized based on their PRIORITY message header or by a custom prioritization comparator
						: Ensures that higher priority messages are processed first, but need to be cautious that low priority messages are not ignored
      - Buffers messages in a priority queue
      - Default ordering by "priority" header
    - Pull: receive()/receive(long timeout)
    - Buffering    
    - Point-to-point channel: one sender, one receiver. Example: Queue

## Using a Message Broker (RabbitMQ/Kafka) for Point-to-Point Messaging
- Message Broker
  - We can decouple the destination of a message from the sender and maintain central control over the flow of messages by RabbitMQ (Kafka) and Docker 
- dockerhub
  - [rabbitmq](https://hub.docker.com/_/rabbitmq)
  ``` 
  docker pull rabbitmq:3.7-management-alpine
  docker images
  docker run -d -h rabbitmq --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.7-management-alpine
  docker ps
  docker stop rabbitmq
  docker start rabbitmq
  docker rm rabbitmq
  http://localhost:15672 (guest/guest)
  ``` 
- H2 database
  - From the course: [GITHUB - H2 Database in Docker](https://github.com/jesperdj/docker-h2) and [H2 Database Engine](https://h2database.com/html/main.html) and [DOCKERHUB - jesperdj/h2](https://hub.docker.com/r/jesperdj/h2)
    ```
    docker build -t jesperdj/h2 .                                        //Use Dockerfile to change parameters or 
    docker pull jesperdj/h2
    docker images
    docker run -d -p 8082:8082 -p 9092:9092 --name h2 jesperdj/h2 //Access the H2 Console at: http://localhost:8082/
                                                                  //Connect to a database named test using JDBC (the database will automatically be created if it does not yet exist):
                                                                  //JDBC URL: jdbc:h2:tcp://localhost/test
                                                                  //spring.datasource.url=jdbc:h2:tcp://localhost/globomantics      //NEW WITH IMAGE
                                                                  //spring.datasource.url=jdbc:h2:mem:globomantics                  //OLD     
                                                                  //Username: sa
                                                                  //Password: (none)
    docker ps
    ```
    - [h2database](https://hub.docker.com/r/buildo/h2database)
      - [GitHub h2database](https://github.com/h2database/h2database)
    ```
    docker pull buildo/h2database //Version 1.4.195 (2017-04-23)
    docker images
    docker run -itd --rm -d -p 8080:8080 -p 9092:9092 --name globomantics buildo/h2database.  //Access the H2 Console at: http://localhost:8080/h2-console
                                                                                              //jdbc:h2:mem:globomantics (sa/ )
                                                                                              //jdbc:h2:tcp://globomantics/my-db-name
       
    docker run --name my-h2 -d buildo/h2database              //jdbc:h2:tcp://my-h2/my-db-name
    docker run --name my-h2 -p 8082:8082 -d buildo/h2database // Then in your browser open http://localhost:8082/ and use the following connection parameters:
                                                              // Driver Class: org.h2.Driver JDBC URL: jdbc:h2:my-db-name User Name: (empty) Password: (empty)
    ```  
    - [docker-h2](https://hub.docker.com/r/oscarfonts/h2/)
    ```
    docker pull oscarfonts/h2
    docker images
    #Run as a service, exposing ports 1521 (TCP database server) and 8080 (web interface) and mapping DATA_DIR to host:
    docker run -d -p 1521:1521 -p 8080:8080 -v /path/to/local/data_dir:/opt/h2-data --name=MyH2Instance oscarfonts/h2
    #http://localhost:8080
    docker logs -f MyH2Instance
    ```
- [postgres](https://hub.docker.com/_/postgres)  
   ```
   docker pull postgres
   docker images
   docker run -itd --rm -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRES_DB=my_db_movie -p 5432:5432 --name my_db_movie postgres
   ```
- [greenmail](https://hub.docker.com/r/greenmail/standalone)
  - [GitHub GreenMail](https://github.com/greenmail-mail-test/greenmail#greenmail)
  - [About GreenMail](https://greenmail-mail-test.github.io/greenmail/#deploy_docker_standalone)
  ```
  docker run -d -h greenmail --name greenmail -p 3025:3025 -p 3143:3143 greenmail/standalone
  
  curl --url "imap://localhost:3143" --user "pedro@example.com:pedro@example.com" --request "EXAMINE INBOX"  
  curl --url "imap://localhost:3143/INBOX;UID=1" --user "pedro@example.com:pedro@example.com"
  ```
  
Resume
```
docker start rabbitmq, 15672
docker start greenmail, 3143
GlobomanticBillingApplication, 8083
GlobomanticServiceApplication, back-end, 8081  og H2: 8082 with docker image
GlobomanticWebApplication, front-end, 8080 and 8080/h2-console
```

- Run backend and frontend modules:
  - Run one instances of frontend
    ```
    mvn -pl web spring-boot:run
    ```
  - Run two instances of backend and listen in the same queue in the RabbitMQ
    ```
    mvn -pl service spring-boot:run
    ```

Note: -pl,--projects <arg> : Comma-delimited list of specified reactor projects to build instead of all projects. A project can be specified by [groupId]:artifactId or by its relative path.

  
## The Dead Letter Channel (DLC) integration pattern
- [Messaging Patterns](https://www.enterpriseintegrationpatterns.com/patterns/messaging/DeadLetterChannel.html)

## Message Construction Patterns
- Command Message	: It is a message used when an application needs to invoke functionality provided by another application.
					: It is a regular message that contains a command
					: It enforced loose coupling and helps future proof the integration of systems over normal RPC calls
- Document Message	: It is used when an application would like to transfer data to another application.
					: It is used to transfer data to another component 
					: It can contain a single piece of data or a data structure which may decompose into smaller pieces of data
					: It enforced loose coupling and helps future proof the integration of systems over normal file transfer or shared database options
- Request-Replay Message : It is used to facilitate a two-way conversation via messaging. 
						 : Comunication beetween two applications
						 : The sender sends a request message through a channel and the receiver sends the reply through a reply channel
						 : It enforces loose coupling and helps future proof the integration of systems over RPC or Web Service calls
- Event Mesage 	: when its internal state has changed. Other applications can integrate with that application by listening to its events.
				: Publish events when his internal state exchange
				: A Subject publishes an event to a channel. Observers receive the event and process it
				: It is used to allow one application to notify other applications of changes to its internal state
				: It enforces loose coupling and allows other applications to integrate with it
				
## Designing an Error Handling Strategy for Different Integration Scenarios
- Errors in an asynchronous application
    - Handling errors when the message publisher is no longer available to receive the error
	- Execute code that can throw an exception in a try block
    - Catch exceptions in a catch block
	
- Error Handling in a Request-Replay Message Patterns
  - The sender sends a request message through a channel and the receiver sends the reply through a reply channel
  - Request-Reply Channels
    - Direct Channel : Sender and receiver share the same thread
	- Rendezvous Channel : Queuing Channel that uses a synchronous queue
  - When using the request-reply message pattern, error handling can be accomplished using standard exception handling	
  - Both Direct and Rendezvous channels work this way

- Error Handling in Asynchronous Message Channels
  - Handling errors when the message publisher is available to receive the error
  - Spring Integration Error Channels
    - Global Error Channel : Created by Spring Integration to catch all exceptions without an explicitly defined error channel
	- Custom Error Channel : An error channel that you create and specify in your messaging gateway
  - When an asynchronous message receiver cannot handle a message, it throws an exception that gets published to an error channel	
  - There are two types of error channels: the global error channel and custom error channels

- Custom Error Channels
  - A custom error channel is defined in your configuration class as a PublishSubscribeChannel
  - The gateway is configured to publish errors to the custom error channel through its “errorChannel” property
  - The error handler is subscribed to the custom error channel

- Dead Letter Channels : When a messaging system determines that it cannot or should not deliver a message, it may elect to move the message to a Dead Letter Channel
  - Example: Amazon SQS, When a consumer retrieves a message from a queue, the message remains hidden on the queue. After processing the message, the consumer is responsible for deleting the message. If it does not delete the message in the allotted time, it becomes visible again. Once a message has been retrieved a certain number of times, SQS moves it to a dead letter queue.
