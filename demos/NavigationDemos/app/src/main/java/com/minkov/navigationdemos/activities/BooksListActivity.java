package com.minkov.navigationdemos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.minkov.navigationdemos.ICanNavigateActivity;
import com.minkov.navigationdemos.R;
import com.minkov.navigationdemos.fragments.BookDetailsFragment;
import com.minkov.navigationdemos.fragments.DrawerFragment;
import com.minkov.navigationdemos.models.Book;

public class BooksListActivity extends AppCompatActivity
        implements ICanNavigateActivity<Book> {

    boolean isPhoneView;
    private BookDetailsFragment bookDetailsFragment;

    public BooksListActivity() {
        this.isPhoneView = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        DrawerFragment drawerFragment = new DrawerFragment();

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_drawer, drawerFragment)
                .commit();

        this.bookDetailsFragment =
                (BookDetailsFragment) this.getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_book_details);
        if (this.bookDetailsFragment != null) {
            this.isPhoneView = false;
        }
    }


    @Override
    public void navigate(Book book) {
        if (this.isPhoneView) {
            Intent intent = new Intent(this, BookDetailsActivity.class);

            intent.putExtra(BookDetailsActivity.BOOK_KEY, book);
            this.startActivity(intent);
        } else {
            this.bookDetailsFragment.setBook(book);
        }
    }
}
