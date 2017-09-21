package com.minkov.httpdemos.dataServices;

import com.minkov.httpdemos.tasks.HttpTask;

public interface IDataService<T> {
    void getAll(HttpTask.OnHttpTaskResult<T[]> onHttpTaskResult);
    void getById(Object id, HttpTask.OnHttpTaskResult<T> onHttpTaskResult);
    void add(T obj, HttpTask.OnHttpTaskResult<T> onHttpTaskResult);
}
