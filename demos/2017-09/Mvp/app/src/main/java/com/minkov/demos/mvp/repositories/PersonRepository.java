package com.minkov.demos.mvp.repositories;

import com.minkov.demos.mvp.http.HttpRequester;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.JsonParser;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonRepository implements BaseRepository<Person> {
  private final HttpRequester mHttpRequester;
  private final JsonParser<Person> mJsonParser;
  private final String mUrl;
  List<Person> people;

  @Inject
  public PersonRepository(HttpRequester httpRequester,
                          JsonParser<Person> jsonParser) {
    mHttpRequester = httpRequester;
    mJsonParser = jsonParser;
    mUrl = "http://192.168.201.77:3001/api/people/";
  }

  @Override
  public Observable<Person[]> getAll() {
    return mHttpRequester.get(mUrl)
            .map(new Function<String, Person[]>() {
              @Override
              public Person[] apply(@NonNull String personsString) throws Exception {
                return mJsonParser.parseArrayFromJson(personsString);
              }
            });
  }

  @Override
  public Observable<Person> add(Person person) {
    String bodyString = mJsonParser.toJson(person);
    return mHttpRequester.post(mUrl, bodyString)
            .map(new Function<String, Person>() {
              @Override
              public Person apply(@NonNull String s) throws Exception {
                return mJsonParser.parseFromJson(s);
              }
            });
  }

  @Override
  public Observable<Person> getById(String id) {
    return mHttpRequester.get(mUrl + id)
            .map(new Function<String, Person>() {
              @Override
              public Person apply(@NonNull String s) throws Exception {
                return mJsonParser.parseFromJson(s);
              }
            });
  }
}
