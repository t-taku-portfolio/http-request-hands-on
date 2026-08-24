package io.github.t_taku_portfolio.controller;

import tools.jackson.databind.ObjectMapper;

public class JsonUtil {
    // handle singleton ObjectMapper instance in this class
    private static final ObjectMapper INSTANCE = new ObjectMapper();

    private JsonUtil() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    public static ObjectMapper getInstance() {
        return INSTANCE;
    }
}
