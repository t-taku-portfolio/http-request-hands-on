package io.github.t_taku_portfolio.model;

public record StudentBodyDTO(
        String name,
        int year
) {
    public StudentBodyDTO {
        // validate name
        Validator.validateStudentName(name);

        // validate years
        if(year > 6 || year < 1) {
            throw new IllegalArgumentException("invalid year");
        }
    }
}
