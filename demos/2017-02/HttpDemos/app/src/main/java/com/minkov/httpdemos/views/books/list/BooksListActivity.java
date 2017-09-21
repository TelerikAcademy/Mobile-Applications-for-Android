package com.minkov.httpdemos.views.books.list;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.minkov.httpdemos.R;
import com.minkov.httpdemos.contracts.ICanNavigate;
import com.minkov.httpdemos.views.books.details.BookDetailsActivity;
import com.minkov.httpdemos.views.books.details.BookDetailsFragment;
import com.minkov.httpdemos.views.books.models.Book;

public class BooksListActivity extends AppCompatActivity
        implements ICanNavigate<Book> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        Fragment fragment = BooksListFragment.create();

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_books_list, fragment)
                .commit();
    }

    @Override
    public void navigate(Book book) {
        Fragment fragment = this.getSupportFragmentManager()
                .findFragmentById(R.id.fragment_book_details);
        if (fragment == null) {
            Intent intent = new Intent(this, BookDetailsActivity.class);
            intent.putExtra("book", book);
            this.startActivity(intent);
        } else {
            ((BookDetailsFragment) fragment).setBook(book)
                    .load();
        }
    }
}
