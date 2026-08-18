package io.github.t_taku_portfolio.service;

import io.github.t_taku_portfolio.model.RequestDTO;

public interface Service {
    public void setDTO(RequestDTO theDTO);
    public boolean validateRequest();
    public boolean isJson();
    public String getJson();

}
