## RabbitMQ
- publish: 	 send msg 	- Producer - EnQueue - Virtual HOST - VH - Quorum
- Broken:    exchange, port: 5672
- subscribe: receive msg - Consumer - DeQueue

#### Communication Between Services
- RPC, Remote Procedure Call
- SOAP, Simple Object Access Protocol
- REST, Representational State Transfer
- Messaging

#### Messaging Patterns
- Point-To-Point
- RCP
- Event Broadcasting, Publish Subscribe

#### Message Brokers and MSMQ
- Centralized vs Decentralized
- Multiplatform vs Windows only
- Standardized vs No standard
- Scale with clustering vs Scales automatically
- Supported by MassTransit vs Supported by NServiceBus

#### Microservices, each individual microservice is autonomous
- A software architectural style
- Composed of small, highly decoupled independent processes 
- Communicate with each other using language-agnostic APIs
- Each process focusses on doing one small task

#### Advanced Message Queuing Protocol
![AMQP](https://github.com/pedalv/JavaApp/blob/master/CloudComputing/amqp.JPG)
- Advanced Message Queuing Protocol (AMQP)
  - AMQP is an open source published standard for asynchronous messaging by wire.

#### [Downloading and Installing RabbitMQ](https://rabbitmq.com/download.html)

#### [Client Documentation](https://www.rabbitmq.com/clients.html) - [RabbitMQ Documentation](https://www.rabbitmq.com/documentation.html)
- [Java Client API Guide](https://www.rabbitmq.com/api-guide.html)
- [.NET/C# RabbitMQ Client Library](https://www.rabbitmq.com/dotnet.html)
  - [Newtonsoft.Json ](https://www.nuget.org/packages/Newtonsoft.Json/) 
- MassTransit.RabbitMQ
  - [Using MassTransit with RabbitMQ in ASP.NET Core](https://code-maze.com/masstransit-rabbitmq-aspnetcore/)
  - [Quartz.NET](https://www.quartz-scheduler.net/)
  - [MassTransit Quartz service](https://masstransit.io/documentation/configuration/scheduling)
  - [MassTransit/Sample-Quartz](https://github.com/MassTransit/Sample-Quartz)
  - [Saga State Machines](https://masstransit.io/documentation/patterns/saga/state-machine)
- [.NET/C# Client API Guide](https://www.rabbitmq.com/dotnet-api-guide.html)
- [EasyNetQ](https://easynetq.com/) Notifications: 
  - **Publish and subscribe pattern**
    - Notifications / Broadcast 
    - Brodcast out but messages not persisted on the queue
    - Somebody need to listen the message to take action, in the forest nobody around to help
    - maybe the message will disappear because it is not store in the queue
  - **Request and response pattern**
    - Remote Procedure Calls (RPC)
    - Client will wait for a response from the receiver
    - Wait for a response from the receiver, help service as an example
  - **Send and receive pattern**
    - Target Messages / Flexible routing
    - Messages routed to queues with a routing key
    - the message is store in the queue until the system is up again to send the message to the receiver
  - **Topic Based Routing pattern**
    - Wildcard routing / Topic based publish and subscribe
    - Messages routed to queues using a wildcard based routing key
    - Flexible routing 
      - Topic Based Routing pattern
      - Send and receive directly routes messages with a routing key
      - Topic based publish and subscribe routes messages using a topic key
        - '*' can substitute for exactly one word
        - '#' can substitute for zero or more words
- [RabbitMQ extensions to AMQP 0-9-1](https://www.rabbitmq.com/extensions.html)

#### Exchange types
- Direct Exchanges
- Fanout Exchanges
- Routing keys Exchange
- Topic Exchanges
- Header Exchanges

#### Queues
- LIFO

#### Binbdings

##### Consumers

