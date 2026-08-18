package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.StudentRequestDTO;
import tools.jackson.core.json.JsonFactory;

import java.io.IOException;

public class StudentsController implements Controller {
    @Override
    public void handle(HttpExchange httpExchange, StudentRequestDTO dto) throws IOException {
        // business logic here

        // extract the request body as a JSON file using Jackson library



        // store the data from client into DTO
        StudentRequestDTO dto1 = new StudentRequestDTO(
                "method",
                "contentType",
                "path"
        );
    }
}
