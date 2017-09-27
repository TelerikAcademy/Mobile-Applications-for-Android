package com.minkov.demos.mvp.repositories;

import com.minkov.demos.mvp.http.HttpRequester;
import com.minkov.demos.mvp.http.Url;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.JsonParser;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by minkov on 9/27/17.
 */

public class GenericRepository<T> implements BaseRepository<T> {
  private final HttpRequester mHttpRequester;
  private final JsonParser<T> mJsonParser;
  private final String mUrl;

  @Inject
  public GenericRepository(HttpRequester httpRequester,
                           JsonParser<T> jsonParser,
                           Url<Person> url) {
    mHttpRequester = httpRequester;
    mJsonParser = jsonParser;
    mUrl = url.getUrl();
  }

  @Override
  public Observable<T[]> getAll() {
    return mHttpRequester.get(mUrl)
            .map(new Function<String, T[]>() {
              @Override
              public T[] apply(@NonNull String personsString) throws Exception {
                return mJsonParser.parseArrayFromJson(personsString);
              }
            });
  }

  @Override
  public Observable<T> add(T person) {
    String bodyString = mJsonParser.toJson(person);
    return mHttpRequester.post(mUrl, bodyString)
            .map(new Function<String, T>() {
              @Override
              public T apply(@NonNull String s) throws Exception {
                return mJsonParser.parseFromJson(s);
              }
            });
  }

  @Override
  public Observable<T> getById(String id) {
    return mHttpRequester.get(mUrl + id)
            .map(new Function<String, T>() {
              @Override
              public T apply(@NonNull String s) throws Exception {
                return mJsonParser.parseFromJson(s);
              }
            });
  }
}
