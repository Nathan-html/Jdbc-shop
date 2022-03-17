package com.nathan.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {

    public static Connection getInstance() throws SQLException {

        AppProperties properties = new AppProperties();
        String url = properties.readProperty("db.url");
        String user = properties.readProperty("db.user");
        String password = properties.readProperty("db.password");

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeInstance(Connection connection) throws SQLException {
        connection.close();
    }
}
