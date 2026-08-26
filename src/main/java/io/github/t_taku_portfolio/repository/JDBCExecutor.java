package io.github.t_taku_portfolio.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExecutor {

    private final String dbPath;
    private final String username;
    private final String password;

    public JDBCExecutor() {
        this.dbPath = System.getenv("DB_DIR");
        this.username = System.getenv("DB_USER");
        this.password = System.getenv("DB_PASSWORD");

        if (this.dbPath == null || this.username == null || this.password == null) {
            throw new IllegalStateException("Environment variables missing");
        }
    }

    public int query(String name, int year) throws SQLException {
        try (Connection connection = DriverManager.getConnection(dbPath,username,password);
             PreparedStatement preparedStatement = connection.prepareStatement(SQLStatement.INSERT)
        ) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, year);

            return preparedStatement.executeUpdate();
        }
    }

}
