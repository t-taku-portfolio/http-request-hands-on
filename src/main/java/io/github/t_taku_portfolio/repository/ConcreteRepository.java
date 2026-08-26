package io.github.t_taku_portfolio.repository;


public class ConcreteRepository implements Repository{
    public  ConcreteRepository() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    public boolean save(String name, int grade) {
        int rows = 0;

        JDBCExecutor executor = new JDBCExecutor();
        try{
            rows = executor.query(name, grade);
        } catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        return rows > 0;
    }
}
