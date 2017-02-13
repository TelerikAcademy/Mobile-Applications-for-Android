package com.minkov.dagger2demos.data.base;

import io.reactivex.Observable;

public abstract class BaseData<T> {
    public abstract Observable<T[]> getAll();
    public abstract Observable<T> getById(Object id);
    public abstract Observable<T> add(T item);

}
