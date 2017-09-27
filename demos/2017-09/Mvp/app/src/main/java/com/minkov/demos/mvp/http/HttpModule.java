package com.minkov.demos.mvp.http;

import com.minkov.demos.mvp.models.Person;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class HttpModule {
  private final String mBaseUrl;
  Map<String, Url> urls;
  static final String PEOPLE_URL_SUFFIX = "api/people/";

  public HttpModule() {
    mBaseUrl = "http://192.168.160.7:3001/";
    urls = new HashMap<>();
  }

  @Provides
  Url<Person> providePersonsUrl(Class<Person> p) {
    if(urls.containsKey(PEOPLE_URL_SUFFIX) == false) {
      urls.put(PEOPLE_URL_SUFFIX, new Url<>(mBaseUrl + PEOPLE_URL_SUFFIX));
    }
    return urls.get(PEOPLE_URL_SUFFIX);
  }
}
