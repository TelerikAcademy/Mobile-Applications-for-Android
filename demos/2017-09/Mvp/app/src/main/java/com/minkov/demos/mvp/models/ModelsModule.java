package com.minkov.demos.mvp.models;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class ModelsModule {

  @Provides
  Class<Person> providePersonClass() {
    return Person.class;
  }

  @Provides
  Class<Person[]> providePersonArrayClass() {
    return Person[].class;
  }
}
