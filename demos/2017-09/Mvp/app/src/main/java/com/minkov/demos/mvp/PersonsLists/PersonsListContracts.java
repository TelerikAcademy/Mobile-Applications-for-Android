package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.base.BaseContracts;
import com.minkov.demos.mvp.models.Person;

/**
 * Created by minkov on 9/27/17.
 */

public interface PersonsListContracts {
  interface View extends BaseContracts.View<Presenter> {
    void setPersons(Person[] persons);

    void showDetailsWith(Person mPerson);
  }

  interface Presenter extends BaseContracts.Presenter<View> {

    void onPersonSelect(int index);
  }
}
