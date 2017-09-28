package com.minkov.demos.mvp.PersonsLists;

import android.content.Context;

import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.models.Person;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module()
public class PersonsListModule {
  @Provides
  PersonsListContracts.Presenter providePersonsListPresenter(BaseRepository<Person> data, Context context) {
    return new PersonsListPresenter(data);
  }
}
