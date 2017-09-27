package com.minkov.demos.mvp.PersonDetails;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.GenericRepository;
import com.minkov.demos.mvp.repositories.base.BaseRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class PersonDetailsModule {
  @Provides
  PersonDetailsContacts.Presenter providePersonDetailsPresenter(BaseRepository<Person> repository){
    return new PersonDetailsPresenter(repository);
  }
}
