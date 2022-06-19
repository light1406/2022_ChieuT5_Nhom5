package com.example.comicweb.obj;

public class Page {
    private int number;
    private String url;

    public Page(){}

    public Page(int number, String url) {
        this.number = number;
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
    }
}
