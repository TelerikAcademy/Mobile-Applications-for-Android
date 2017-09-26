package com.minkov.demos.httpasyncdemos.views.list;

import com.minkov.demos.httpasyncdemos.models.Person;

/**
 * Created by minkov on 9/25/17.
 */

public class ListContracts {
  interface Presenter<T> {
    void setView(T view);

    void load();

    void save(String name, int age);
  }

  interface View<T> {
    void setPresenter(T presenter);

    void update(Person[] people);

    void showLoading();
    void hideLoading();
  }
}
