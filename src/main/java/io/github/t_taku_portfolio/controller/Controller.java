package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.RequestDTO;

import java.io.IOException;

public interface Controller {
    void handle(HttpExchange httpExchange) throws IOException;
}
