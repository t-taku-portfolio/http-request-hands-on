package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;

public class StudentsController {
    HttpExchange httpExchange;

    //
    // accept HttpExchange instance from the Dispatcher in constructor
    //
    StudentsController(HttpExchange theHttpExchange){
        this.httpExchange = theHttpExchange;
    }

}
