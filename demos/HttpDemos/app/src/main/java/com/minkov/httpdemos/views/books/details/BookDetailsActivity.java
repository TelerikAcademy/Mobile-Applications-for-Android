package com.minkov.httpdemos.views.books.details;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.httpdemos.R;
import com.minkov.httpdemos.views.books.models.Book;

public class BookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Intent intent = this.getIntent();

        Book book = (Book) intent.getSerializableExtra("book");

        Fragment fragment = BookDetailsFragment.create(book);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_book_details, fragment)
                .commit();
    }
}
