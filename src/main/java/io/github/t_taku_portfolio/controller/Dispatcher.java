package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.github.t_taku_portfolio.model.RequestDTO;
import io.github.t_taku_portfolio.service.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Supplier;

public class Dispatcher implements HttpHandler {
    private final Service service;
    private final Router router;

    public Dispatcher(Service theService) {
        this.service = theService;
        router = Router.getInstance();
        System.out.println("in constructor: " + getClass().getSimpleName());
    }


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        int statusCode;
        StringBuilder responseBuilder = new StringBuilder();
        String contentType;

        RequestDTO dto = new RequestDTO(
                exchange.getRequestMethod(),
                exchange.getRequestHeaders().getFirst("Content-Type"),
                exchange.getRequestURI().normalize().getPath()
        );

        // dispatch the exchange to contexts based on the path
        boolean isStatusOk;

        Optional<Supplier<Controller>> optional = router.resolve(dto.path());
        if(optional.isPresent()) {

            statusCode = 200;

            // invoke the handle method of controller
            optional.get().get().handle(exchange);

            // If the client requests JSON, response students JSON
            responseBuilder.append(service.getJson());
            contentType = "application/json";
        } else {

            statusCode = 404;
            responseBuilder.append("The requested URL doesn't exist.");
            contentType = "text/plain";

            ResponseContext responseContext = new ResponseContext(exchange, dto);

            responseContext.sendResponse(statusCode, responseBuilder.toString(), contentType);
        }
    }
}
