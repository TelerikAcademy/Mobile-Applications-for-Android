package com.minkov.demos.mvp.repositories;

import com.minkov.demos.mvp.repositories.base.BaseRepository;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by minkov on 10/2/17.
 */

public class GenericCacheRepository<T> implements BaseRepository<T> {

    private final AbstractDao<T, String> mDao;

    public GenericCacheRepository(AbstractDao<T, String> dao) {
        mDao = dao;
    }

    @Override
    public Observable<List<T>> getAll() {
        List<T> itemsList = mDao.loadAll();
        return Observable.just(itemsList);
    }

    @Override
    public Observable<T> add(T obj) {
        mDao.insert(obj);
        return Observable.just(obj);
    }

    @Override
    public Observable<T> getById(String id) {
        return Observable.just(mDao.load(id));
    }

    @Override
    public void clear() {
        mDao.deleteAll();
    }
}
