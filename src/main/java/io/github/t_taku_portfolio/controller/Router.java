package io.github.t_taku_portfolio.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class Router {
    //this class indicate the controller to handle based on a given path
    private static final Router INSTANCE = new Router();

    private final Map<String, Supplier<Controller> > routingTable = new HashMap<>();

    private Router() {
        // The following code was moved to App class
        // the controller name is sample
        // need to rename the corresponding controller name
        // routingTable.put("/students", StudentsController::new);
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    public static Router getInstance() {
        return INSTANCE;
    }

    public Optional<Supplier<Controller>> resolve(String path) {
        if(path == null) return Optional.empty();

        String theKey = path;
        if(path.startsWith("/students/")) {
            theKey = "/students";
        }

        Supplier<Controller> supplier = routingTable.get(theKey);

        // return a supplier that can contain null object if the path is not found
        return Optional.ofNullable(supplier);
    }

    public void addRoute(String path, Supplier<Controller> supplier) {
        routingTable.put(path, supplier);
    }
}