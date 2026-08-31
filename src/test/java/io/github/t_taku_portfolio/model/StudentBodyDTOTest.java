package io.github.t_taku_portfolio.model;

import org.junit.jupiter.api.Test;

public class StudentBodyDTOTest {
    @Test
    public void normalCase() {
        StudentBodyDTO studentBodyDTOtest = new StudentBodyDTO(
                "name", 4);
    }

    public void edgeCase() {}

    public void failCase() {}
}
