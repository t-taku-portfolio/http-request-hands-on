package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.github.t_taku_portfolio.service.Service;

import java.io.IOException;

@Deprecated
public class UniversalHandler implements HttpHandler {
    private final Service service;

    public UniversalHandler(Service theService) {
        System.out.println("in constructor: " + getClass().getSimpleName());
        this.service = theService;
    }


    @Override
    public void handle(HttpExchange exchange) throws IOException {

    }
}
