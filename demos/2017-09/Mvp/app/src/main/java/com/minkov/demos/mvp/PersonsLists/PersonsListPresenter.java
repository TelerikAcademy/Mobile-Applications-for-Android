package com.minkov.demos.mvp.PersonsLists;

import android.content.Context;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonsListPresenter implements PersonsListContracts.Presenter {
  private final BaseRepository<Person> mData;
  private PersonsListContracts.View mView;
  private Person[] mPersons;

  public PersonsListPresenter(
          BaseRepository<Person> data) {
    mData = data;
  }

  @Override
  public void subscribe(PersonsListContracts.View view) {
    mView = view;

    mData.getAll()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe(new Consumer<Person[]>() {
              @Override
              public void accept(Person[] persons) throws Exception {
                mPersons = persons;
                mView.setPersons(persons);
              }
            }, new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
              }
            });
  }

  @Override
  public void unsubscribe() {
    mView = null;
  }

  @Override
  public void onPersonSelect(int index) {
    mView.showDetailsWith(mPersons[index]);
  }
}
