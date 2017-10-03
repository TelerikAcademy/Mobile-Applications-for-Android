package com.minkov.demos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Book book = new Book("Title here", "2nd edition");
        book.save();

        List<Book> books = Book.listAll(Book.class);
        int b = 5;


    }
}
