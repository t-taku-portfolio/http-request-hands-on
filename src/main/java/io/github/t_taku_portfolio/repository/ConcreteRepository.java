package io.github.t_taku_portfolio.repository;


import io.github.t_taku_portfolio.model.StudentBodyDTO;

public class ConcreteRepository implements Repository{
    public  ConcreteRepository() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    public boolean save(StudentBodyDTO dto) {
        int rowsUpdated = 0;

        JDBCExecutor executor = new JDBCExecutor();
        try{
            rowsUpdated = executor.query(dto.name(), dto.year());
        } catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        return rowsUpdated > 0;
    }
}
