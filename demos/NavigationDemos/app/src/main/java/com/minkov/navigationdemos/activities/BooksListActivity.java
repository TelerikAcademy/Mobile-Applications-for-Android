package com.minkov.navigationdemos.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.minkov.navigationdemos.ICanNavigateActivity;
import com.minkov.navigationdemos.R;
import com.minkov.navigationdemos.fragments.BookDetailsFragment;
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

        this.bookDetailsFragment =
                (BookDetailsFragment) this.getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_book_details);
        if (this.bookDetailsFragment != null) {
            this.isPhoneView = false;
        }
    }

    protected void setupDrawer() {
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar_drawer);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName(R.string.drawer_item_home)
                .withIcon(R.drawable.material_drawer_badge);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem()
                .withIdentifier(2)
                .withName(R.string.drawer_item_settings)
                .withIcon(R.drawable.material_drawer_circle_mask);

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2
                )
                .build();

        result.openDrawer();
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
