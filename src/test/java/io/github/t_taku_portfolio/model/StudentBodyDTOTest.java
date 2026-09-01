package io.github.t_taku_portfolio.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentBodyDTOTest {
    @Test
    public void normalCase() {
        // Check if the method works with the happy path
        StudentBodyDTO studentBodyDTOtest1 = new StudentBodyDTO("taro", 4);
        StudentBodyDTO studentBodyDTOtest2 = new StudentBodyDTO("hanako", 1);
        StudentBodyDTO studentBodyDTOtest3 = new StudentBodyDTO("jiro", 2);
    }

    @Test
    public void edgeCase1() {
        // Check if the method works with the boundary arguments
        StudentBodyDTO studentBodyDTOtest1 = new StudentBodyDTO("jim", 1);
        StudentBodyDTO studentBodyDTOtest2 = new StudentBodyDTO("mike", 6);
        StudentBodyDTO studentBodyDTOtest3 = new StudentBodyDTO("curly", 1);
    }

    @Test
    public void failCase() {
        // Check if the method throws expected exception
        // Specify the expected exception and function as arguments

        Map<String, Integer> students = Map.of("taro", -1, "hanako", 7, "太郎", 1);
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new StudentBodyDTO(entry.getKey(), entry.getValue()));
        }
    }
}
