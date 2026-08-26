package io.github.t_taku_portfolio;

import com.sun.net.httpserver.HttpServer;
import io.github.t_taku_portfolio.controller.*;
import io.github.t_taku_portfolio.repository.ConcreteRepository;
import io.github.t_taku_portfolio.service.ConcreteService;
import io.github.t_taku_portfolio.service.Service;
import io.github.t_taku_portfolio.service.ServiceImp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) {
        // invoke instances from 3-tier architecture packages

        // Here's the bootstrapping
        // repository layer
        ConcreteRepository repository = new ConcreteRepository();

        // service layer
        Service service = new ConcreteService(repository);
        ServiceImp serviceImp = new ServiceImp(repository);

        // controller layer
        // MyHandler studentsHandler = new MyHandler(service);
        Dispatcher dispatcher = new Dispatcher(service);
        StudentsController studentsController = new StudentsController(serviceImp);

        // set up routing map here
        Router routingTable = Router.getInstance();
        routingTable.addRoute("/students", () -> studentsController);

        // set IP address to connect
        InetAddress ipAddress = InetAddress.getLoopbackAddress();
        int port = 8080;
        int backlog = 50;

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(ipAddress, port), backlog);

            //create an endpoint that accepts all paths
            //server.createContext("/students", studentsHandler);
            server.createContext("/", dispatcher);

            System.out.println("*** Starting server ***");
            System.out.println("-----------------------------------");

            //starts the server from here
            server.start();
            System.out.println("Server successfully bound to " + ipAddress.getHostAddress()
                    + ", Port " + port);

            System.out.println("-----------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}