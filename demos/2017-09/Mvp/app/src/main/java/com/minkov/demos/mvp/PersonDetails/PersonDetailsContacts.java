package com.minkov.demos.mvp.PersonDetails;

import com.minkov.demos.mvp.base.BaseContracts;
import com.minkov.demos.mvp.models.Person;

/**
 * Created by minkov on 9/27/17.
 */

public interface PersonDetailsContacts {
  public interface View extends BaseContracts.View<Presenter> {

    void setPerson(Person person);
  }

  public interface Presenter extends BaseContracts.Presenter<View> {

    void setPersonId(String id);
  }
}
