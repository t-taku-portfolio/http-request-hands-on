package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.RequestDTO;
import io.github.t_taku_portfolio.model.StudentBodyDTO;
import io.github.t_taku_portfolio.service.Service;
import tools.jackson.core.JacksonException;

import java.io.IOException;

public class StudentsController implements Controller {
    private final Service service;

    public StudentsController(Service theService) {
        this.service = theService;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // business logic here

        // extract the request body as a JSON file using Jackson library
        try {
            StudentBodyDTO dto = JsonUtil.getInstance()
                            .readValue(httpExchange.getRequestBody(), StudentBodyDTO.class);
        } catch (JacksonException e) {
            // send status code only
            System.err.println("JacksonException: " + e.getMessage());
            httpExchange.sendResponseHeaders(400, 0);
        }


        // store the data from client into DTO
        RequestDTO dto1 = new RequestDTO(
                "method",
                "contentType",
                "path"
        );
    }

    /*
    public static StudentsController getInstance() {
        return instance;
    }
    */
}
