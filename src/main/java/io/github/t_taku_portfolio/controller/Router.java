package io.github.t_taku_portfolio.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Router {
    //this class indicate the controller to handle based on a given path
    private static final Router INSTANCE = new Router();

    private final Map<String, String> routingTable = new HashMap<>();

    private Router() {
        // the controller name is sample
        // need to rename the corresponding controller name
        routingTable.put("/students", "StudentsController");
    }

    public static Router getInstance() {
        return INSTANCE;
    }

    public Optional<String> resolve(String path) {
        if(path == null) return Optional.empty();

        String theKey = path;
        if(path.startsWith("/students/")) {
            theKey = "/students";
        }

        return Optional.ofNullable(routingTable.get(theKey));
    }
}