package io.github.t_taku_portfolio.service;

import io.github.t_taku_portfolio.model.StudentRequestDTO;

public interface Service {
    public void setDTO(StudentRequestDTO theDTO);
    public boolean validateRequest();
    public boolean isJson();
    public String getJson();

}
