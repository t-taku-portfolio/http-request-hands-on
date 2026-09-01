package io.github.t_taku_portfolio.controller;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

public class DispatcherTest {

    @Test
    public void normalCaseTest() throws IOException {
        Router mockRouter = Mockito.mock(Router.class);
        Controller mockController = Mockito.mock(Controller.class);

        Mockito.when(mockRouter.resolve("/students"))
                .thenReturn(Optional.of(() -> mockController));

        Dispatcher dispatcher = new Dispatcher(mockRouter);

        Headers mockHeaders = Mockito.mock(Headers.class);
        Mockito.when(mockHeaders.getFirst("Content-Type")).thenReturn("application/json");

        HttpExchange mockExchange = Mockito.mock(HttpExchange.class);
        Mockito.when(mockExchange.getRequestMethod()).thenReturn("GET");
        Mockito.when(mockExchange.getRequestURI()).thenReturn(URI.create("/students"));
        Mockito.when(mockExchange.getRequestHeaders()).thenReturn(mockHeaders);

        dispatcher.handle(mockExchange);
        Mockito.verify(mockController).handle(mockExchange);
    }

    @Test
    public void edgeCaseTest() {
    }

    @Test
    public void failureCaseTest() {
    }
}
