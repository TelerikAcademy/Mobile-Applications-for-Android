package com.minkov.httpdemos;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.minkov.httpdemos.fragments.LoadingFragment;
import com.minkov.httpdemos.models.Book;
import com.minkov.httpdemos.tasks.HttpTaskWithArrayResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Book[] books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        ListView lvBooks = (ListView) this.findViewById(R.id.lv_books);

        lvBooks.setOnItemClickListener((parent, view, position, id) -> {
            Book book = this.books[position];
            Intent intent = new Intent(this, BookDetailsActivity.class);

            intent.putExtra("book", book);

            this.startActivity(intent);
        });

        lvBooks.setAdapter(adapter);

        LoadingFragment loadingFragment = LoadingFragment.create(this);

        this.getSupportFragmentManager()
                .beginTransaction()
                .add(loadingFragment, "fragment_loading")
                .commit();

        loadingFragment.show();

        new HttpTaskWithArrayResult<>(
                Book[].class,
                (Book[] books) -> {
                    this.books = books;
                    this.runOnUiThread(() -> {
                        Arrays.stream(books)
                                .forEach(book -> {
                                    adapter.add(book.title);
                                });
                        loadingFragment.hide();
                    });
                }).execute("http://192.168.1.174:3001/api/books");
    }

    class PerformHttpAsyncTask extends AsyncTask<String, String, String> {
        private final OkHttpClient okHttpClient;
        private final OnPostExecutedFinished onPostExecuteFinished;

        public PerformHttpAsyncTask(OnPostExecutedFinished onPostExecutedFinished) {
            this.okHttpClient = new OkHttpClient();
            this.onPostExecuteFinished = onPostExecutedFinished;
        }

        @Override
        protected String doInBackground(String... params) {
            String url = params[0];

            Request request =
                    new Request.Builder()
                            .url(url)
                            .build();

            try {
                Response response = this.okHttpClient.newCall(request)
                        .execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);

            Gson gson = new Gson();

            Book[] books = gson.fromJson(json, Book[].class);

            this.onPostExecuteFinished.call(books);
        }

    }

    public interface OnPostExecutedFinished {

        void call(Book[] books);
    }
}
