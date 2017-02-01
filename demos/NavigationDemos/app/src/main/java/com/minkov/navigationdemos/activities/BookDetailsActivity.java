package com.minkov.navigationdemos.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.minkov.navigationdemos.R;
import com.minkov.navigationdemos.fragments.BookDetailsFragment;
import com.minkov.navigationdemos.models.Book;

import java.io.Serializable;

public class BookDetailsActivity extends DrawerNavigationActivityBase {
    public static final String BOOK_KEY = "book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Intent intent = this.getIntent();

        Book book = (Book) intent.getSerializableExtra(BOOK_KEY);

        Fragment fragment =
                BookDetailsFragment.createFragment(book);

        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_fragment, fragment)
                .commit();
    }
}
