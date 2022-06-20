package com.example.comicweb.dao;

import com.example.comicweb.connect.ComicDb;
import com.example.comicweb.obj.Chapter;
import com.example.comicweb.obj.Comic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComicDao {
    private Connection connection;
    private PreparedStatement statement;

    public static ComicDao comicDao;

    private ComicDao(){
        connection = ComicDb.getInstance().getConnection();
    }

    public static ComicDao getInstance() {
        if (comicDao == null) comicDao = new ComicDao();
        return comicDao;
    }

    public List<Comic> getBanner(){return null;}
    public List<Comic> getNewUpdate(){return null;}
    public Comic getComic(String comicId){return null;}
    public Chapter getChapter(String chapterId) {return null;}
    public List<String> getCategory(String comicId){
        try {
            List<String> category = new ArrayList<>();
            String query = "select category from category where comic_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, comicId);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                category.add(result.getString("category"));
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
