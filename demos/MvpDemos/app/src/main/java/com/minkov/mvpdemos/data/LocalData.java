package com.minkov.mvpdemos.data;

import com.minkov.mvpdemos.models.ModelBase;
import com.minkov.mvpdemos.models.Superhero;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 2/12/17.
 */

public class LocalData<T extends ModelBase> {

    private final ArrayList<T> items;

    @Inject
    public LocalData() {
        this.items = new ArrayList<>();
    }

    public Observable<List<T>> getAll() {
        return Observable.just((List<T>) items)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<T> getById(Object id) {
        for (T item : this.items) {
            if (item.getId().equals(id)) {
                return Observable.just(item)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        }

        return Observable.just((T) new Superhero(id.toString(), "NEW SUPERHERO"));
    }

    public Observable<T> add(T item) {
        item.setId("Id-" + (this.items.size() + 1));
        this.items.add(item);
        return Observable.just(item)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
