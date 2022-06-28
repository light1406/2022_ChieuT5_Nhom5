package com.example.comicweb.dao;

import com.example.comicweb.connect.ComicDb;
import com.example.comicweb.obj.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {
    private Connection connection;
    private PreparedStatement statement;

    public static UserDao userDao;

    private UserDao(){
        connection = ComicDb.getInstance().getConnection();
    }

    public static UserDao getInstance() {
        if (userDao == null) userDao = new UserDao();
        return userDao;
    }

    public boolean register(User user){
        //truy van co so du lieu de them doi tuong user vao bang user
        return false;
    }
}
