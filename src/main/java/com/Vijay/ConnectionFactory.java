package com.Vijay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

//create object to esablished connection;
//kitne bhi object bnaye per constructor ek bar hi memory le --

public class ConnectionFactory {

    private static Connection connection = null;
    private ConnectionFactory() {}
    public static Connection getConnection() {
        if (connection == null) {
            ResourceBundle resourceBundle=ResourceBundle.getBundle("dbConfig");
            String url = resourceBundle.getString("url");
            String username = resourceBundle.getString("username");
            String password = resourceBundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}

//class generate {
//    Connection f1 = ConnectionFactory.getConnection();
//}
