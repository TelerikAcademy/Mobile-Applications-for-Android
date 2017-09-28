package com.minkov.demos.mvp.PersonDetails;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.GenericRepository;
import com.minkov.demos.mvp.repositories.base.BaseRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonDetailsPresenter implements PersonDetailsContacts.Presenter {
  private PersonDetailsContacts.View mView;

  private final BaseRepository<Person> mRepository;
  private String mPersonId;

  @Inject
  public PersonDetailsPresenter(BaseRepository<Person> repository) {
    mRepository = repository;
  }

  @Override
  public void subscribe(PersonDetailsContacts.View view) {
    mView = view;
    reload();
  }

  private void reload() {
    mRepository.getById(mPersonId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe(new Consumer<Person>() {
              @Override
              public void accept(Person person) throws Exception {
                mView.setPerson(person);
              }
            });
  }

  @Override
  public void unsubscribe() {
    mView = null;
  }

  @Override
  public void setPersonId(String id) {
    mPersonId = id;
    reload();
  }
}
