package com.minkov.navigationdemos.models;

import java.io.Serializable;

/**
 * Created by minkov on 1/27/17.
 */

public class Book implements Serializable {

    private String isbn;

    private String title;

    public Book(String isbn, String title) {
        this.setIsbn(isbn);
        this.setTitle(title);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
