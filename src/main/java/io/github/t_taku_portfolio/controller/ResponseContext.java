package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.HttpExchange;
import io.github.t_taku_portfolio.model.RequestDTO;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ResponseContext {

    private final RequestDTO dto;
    private final HttpExchange exchange;
    private final String method;
    private final String path;

    public ResponseContext(HttpExchange theHttpExchange, RequestDTO theDto) {
        this.dto = theDto;
        this.exchange = theHttpExchange;
        this.method = dto.method();
        this.path = dto.path();
    }

    @Deprecated
    public ResponseContext(HttpExchange theHttpExchange) {
        this.dto = null;
        this.exchange = theHttpExchange;
        this.method = theHttpExchange.getRequestMethod();
        this.path = theHttpExchange.getRequestURI().normalize().getPath();
    }

    public void sendResponse(int statusCode, String body, String contentType) throws IOException {
        // definite the response headers
        exchange.getResponseHeaders().set("Content-Type", contentType);
        exchange.sendResponseHeaders(statusCode, body.getBytes(StandardCharsets.UTF_8).length);

        // definite the response body
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(body.getBytes(StandardCharsets.UTF_8));
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }
}
