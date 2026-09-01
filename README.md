# Simple HttpServer
A simple server-side application with a database. 
I am developing this project for learning purpose.
This project is under development.


## Features
- Built on [JDK's built-in HTTP server](https://docs.oracle.com/en/java/javase/25/docs/api/jdk.httpserver/com/sun/net/httpserver/package-summary.html)
- Send back simple HTTP Response
- Listen loopback address on port 8080
- Validate Path and the information of students

## Stack
- [Java 25](https://www.oracle.com/java/technologies/downloads/#java21)
- [Apache Maven 3.9.11](https://maven.apache.org/download.cgi)
- [Jackson-Databind](https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind)
- [Mockito-Core 5.23.0](https://mvnrepository.com/artifact/org.mockito/mockito-core)
- [JUnit Jupiter API 5.11.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.0)
- [JUnit Jupiter Params 5.11.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params)
- [PostgreSQL JDBC Driver 42.7.13](https://mvnrepository.com/artifact/org.postgresql/postgresql/42.7.13)

## Architecture
- Maven Architecture

## Setup Instruction
- Run App class with Java command

## Environment Variables
- Database's pass (not implemented yet)

## Testing
- Each test must include input, 
expected result, actual result, pass/fail
- [x] 3 normal cases
- [x] 3 edge cases
- [x] 3 failure cases

## Security Notes
- Avoid hard-coding database path and login pass in source code.

## Future Improvements
- Test this application. For instance, boundary checking.
- Use variables for configuration

## Goals of the server-side programming.
- To implement the Controller and Service layers.
- To implement a simple server.
- To show the result on a browser based on requests.
- To implement a dispatcher that creates contexts based on the request’s URI path.

## RoadMap
- [x] Define a controller interface
- [x] Modify the routing map so that the router selects a controller instance.
- [x] Implement the controller that parse JSON and get the HttpExchange instance.
- [x] Move the mapping DTO logic from Service layer to Controller layer.
- [ ] ~~Implement request body field in RequestDTO record class.~~
- [x] ~~Change controllers to singleton.~~
- [x] Change DI from Dispatcher to controllers in App class.
- [ ] ~~Change the logic of the supplier interface from new instance to get instance~~
- [x] Implement setting up the routing map in the App class.
- [x] Prepare mock data for the controller test.
- [x] Implement the Repository layer connects to PostgreSQL with JDBC.
- [ ] Create GET endpoint.
