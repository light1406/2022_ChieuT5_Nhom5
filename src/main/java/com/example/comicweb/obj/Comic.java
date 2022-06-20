package com.example.comicweb.obj;

import java.util.List;

public class Comic {
    private String id;
    private String name;
    private String cover;
    private String author;
    private String state;
    private long view;
    private String content;
    private List<String> categorys;
    private List<Chapter> chapters;

    public Comic(){}

    public Comic(String id, String name, String cover, String author, String state, long view, String content, List<String> categorys, List<Chapter> chapters) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.author = author;
        this.state = state;
        this.view = view;
        this.content = content;
        this.categorys = categorys;
        this.chapters = chapters;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getCategorys() {
        return categorys;
    }

    public String getContent() {
        return content;
    }

    public long getView() {
        return view;
    }

    public String getCover() {
        return cover;
    }

    public String getState() {
        return state;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }
}
