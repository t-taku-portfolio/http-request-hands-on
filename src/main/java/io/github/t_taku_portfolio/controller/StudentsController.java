package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.RequestDTO;
import io.github.t_taku_portfolio.service.Service;

import java.io.IOException;

public class StudentsController implements Controller {
    private static StudentsController instance;
    private final Service service;

    private StudentsController(Service theService) {
        this.service = theService;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // business logic here

        // extract the request body as a JSON file using Jackson library



        // store the data from client into DTO
        RequestDTO dto1 = new RequestDTO(
                "method",
                "contentType",
                "path"
        );
    }

    public static void initialize(Service theService) {
        if(instance == null) instance = new StudentsController(theService);
    }

    public static StudentsController getInstance() {
        return instance;
    }
}
