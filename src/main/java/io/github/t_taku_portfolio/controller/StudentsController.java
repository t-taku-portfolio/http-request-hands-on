package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.RequestDTO;
import io.github.t_taku_portfolio.model.StudentBodyDTO;
import io.github.t_taku_portfolio.service.ServiceImp;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;

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
            service.doSomething();


        } catch (JacksonException e) {
            System.err.println("JacksonException: " + e.getMessage());

            // send an error message
            // Map<String, String> responseBody = Map.of("Content-Type", "application/json");
            String responseBody = "400: Invalid request";
            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
            httpExchange.sendResponseHeaders(400, objectMapper.writeValueAsString(responseBody).length());

            try(OutputStream os = httpExchange.getResponseBody()) {
                os.write(objectMapper.writeValueAsBytes(responseBody));
            }
        }


        // store the data from client into DTO
        RequestDTO dto1 = new RequestDTO(
                "method",
                "contentType",
                "path"
        );
    }

    private static ObjectMapper getInstance() {
        return JsonUtil.getInstance();
    }

    /*
    public static StudentsController getInstance() {
        return instance;
    }
    */
}
