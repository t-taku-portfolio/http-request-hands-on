package io.github.t_taku_portfolio.model;

public record RequestDTO(
        String method,
        String contentType,
        String path
) {
    public RequestDTO {
        Validator.validatePath(path);
        Validator.validateMethod(method);
    }
}
