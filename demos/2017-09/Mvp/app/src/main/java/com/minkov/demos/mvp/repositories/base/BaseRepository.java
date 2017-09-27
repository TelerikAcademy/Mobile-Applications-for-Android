package com.minkov.demos.mvp.repositories.base;

import io.reactivex.Observable;

/**
 * Created by minkov on 9/27/17.
 */

public interface BaseRepository<T> {
  Observable<T[]> getAll();
  Observable<T> add(T obj);
  Observable<T> getById(String id);
}
