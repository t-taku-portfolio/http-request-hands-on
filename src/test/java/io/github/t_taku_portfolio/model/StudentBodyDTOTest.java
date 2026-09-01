package io.github.t_taku_portfolio.model;

import org.junit.jupiter.api.Test;

public class StudentBodyDTOTest {
    @Test
    public void normalCase() {
        StudentBodyDTO studentBodyDTOtest = new StudentBodyDTO(
                "name", 4);
    }
    @Test
    public void edgeCase1() {
        StudentBodyDTO studentBodyDTOtest1 = new StudentBodyDTO(
                "name", 1
        );

        StudentBodyDTO studentBodyDTOtest2 = new StudentBodyDTO(
                "name", 6
        );
    }

    public void failCase() {}
}
