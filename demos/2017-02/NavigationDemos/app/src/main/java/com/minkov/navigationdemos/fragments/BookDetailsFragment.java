package com.minkov.navigationdemos.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minkov.navigationdemos.R;
import com.minkov.navigationdemos.models.Book;

import java.io.Serializable;

import static com.minkov.navigationdemos.activities.BookDetailsActivity.BOOK_KEY;

public class BookDetailsFragment extends Fragment {

    private Book book;

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    public static BookDetailsFragment createFragment(Book book) {
        Bundle bundle = new Bundle();

        bundle.putSerializable(BOOK_KEY, book);

        BookDetailsFragment fragment = new BookDetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_details, container, false);

        Bundle arguments = this.getArguments();
        Serializable serializedBook = null;

        if (arguments != null) {
            serializedBook = arguments.getSerializable(BOOK_KEY);
        }

        if (serializedBook != null) {
            this.setBook(root, (Book) serializedBook);
        }

        return root;
    }

    protected void setBook(View view, Book book) {
        this.book = book;
        ((TextView) view
                .findViewById(R.id.tv_title))
                .setText(this.book.getTitle());

    }

    public void setBook(Book book) {
        this.setBook(this.getView(), book);
    }
}
