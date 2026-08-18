package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.StudentRequestDTO;

import java.io.IOException;

interface Controller {
    public void handle(HttpExchange httpExchange, StudentRequestDTO dto) throws IOException;
}
