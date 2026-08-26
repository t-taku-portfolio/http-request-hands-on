package io.github.t_taku_portfolio.repository;

import io.github.t_taku_portfolio.model.StudentBodyDTO;

public interface Repository {
    boolean save(StudentBodyDTO dto);
}
