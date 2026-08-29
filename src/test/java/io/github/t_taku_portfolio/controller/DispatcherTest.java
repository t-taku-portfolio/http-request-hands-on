package io.github.t_taku_portfolio.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class DispatcherTest {

    @Test
    public void normalCaseTest() {
        Router mockRouter = Mockito.mock(Router.class);
        Controller mockController = Mockito.mock(Controller.class);

        Mockito.when(mockRouter.resolve("/students"))
                .thenReturn(Optional.of(() -> mockController));
    }

    public void edgeCaseTest() {
    }

    public void failureCaseTest() {
    }

    private static class DynamicProxy {
        // define dynamic proxy here for mock test if needed
    }
}
