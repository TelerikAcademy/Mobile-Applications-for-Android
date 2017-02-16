package com.minkov.mvpdagger2UnitTestingdemos.data;

import com.minkov.mvpdagger2UnitTestingdemos.models.base.ModelBase;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LocalData<T extends ModelBase> {
    private List<T> items;

    @Inject
    public LocalData() {
        this.items = new ArrayList<>();
    }

    public Observable<List<T>> getAll() {
        return Observable.just(this.items);
    }

    public Observable<T> getById(Object id) {
        for (T item : this.items) {
            if (item.getId().equals(id)) {
                return Observable.just(item);
            }
        }
        return Observable.error(new InvalidParameterException("No item with the provided ID"));
    }

    public Observable<T> add(T item) {
        this.items.add(item);
        item.setId("id-" + (this.items.size() + 1));
        return Observable.just(item);
    }
}
