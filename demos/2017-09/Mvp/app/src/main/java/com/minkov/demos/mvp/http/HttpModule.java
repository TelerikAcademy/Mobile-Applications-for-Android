package com.minkov.demos.mvp.http;

import com.minkov.demos.mvp.models.Person;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class HttpModule {
  Map<String, Url> urls;
  static final String PEOPLE_URL_SUFFIX = "api/people/";

  public HttpModule() {
    urls = new HashMap<>();
  }

  @Provides
  Url<Person> providePersonsUrl(@Named("base-url") String baseUrl, Class<Person> p) {
    if(urls.containsKey(PEOPLE_URL_SUFFIX) == false) {
      urls.put(PEOPLE_URL_SUFFIX, new Url<>(baseUrl + PEOPLE_URL_SUFFIX));
    }
    return urls.get(PEOPLE_URL_SUFFIX);
  }
}
