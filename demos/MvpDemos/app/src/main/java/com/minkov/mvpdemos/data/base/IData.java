package com.minkov.mvpdemos.data.base;

import java.util.List;

import io.reactivex.Observable;

public interface IData<T> {
    Observable<T[]> getAll();
    Observable<T> getById(Object id);
    Observable<T> add(T item);
}
