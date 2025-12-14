package db;

import java.sql.*;

public class DBManager {

    private static final String URL = "jdbc:mysql://localhost:3306/movie_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
