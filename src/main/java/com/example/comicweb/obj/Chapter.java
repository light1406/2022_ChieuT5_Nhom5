package com.example.comicweb.obj;

import java.util.Date;
import java.util.List;

public class Chapter {
    private String id;
    private int number;
    private String title;
    private int view;
    private Date timeUpdate;
    private List<Page> pages;

    public Chapter(){}

    public Chapter(String id, int number, String title, int view, Date timeUpdate, List<Page> pages) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.view = view;
        this.timeUpdate = timeUpdate;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public int getView() {
        return view;
    }

    public Date getTimeUpdate() {
        return timeUpdate;
    }

    public List<Page> getPages() {
        return pages;
    }

    public boolean isChapter(String id){
        return this.id.equals(id);
    }
}
