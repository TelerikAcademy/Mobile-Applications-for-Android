package com.minkov.demos.mvp.repositories.base;

import java.util.List;

import io.reactivex.Observable;

/**
 * Base repository for fetching data
 *
 * @param <T> the model type
 */
public interface BaseRepository<T> {

    /**
     * Get all objects from type T
     *
     * @return array of objects
     */
    Observable<List<T>> getAll();

    /**
     * Creates a new object of type @{T}
     *
     * @param obj the object to create
     * @return the created object with id
     */
    Observable<T> add(T obj);

    /**
     * Get an object with the given id
     *
     * @param id the id of the object
     * @return the found object
     */
    Observable<T> getById(String id);

    void clear();
}
