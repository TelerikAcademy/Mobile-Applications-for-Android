package com.minkov.mvpdemos.utils.base;

import java.util.Collection;

/**
 * Created by minkov on 2/13/17.
 */

public interface IParser<T> {
    T parse(String json);

    T[] parseMany(String json);

    String stringify(T item);

    String stringifyMany(T[] items);
    String stringifyMany(Collection<T> items);
}
