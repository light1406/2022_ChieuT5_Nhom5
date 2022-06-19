package com.example.comicweb.dao;

import com.example.comicweb.obj.Chapter;
import com.example.comicweb.obj.Comic;

import java.util.ArrayList;
import java.util.List;

public class ComicDao {
    private List<Comic> comics = new ArrayList<>();
    {

    }

    public static ComicDao comicDao;

    private ComicDao(){}

    public static ComicDao getInstance() {
        if (comicDao == null) comicDao = new ComicDao();
        return comicDao;
    }

    public List<Comic> getBanner(){return null;}
    public List<Comic> getNewUpdate(){return null;}
    public Comic getComic(String comicId){return null;}
    public Chapter getChapter(String chapterId) {return null;}
}
