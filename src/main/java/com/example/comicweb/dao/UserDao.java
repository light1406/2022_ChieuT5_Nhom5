package com.example.comicweb.dao;

import com.example.comicweb.connect.RegisterDb;
import com.example.comicweb.obj.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {
    private Connection connection;
    private PreparedStatement statement;

    public static UserDao userDao;

    public UserDao() {
        connection = RegisterDb.getInstance().getConnection();

    }

    public static UserDao getInstance() {
        if (userDao == null) userDao = new UserDao();
        return userDao;
    }

    public User checkUserExist(String username) {
        String query = "select * from user where username =?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return new User(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void registry(String fullName,String user, String pass, int birthYear) {
        String query = "INSERT INTO Users (fullName, username, pass, birthyear)\n" +
                "VALUES (?,?,?,?);";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, fullName);
            statement.setString(2, user);
            statement.setString(3, pass);
            statement.setInt(4, birthYear);
            statement.executeUpdate();

        } catch (Exception e) {

        }

    }

}


