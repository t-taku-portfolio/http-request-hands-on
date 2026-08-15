package io.github.t_taku_portfolio.model;

public record StudentResponseDTO(
        String name,
        int year,
        String major
) {
    public StudentResponseDTO {

        // validate name
        Validator.validateStudentName(name);

        // validatePath years
        if(year > 6 || year < 1) {
            throw new IllegalArgumentException("invalid year");
        }

        // validatePath major
        if(major.isBlank()) {
            throw new IllegalArgumentException("major is blank");
        }
    }
}
