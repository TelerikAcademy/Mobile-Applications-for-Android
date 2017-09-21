package com.minkov.httpdemos.views.books.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.minkov.httpdemos.R;
import com.minkov.httpdemos.fragments.LoadingFragment;
import com.minkov.httpdemos.views.books.models.Book;
import com.minkov.httpdemos.dataServices.HttpDataService;
import com.minkov.httpdemos.dataServices.IDataService;
import com.minkov.httpdemos.views.books.models.BookDetails;

public class BookDetailsFragment extends Fragment {
    private static final String BASE_URL = "http://192.168.153.31:3001/api/books";
    private final IDataService<BookDetails> booksData;

    private Book book;
    private BookDetails bookDetails;
    private LoadingFragment loading;

    public BookDetailsFragment() {
        // Required empty public constructor
        this.booksData = new HttpDataService<>(BASE_URL, BookDetails.class, BookDetails[].class);
    }

    public static BookDetailsFragment create(Book book) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        fragment.setBook(book);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_details, container, false);

        if (this.book != null) {
            this.load(root);
        }

        return root;
    }

    public BookDetailsFragment load() {
        return this.load(this.getView());
    }

    public BookDetailsFragment load(View root) {
        TextView tvTitle = (TextView) root.findViewById(R.id.tv_title);
        TextView tvDescription = (TextView) root.findViewById(R.id.tv_description);

        if (this.loading == null) {
            this.loading = LoadingFragment.create(this.getContext());
        }

        this.loading.show();

        booksData.getById(this.book.getId(), (ex, bookDetails) -> {
            this.getActivity()
                    .runOnUiThread(() -> {
                        if (ex != null) {
                            Toast.makeText(this.getContext(), ex.getMessage(), Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            tvTitle.setText(bookDetails.getTitle());
                            tvDescription.setText(bookDetails.getDescription());
                        }

                        this.loading.hide();
                    });
        });
        return this;
    }

    public BookDetailsFragment setBook(Book book) {
        this.book = book;
        return this;
    }
}
