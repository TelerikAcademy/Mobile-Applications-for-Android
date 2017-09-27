package com.minkov.demos.mvp.utils;

import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Created by minkov on 9/27/17.
 */

public class JsonParser<T> {
  private final Gson mGson;
  private final Class<T> mKlass;
  private final Class<T[]> mKlassArray;

  @Inject
  public JsonParser(Class<T> klass, Class<T[]> klassArray) {
    mGson = new Gson();
    mKlass = klass;
    mKlassArray = klassArray;
  }

  public T[] parseArrayFromJson(String json) {
    return mGson.fromJson(json, mKlassArray);
  }

  public T parseFromJson(String json) {
    return mGson.fromJson(json, mKlass);
  }

  public String toJson(T object){
    return mGson.toJson(object);
  }

  public String toJson(T[] objects) {
    return mGson.toJson(objects);
  }
}
