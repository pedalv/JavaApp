# Spring 5 Integration 
- An implementation of the Enterprise Integration Patterns based on the Spring Framework
- [Spring Integration 6](https://spring.io/projects/spring-integration)
- [Enterprise Integration Patterns](https://www.enterpriseintegrationpatterns.com/)
- Event - based Sender like: AMQP, Kafka - [SAP Cloud Integration: Asynchronous Messaging Best Practices](https://www.integration-excellence.com/sap-cpi-asynchronous-messaging-best-practices/)
- The Advanced Message Queuing Protocol (AMQP)
  - MQP is an open source published standard for asynchronous messaging by wire. 
  - AMQP enables encrypted and interoperable messaging between organizations and applications. 
  - The protocol is used in client/server messaging and in IoT device management.

## Enterprise Integrations Patterns
- Message
  - Headers (Metadata) + Playload (Application-specific content)

- Message Channel
  - Point-to-point channel: one sender, one receiver. Example: Queue
  - Publish-subscribe channel: One sender, multiple receivers. Example: Event notifications

-  Message endpoint
  - Channel adapter
  - Gateway
  - Service activator

- Message transform
- Message Routing/filtring

##Spring Integration
- Message Channel
  - Provider (sender)(Publish)(Store/Save/Activator), Consumer (receiver)(Subscribe)(Push/Pull)
  - Subscribable channels (Event-Driven Consumer):
    - Unicasting dispatcher (Point-to-point channel)
      - DirectChannel
      - ExecutorChannel
    - Broadcasting dispatcher (Publish-subscribe channel)
      - PublishSubscribeChannel
    - Push: subscribe(MesssageHandler handler)/unsubscribe(MesssageHandler handler)
    - Non-buffering
    - Publish-subscribe channel: One sender, multiple receivers. Example: Event notifications
  - Pollable  channels (Polling Consumer)
    - QueueChannel
      - Buffers messages in an in-memory queue
      - Unbounded capacity
    - RendezvousChannel
      - Zero-capacity queue
      - Block until sender and receiver meet
    - PriorityChannel
      - Buffers messages in a priority queue
      - Default ordering by "priority" header
    - Pull: receive()/receive(long timeout)
    - Buffering    
    - Point-to-point channel: one sender, one receiver. Example: Queue

##Using a Message Broker (RabbitMQ/Kafka) for Point-to-Point Messaging
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

    