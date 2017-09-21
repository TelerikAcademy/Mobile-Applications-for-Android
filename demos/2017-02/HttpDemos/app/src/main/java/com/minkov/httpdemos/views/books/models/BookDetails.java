package com.minkov.httpdemos.views.books.models;

public class BookDetails extends Book {
    private String description;

    public BookDetails() {
    }

    public BookDetails(String id, String title, String description) {
        super(id, title);
        this.setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
