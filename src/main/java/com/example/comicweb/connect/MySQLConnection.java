package com.example.comicweb.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements IConnection {
    private static final String LINK_DRIVER = "com.mysql.cj.jdbc.Driver";
    private String dbUrl;
    private String userName;
    private String password;

    public MySQLConnection(String dbUrl, String userName, String password){
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName(LINK_DRIVER);
            return DriverManager.getConnection(dbUrl, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
