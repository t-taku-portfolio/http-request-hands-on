# Simple HttpServer
A simple server-side application with a database. 
I am developing this project for learning purpose.
This project is under development.


## Features
- Accept HTTP Request
- Send back simple HTTP Response
- Listen loopback address on port 8080
- Validate Path and the information of students

## Stack
- [Java SE21](https://www.oracle.com/java/technologies/downloads/#java21)
- [Apache Maven 3.9.11](https://maven.apache.org/download.cgi)
- [Jackson-Databind](https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind)

## Architecture
- Maven Architecture

## Setup Instruction
- Run App class with Java command

## Environment Variables
- Database's pass (not implemented yet)

## Testing
- Implement later. Each test must include input, 
expected result, actual result, pass/fail
- 3 normal cases
- 3 edge cases
- 3 failure cases

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
- Define a controller interface
- [Done] Modify the routing map so that the router selects a controller instance.
- Implement the controller that parse JSON and get the HttpExchange instance.
- Move the mapping DTO logic from Service layer to Controller layer.
- Implement request body field in RequestDTO record class.