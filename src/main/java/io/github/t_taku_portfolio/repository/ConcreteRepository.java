package io.github.t_taku_portfolio.repository;


import io.github.t_taku_portfolio.model.StudentBodyDTO;

public class ConcreteRepository implements Repository{
    public  ConcreteRepository() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    public boolean save(StudentBodyDTO dto) {
        int rows = 0;

        JDBCExecutor executor = new JDBCExecutor();
        try{
            rows = executor.query(dto.name(), dto.year());
        } catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        return rows > 0;
    }
}
