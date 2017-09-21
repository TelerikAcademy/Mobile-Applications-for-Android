package com.minkov.navigationdemos;

/**
 * Created by minkov on 1/27/17.
 */

public interface ICanNavigateActivity<T> {
    void navigate(T obj);
}
