package com.minkov.dagger2demos.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.minkov.dagger2demos.data.base.BaseData;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by minkov on 2/10/17.
 */

public class LocalData<T> extends BaseData<T> {
    private final SharedPreferences sharedPreferences;
    private Context context;

    private final ArrayList<T> items;

    @Inject
    public LocalData(Context context,
                     SharedPreferences sharedPreferences) {
        this.items = new ArrayList<T>();
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Observable<T[]> getAll() {
        return Observable.just(
                (T[]) this.items.toArray()
        );
    }

    @Override
    public Observable<T> getById(Object id) {
        return Observable.just(null);
    }

    @Override
    public Observable add(T item) {
        this.items.add(item);
        return Observable.just(item);
    }
}
