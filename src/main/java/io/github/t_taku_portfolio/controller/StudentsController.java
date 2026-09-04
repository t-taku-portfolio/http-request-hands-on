package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.StudentBodyDTO;
import io.github.t_taku_portfolio.service.ServiceImp;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class StudentsController implements Controller {
    private final ServiceImp service;

    public StudentsController(ServiceImp theService) {
        System.out.println("in constructor: " + getClass().getSimpleName());
        this.service = theService;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        ObjectMapper objectMapper = JsonUtil.getInstance();

        //
        // business logic here
        //

        // extract the request body as a JSON file using Jackson library
        try {
            StudentBodyDTO dto = objectMapper.readValue(httpExchange.getRequestBody(), StudentBodyDTO.class);
            service.setStudentBodyDTO(dto);
            boolean isSaveSucceeded = service.doSomething();

            // need to check the result of save student here
            String responseBody;
            if(isSaveSucceeded) {
                responseBody = "200: Request Successful";
                httpExchange.getResponseHeaders().set("Content-Type", "text/plain");
                httpExchange.sendResponseHeaders(200, responseBody.length());
            } else {
                responseBody = "400: Request Failed";
                httpExchange.getResponseHeaders().set("Content-Type", "text/plain");
                httpExchange.sendResponseHeaders(400, responseBody.length());
            }

            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(responseBody.getBytes(StandardCharsets.UTF_8));
            }

        } catch (JacksonException e) {
            System.err.println("JacksonException: " + e.getMessage());

            // send an error message
            // Map<String, String> responseBody = Map.of("Content-Type", "application/json");
            String responseBody = "400: Invalid request";
            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
            httpExchange.sendResponseHeaders(400, responseBody.length());

            try(OutputStream os = httpExchange.getResponseBody()) {
                os.write(responseBody.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    private static ObjectMapper getInstance() {
        return JsonUtil.getInstance();
    }
}
