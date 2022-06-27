package com.example.comicweb.dao;

import com.example.comicweb.connect.ComicDb;
import com.example.comicweb.obj.Chapter;
import com.example.comicweb.obj.Comic;
import com.example.comicweb.obj.Page;

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

    public List<Comic> getBanner(){
        try {
            String query = "select id, name, cover, author, state, view, content from comic";
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            List<Comic> comics = new ArrayList<>();
            while(result.next()){
                comics.add(new Comic(result.getString("id")
                        ,result.getString("name")
                        ,result.getString("cover")
                        ,result.getString("author")
                        ,result.getString("state")
                        ,result.getLong("view")
                        ,result.getString("content")
                        ,getCategory(result.getString("id"))
                        ,getChapterList(result.getString("id"))));
            }
            return comics;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Comic> getNewUpdate(){
        try {
            String query = "select id, name, cover, author, state, view, content from comic";
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            List<Comic> comics = new ArrayList<>();
            while(result.next()){
                comics.add(new Comic(result.getString("id")
                        ,result.getString("name")
                        ,result.getString("cover")
                        ,result.getString("author")
                        ,result.getString("state")
                        ,result.getLong("view")
                        ,result.getString("content")
                        ,getCategory(result.getString("id"))
                        ,getChapterList(result.getString("id"))));
            }
            return comics;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Comic getComic(String comicId){
        try {
            String query = "select id, name, cover, author, state, view, content from comic where id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, comicId);
            ResultSet result = statement.executeQuery();
            return result.next() ?
                    new Comic(result.getString("id")
                    ,result.getString("name")
                    ,result.getString("cover")
                    ,result.getString("author")
                    ,result.getString("state")
                    ,result.getLong("view")
                    ,result.getString("content")
                    ,getCategory(comicId)
                    ,getChapterList(comicId))
                    : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Chapter> getChapterList(String comicId){
        try {
            String queryPagesChapter = "select * from chapter where comic_id = ?";
            statement = connection.prepareStatement(queryPagesChapter);
            statement.setString(1, comicId);
            List<Chapter> chapters = new ArrayList<>();
            ResultSet result = statement.executeQuery();
            while (result.next()){
                chapters.add(new Chapter(result.getString("id")
                        ,result.getInt("number")
                        ,result.getString("title")
                        ,result.getInt("view")
                        ,result.getDate("time_update")
                        ,getPages(result.getString("id"))));
            }
            return chapters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Chapter getChapter(String chapterId) {
        try {
            String queryChapter = "select * from chapter where id = ?";
            statement = connection.prepareStatement(queryChapter);
            statement.setString(1, chapterId);
            ResultSet resultC = statement.executeQuery();
            return resultC.next() ?
                    new Chapter(resultC.getString("id")
                                ,resultC.getInt("number")
                                ,resultC.getString("title")
                                ,resultC.getInt("view")
                                ,resultC.getDate("time_update")
                                ,getPages(chapterId))
                    : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Page> getPages(String chapterId){
        try {
            String queryPagesChapter = "select number, url from page where chapter_id = ?";
            statement = connection.prepareStatement(queryPagesChapter);
            statement.setString(1, chapterId);
            List<Page> pages = new ArrayList<>();
            ResultSet resultP = statement.executeQuery();
            while (resultP.next()){
                pages.add(new Page(resultP.getInt("number"),
                        resultP.getString("url")));
            }
            return pages;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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

    public List<Comic> searchComic(String name) {
        List<Comic> comics = new ArrayList();
        ResultSet result =null;
        try {
            statement = connection.prepareStatement("select id, name, cover, author, state, view, content FROM comic WHERE name LIKE ? ");
            statement.setString(1, name);
            result = statement.executeQuery();
            while (result.next()) {
                comics.add(new Comic(result.getString("id")
                        ,result.getString("name")
                        ,result.getString("cover")
                        ,result.getString("author")
                        ,result.getString("state")
                        ,result.getLong("view")
                        ,result.getString("content")
                        ,getCategory(result.getString("id"))
                        ,getChapterList(result.getString("id"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return comics;
    }

}
