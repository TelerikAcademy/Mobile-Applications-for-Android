package com.minkov.navigationdemos.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.minkov.navigationdemos.ICanNavigateActivity;
import com.minkov.navigationdemos.R;
import com.minkov.navigationdemos.activities.BookDetailsActivity;
import com.minkov.navigationdemos.activities.BooksListActivity;
import com.minkov.navigationdemos.data.Data;
import com.minkov.navigationdemos.models.Book;

import java.util.List;

public class ListBooksFragment extends Fragment {
    public Data data;

    public ListBooksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_books, container, false);

        this.data = new Data();

        ListView lvBooks = (ListView) root.findViewById(R.id.lv_books);

        List<Book> books = this.data.getBooks();

        ArrayAdapter<Book> booksAdapter =
                new ArrayAdapter<Book>(root.getContext(), -1, books) {
                    @NonNull
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = convertView;
                        if (view == null) {
                            LayoutInflater inflater = LayoutInflater.from(this.getContext());
                            view = inflater.inflate(R.layout.item_book, parent, false);
                        }

                        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);

                        String title = this.getItem(position).getTitle();
                        tvTitle.setText(title);

                        return view;
                    }
                };

        lvBooks.setAdapter(booksAdapter);

        lvBooks.setOnItemClickListener((parent, view, position, id) -> {
            Book book = books.get(position);
            //if activity is not ICanNavigateActivity) then do nothing
            ICanNavigateActivity<Book> activity = (ICanNavigateActivity<Book>) this.getActivity();

            activity.navigate(book);
        });

        return root;
    }
}
