package com.minkov.demos.mvp.repositories;

import com.minkov.demos.mvp.http.HttpRequester;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.utils.JsonParser;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class RepositoriesModule {
  @Provides
  BaseRepository<Person> providesData(HttpRequester httpRequester,
                                      JsonParser<Person> jsonParser) {
    return new PersonRepository(httpRequester, jsonParser);
  }
}
