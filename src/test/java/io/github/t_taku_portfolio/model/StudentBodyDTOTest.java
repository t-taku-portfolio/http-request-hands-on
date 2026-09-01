package io.github.t_taku_portfolio.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentBodyDTOTest {
    @Test
    public void normalCase() {
        // Check if the method works with the happy path
        StudentBodyDTO studentBodyDTOtest = new StudentBodyDTO(
                "name", 4);
    }
    @Test
    public void edgeCase1() {
        // Check if the method works with the boundary arguments
        StudentBodyDTO studentBodyDTOtest1 = new StudentBodyDTO(
                "name", 1
        );

        StudentBodyDTO studentBodyDTOtest2 = new StudentBodyDTO(
                "name", 6
        );
    }

    @Test
    public void failCase() {
        // Check if the method throws expected exception
        // Specify the expected exception and function as arguments

        Throwable exception1 = assertThrows(
                IllegalArgumentException.class,
                () -> new StudentBodyDTO("name", 0)
        );

        Throwable exception2 = assertThrows(
                IllegalArgumentException.class,
                () -> new StudentBodyDTO("name", 7)
        );
    }
}
