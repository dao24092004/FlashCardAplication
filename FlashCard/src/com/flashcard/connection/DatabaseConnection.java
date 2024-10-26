package com.flashcard.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE = "FlashCard";
    private static final String USERNAME = "system";
    private static final String PASSWORD = "1234$";
    private static final String CONNECTION_URL = "jdbc:sqlserver://" + SERVER + ":" + PORT + ";databaseName=" + DATABASE + ";encrypt=false";


    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connectToDatabase() throws SQLException {
        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi nạp thư viện");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
            throw e;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
