package com.minkov.demos.httpasyncdemos.views.list;

import com.google.gson.Gson;
import com.minkov.demos.httpasyncdemos.http.HttpRequester;
import com.minkov.demos.httpasyncdemos.models.Person;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 9/25/17.
 */

public class ListPresenter implements ListContracts.Presenter<ListContracts.View>, HttpRequester.OnResponseListener {
  private final HttpRequester mHttpRequester;
  private final Gson mGson;
  private ListContracts.View mView;

  public ListPresenter(HttpRequester httpRequester) {
    mGson = new Gson();
    mHttpRequester = httpRequester;
  }

  @Override
  public void setView(ListContracts.View view) {
    mView = view;
  }

  @Override
  public void load() {
    mView.showLoading();
    mHttpRequester.get("http://192.168.201.77:3001/api/people")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe(new Consumer<String>() {
              @Override
              public void accept(String body) throws Exception {
                Person[] people = mGson.fromJson(body, Person[].class);
                mView.update(people);
                mView.hideLoading();
              }
            });
  }

  @Override
  public void save(String name, int age) {

  }

  @Override
  public void onResponse(String body, HttpRequester.HttpMethod method) {

  }

//  @Override
//  public void load() {
//    mView.showLoading();
//    mHttpRequester.get("http://192.168.201.77:3001/api/people/", this);
//  }
//
//  @Override
//  public void save(String name, int age) {
//    mView.showLoading();
//    Person person = new Person(name, age);
//    Gson gson = new Gson();
//    String personString = gson.toJson(person);
//    mHttpRequester.post("http://192.168.201.77:3001/api/people/", personString, this);
//  }
//
//  @Override
//  public void onResponse(String body, HttpRequester.HttpMethod method) {
//    Gson gson = new Gson();
//
//    switch (method) {
//      case GET:
//        Person[] people = gson.fromJson(body, Person[].class);
//        mView.update(people);
//        mView.hideLoading();
//        break;
//      case POST:
//        load();
//        break;
//    }
//  }
}
