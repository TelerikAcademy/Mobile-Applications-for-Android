package com.minkov.demos.httpasyncdemos.views.list;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.minkov.demos.httpasyncdemos.HttpAsyncApplication;
import com.minkov.demos.httpasyncdemos.R;
import com.minkov.demos.httpasyncdemos.http.HttpRequester;
import com.minkov.demos.httpasyncdemos.models.Person;

public class ListActivity extends AppCompatActivity {
  private ListPresenter mListPresenter;
  private ListFragment mListFragment;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    HttpRequester httpRequester = ((HttpAsyncApplication)getApplication())
            .getHttpRequester();

    mListPresenter = new ListPresenter(httpRequester);
    mListFragment = new ListFragment();
    mListFragment.setPresenter(mListPresenter);

    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.frame_list, mListFragment)
            .commit();
  }

  //  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_main);
//    mHttpRequester = ((HttpAsyncApplication) getApplication())
//            .getHttpRequester();
//    mUrl = ((HttpAsyncApplication) getApplication()).BASE_URL;
//
//    makeHttp();
//  }
//
//  private void makeHttp() {
//    // localhost = 127.0.0.1
//    makeGet();
//  }
//
//  private void makeGet() {
//    mHttpRequester.get(mUrl, this);
//  }
//
//  public void onResponse(final String bodyString) {
//    Gson gson = new Gson();
//
//    final Person[] people = gson.fromJson(bodyString, Person[].class);
//
//    runOnUiThread(new Runnable() {
//      @Override
//      public void run() {
//        Toast.makeText(ListActivity.this, people[0].getName(), Toast.LENGTH_SHORT)
//                .show();
//      }
//    });
//  }

//  private void makeGet() {
//    String url = "http://192.168.201.77:3001/api/people";
//
//    Request req = new Request.Builder()
//            .get()
//            .url(url)
//            .addHeader("content-type", "application/json")
//            .build();
//
//    OkHttpClient client = new OkHttpClient();
//
//    client.newCall(req)
//            .enqueue(new Callback() {
//              @Override
//              public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//              }
//
//              @Override
//              public void onResponse(Call call, Response response) throws IOException {
//                String body = response.body().string();
//                Log.d("DATA", body);
//                makePost();
//              }
//            });
//  }
//  private void makePost() {
//    String url = "http://192.168.201.77:3001/api/people";
//
//    String bodyString = "{\"name\": \"NEW NAME\", \"age\": 12}";
//
//    RequestBody body = RequestBody.create(MediaType.parse("application/json"),bodyString);
//
//    Request req = new Request.Builder()
//            .post(body)
//            .url(url)
//            .addHeader("content-type", "application/json")
//            .build();
//
//    OkHttpClient client = new OkHttpClient();
//    client.newCall(req)
//            .enqueue(new Callback() {
//              @Override
//              public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//              }
//
//              @Override
//              public void onResponse(Call call, Response response) throws IOException {
//                String body = response.body().string();
//                Log.d("DATA", body);
//                makeGet();
//              }
//            });
//  }
}
