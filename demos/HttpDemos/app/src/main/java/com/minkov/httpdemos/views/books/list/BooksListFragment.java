package com.minkov.httpdemos.views.books.list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.minkov.httpdemos.R;
import com.minkov.httpdemos.contracts.ICanNavigate;
import com.minkov.httpdemos.fragments.LoadingFragment;
import com.minkov.httpdemos.views.books.models.Book;
import com.minkov.httpdemos.dataServices.HttpDataService;
import com.minkov.httpdemos.dataServices.IDataService;

import java.util.ArrayList;

public class BooksListFragment extends Fragment {
    private Book[] books;
    private ArrayAdapter<String> adapter;
    private ListView lvBooks;

    public BooksListFragment() {
        // Required empty public constructor
    }

    public static BooksListFragment create() {
        return new BooksListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_books_list, container, false);

        this.adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        this.lvBooks = (ListView) root.findViewById(R.id.lv_books);

        this.lvBooks.setOnItemClickListener((parent, view, position, id) -> {
            Book book = this.books[position];
            if (this.getActivity() instanceof ICanNavigate) {
                ((ICanNavigate<Book>) this.getActivity())
                        .navigate(book);
            }
        });

        this.lvBooks.setAdapter(this.adapter);

        this.load(root);

        return root;
    }

    public BooksListFragment load() {
        return this.load(this.getView());
    }

    public BooksListFragment load(View root) {
        LoadingFragment loadingFragment = LoadingFragment.create(this.getContext());

        this.getFragmentManager()
                .beginTransaction()
                .add(loadingFragment, "fragment_loading")
                .commit();

        loadingFragment.show();

        IDataService<Book> booksData = new HttpDataService<>("http://192.168.153.31:3001/api/books", Book.class, Book[].class);

        booksData.getAll((ex, books) -> {
            this.getActivity()
                    .runOnUiThread(() -> {
                        if (ex != null) {
                            Toast.makeText(this.getContext(), ex.getMessage(), Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            this.books = books;
                            for (Book book : books) {
                                adapter.add(book.getTitle());
                            }
                        }
                        loadingFragment.hide();
                    });
        });
        return this;
    }
}
