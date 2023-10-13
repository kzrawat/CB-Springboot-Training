# citibank-ms-oct2023

    Etherpad link: https://etherpad.opendev.org/p/Citi_-_MS_using_Springboot

    Day 1:

    Spring Boot Project Steps:
        - start.spring.io
        - select web, devtools
        - import maven project
        - create controller

    JPA
        - entity (@Entity, @Id)
        - Repo extends from JpaRepo
    
    workout-service
    active-workout-service

    Postman testing
        - Collection


    Day 2:

        Microservice Communiction

        - RestTemplate to call using IP address
            *Drawback : hard-code and change code
        
        Feign Client - Declarative approach better RestTemplate, Call by Name, Load-Balancing
            - add dependency
            - application.properties 
            - @EnableFeignClient


    Day 3:
        Naming & Discovery: Eureka - Call by name

        Eureka Server
            - add dependency spring-cloud-starter-netflix-eureka-server
            - application.properties configured
            - @EnableEurekaServer
        Eureka Clients added to Active-Workout Service
            - add dependency spring-cloud-starter-netflix-eureka-client
            - @EnableDiscoveryClient
        
        Spring Config : Centralize configuration
            - Externalize --server.port=8085
        
            Git - 
                git init : Initalialize
                git add <file-name>: Add to staging area
                git commit <file-name>: Add to commit area
                git remote add origin https://github.com/puneetvashisht/citibank-ms-config.git
                git branch -M master
                git push -u origin master
            
            * Github/BitBucket/Gitlabs

            Spring Cloud Server
                - add dependency to pom.xml spring-cloud-config-server
                - update properties file
        

    Day 4 :

        API Gateway : Front Filter (Authentication/Authroization, Log) : Cross-cutting concerns
                - add dependency: spring-cloud-starter-gateway
                - Route Configuration
    
    Day 5
        Fault Tolerance : Hystrix (fallback method)
                - add depedency: spring-cloud-starter-netflix-hystrix
                - @EnableCircuitBreaker --> @EnableHystrix

                @FallbackMethod
        
        Log Tracing
                - add dependency on Lombok for easy access to logging
                - slueth: add a unique id to a request: 
                X send info to zipking server
        Zipkin Server -> capture the logs

        Spring Cloud Stream : Connect Messsage Middlewars (Kafka, RabbitMQ)
            - Message Brokers : Guarantee Message Delivery
            
        Apache Kafka : 
            1. # Start the ZooKeeper service
                $ bin/zookeeper-server-start.sh config/zookeeper.properties
            2. # Start the Kafka broker service * Default Port 9092
            $ bin/kafka-server-start.sh config/server.properties
            3. Create Topic
            4. Write(Producer) and Read(Consumer)




    
