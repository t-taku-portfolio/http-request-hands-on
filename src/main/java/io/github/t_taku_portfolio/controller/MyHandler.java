package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.github.t_taku_portfolio.model.StudentRequestDTO;
import io.github.t_taku_portfolio.service.Service;

import java.io.IOException;
import java.io.OutputStream;

@Deprecated
public class MyHandler implements HttpHandler {
    private final Service service;

    public MyHandler(Service theService) {
        this.service = theService;
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // String responseBody;
        StringBuilder responseBuilder = new StringBuilder();

        // 1. input request data into DTO
        StudentRequestDTO requestDTO = new StudentRequestDTO(
                exchange.getRequestMethod(),
                exchange.getRequestHeaders().getFirst("Content-Type"),
                exchange.getRequestURI().normalize().getPath()
        );

        // 2. give DTO to service, and have service validatePath it
        service.setDTO(requestDTO);
        boolean isStatusOK = service.validateRequest();

        /*
        String requestMethod = "Your request method is " + requestDTO.method() + "\n";
        String requestContentType = "Your content-type is " + requestDTO.contentType() + "\n";
        responseBody = requestMethod + requestContentType;
         */
        responseBuilder.append("Your request method is ").append(requestDTO.method()).append("\n");
        responseBuilder.append("Your content-type is ").append(requestDTO.contentType()).append("\n");

        // 3. send response by several conditions
        if(!isStatusOK) {
            // responseBody = responseBody + "The request method is invalid";
            responseBuilder.append("The request method is invalid");

            // response status code 405 method not allowed
            sendResponse(exchange, 405, responseBuilder.toString(), null);

        } else if(service.isJson()) {
            // responseBody = responseBody + service.getJson();
            responseBuilder.append(service.getJson());

            // response status code 200 ok
            sendResponse(exchange, 200, responseBuilder.toString(), "application/json");
            //
            // put json into response body
            //

        } else {
            // responseBody = responseBody + "Request approved, but the content-type is not JSON";
            responseBuilder.append("Request approved, but the content-type is not JSON");

            // response status coed 200 ok
            sendResponse(exchange, 200, responseBuilder.toString(), null);
        }
    }


    /**
     * Helper method that sends response
     */
    public void sendResponse(HttpExchange exchange, int statusCode, String body, String contentType) throws IOException{
        if(contentType != null) {
            exchange.getResponseHeaders().set("Content-Type", contentType);
        }
        exchange.sendResponseHeaders(statusCode, body.getBytes().length);

        try(OutputStream os = exchange.getResponseBody()){
            os.write(body.getBytes());
        }
    }
}
