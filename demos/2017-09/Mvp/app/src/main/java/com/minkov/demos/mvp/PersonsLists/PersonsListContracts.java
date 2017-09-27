package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.base.BaseContracts;
import com.minkov.demos.mvp.models.Person;

/**
 * Created by minkov on 9/27/17.
 */

public abstract class PersonsListContracts {
  interface View extends BaseContracts.View<Presenter> {
    void setPersons(Person[] persons);
  }

  interface Presenter extends BaseContracts.Presenter<View> {

  }
}
