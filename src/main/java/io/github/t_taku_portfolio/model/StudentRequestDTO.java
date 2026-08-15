package io.github.t_taku_portfolio.model;

public record StudentRequestDTO(
        String method,
        String contentType,
        String path
) {
    public StudentRequestDTO {
        Validator.validatePath(path);
        Validator.validateMethod(method);
    }
}
