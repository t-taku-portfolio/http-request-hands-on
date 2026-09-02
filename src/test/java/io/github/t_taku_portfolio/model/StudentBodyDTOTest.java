package io.github.t_taku_portfolio.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentBodyDTOTest {
    @Test
    public void normalCase() {
        // Check if the method works with the happy path
        Map<String, Integer> stringIntegerMap = Map.of("taro", 4, "hanako", 1, "jiro", 2);
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            StudentBodyDTO studentBodyDTO = new StudentBodyDTO(entry.getKey(), entry.getValue());
            assertEquals(entry.getKey(), studentBodyDTO.name());
            assertEquals(entry.getValue(), studentBodyDTO.year());
        }
    }

    @Test
    public void edgeCase() {
        // Check if the method works with the boundary arguments
        Map<String, Integer> stringIntegerMap = Map.of("jim", 1, "mike", 6, "curly", 1);
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            StudentBodyDTO studentBodyDTO = new StudentBodyDTO(entry.getKey(), entry.getValue());
            assertEquals(entry.getKey(), studentBodyDTO.name());
            assertEquals(entry.getValue(), studentBodyDTO.year());
        }
    }

    @Test
    public void failureCase() {
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
