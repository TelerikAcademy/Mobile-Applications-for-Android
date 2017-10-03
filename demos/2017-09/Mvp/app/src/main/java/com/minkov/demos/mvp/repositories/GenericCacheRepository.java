package com.minkov.demos.mvp.repositories;

import com.minkov.demos.mvp.repositories.base.BaseRepository;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

import io.reactivex.Observable;

/**
 * Generic repository for CRUD operations with local(cached) data
 * @param <T> the type of the model
 */
public class GenericCacheRepository<T> implements BaseRepository<T> {

    private final AbstractDao<T, String> mDao;

    /**
     * Creates a {@link GenericCacheRepository} instance
     * @param dao a GreenDao instance to work with SQLite
     */
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
