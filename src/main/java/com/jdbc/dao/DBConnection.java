package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "idbc_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // JDBC URL
    private static final String URL = String.format(
            "jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC",
            HOST, PORT, DB_NAME
    );

    // Static connection reference
    private static Connection connection = null;

    // Method to get a connection
    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Only create a new connection if it's null or closed
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("✅ Database connection established successfully.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found! Make sure the connector JAR is in your classpath.");
            e.printStackTrace();
        } catch (SQLException se) {
            System.err.println("❌ Failed to connect to the database! Check your DB credentials and settings.");
            se.printStackTrace();
        }
        return connection;
    }
}
