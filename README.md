# Spring Boot Apache Kafka

### Spring Boot Apache Kafka Basic Sample

### Tech Stack

```
 - Java 11
 - Spring Framework
 - Apache Kafka
 - Integration Test
```

### Requirements

For building and running the application you need :

```
- JDK 11   
- Maven    
- Docker   
```

### Build & Run

###### Docker

```
  docker-compose up
```

###### Backend

```
  mvn clean install 
```

```
  mvn --projects your-service spring-boot:run
```

###### Request
```
  curl -X POST -F 'message=Hello Mehmet' http://localhost:8080/api/v1/kafka
```
