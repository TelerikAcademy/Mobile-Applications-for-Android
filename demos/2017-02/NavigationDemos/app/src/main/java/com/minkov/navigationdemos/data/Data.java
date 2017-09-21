package com.minkov.navigationdemos.data;

import com.minkov.navigationdemos.models.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minkov on 1/27/17.
 */

public class Data {
    private static ArrayList<Book> books;

    static {
        books = new ArrayList<Book>();

        int count = 100;
        for (int i = 0; i < count; i++) {
            String isbn = "ISBN" + i;
            String title = "Title #" + (i + 1);
            books.add(new Book(isbn, title));
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public Book getBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }

        return null;
    }

    public Book createBook(String isbn, String title) {
        Book book = new Book(isbn, title);
        books.add(book);
        return book;
    }

}
