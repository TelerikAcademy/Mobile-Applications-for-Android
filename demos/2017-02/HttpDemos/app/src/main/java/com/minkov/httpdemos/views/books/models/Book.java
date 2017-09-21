package com.minkov.httpdemos.views.books.models;

import java.io.Serializable;

public class Book implements Serializable {
    private String id;
    private String title;

    public Book() {

    }

    public Book(String id, String title) {
        this.setId(id);
        this.setTitle(title);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }
}
