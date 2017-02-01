package com.minkov.httpdemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.minkov.httpdemos.fragments.LoadingFragment;
import com.minkov.httpdemos.models.Book;
import com.minkov.httpdemos.tasks.HttpTaskWithSingleResult;

public class BookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Intent intent = this.getIntent();

        Book book = (Book) intent.getSerializableExtra("book");

        TextView tvTitle = (TextView) this.findViewById(R.id.tv_title);


        LoadingFragment loadingFragment = LoadingFragment.create(this);

        loadingFragment.show();

        new HttpTaskWithSingleResult<>(
                Book.class,
                bookDetails -> {
                    this.runOnUiThread(() -> {
                        loadingFragment.hide();
                        tvTitle.setText(bookDetails.title);
                    });
                }).execute("http://192.168.1.174:3001/api/books/" + book.id);
    }
}
