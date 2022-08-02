package org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleFactory {
    private static Connection connection = null;
    public static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    public static final String DRIVER = "oracle.jdbc.OracleDriver";

    public static Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(DB_URL, "ALexus", "lyoha222");

                if (!connection.isClosed()) {
                    System.out.println("Connected successfully!");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public DAOAccess getDAO() {
        return new DAOImpl();
    }
}
