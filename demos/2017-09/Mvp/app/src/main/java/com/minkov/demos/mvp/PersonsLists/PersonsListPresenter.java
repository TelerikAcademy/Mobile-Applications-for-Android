package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.base.BaseContracts;
import com.minkov.demos.mvp.models.Person;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonsListPresenter implements PersonsListContracts.Presenter {
  private final Person[] mPersons;
  private PersonsListContracts.View mView;

  public PersonsListPresenter() {
    mPersons = new Person[] {
            new Person("John"),
            new Person("Jane"),
            new Person("Gosho"),
    };
  }

  @Override
  public void subscribe(PersonsListContracts.View view) {
    mView = view;
    mView.setPersons(mPersons);
  }

  @Override
  public void unsubscribe() {
    mView = null;
  }
}
