package com.minkov.mvpdemos.utils;

import com.google.gson.Gson;
import com.minkov.mvpdemos.utils.base.IParser;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class JsonParser<T> implements IParser<T> {
    private final Class<T> klass;
    private final Class<T[]> klassMany;
    private final Gson gson;

    @Inject
    JsonParser(Class<T> klass, Class<T[]> klassMany) {
        this.klass = klass;
        this.klassMany = klassMany;

        this.gson = new Gson();
    }

    public T parse(String json) {
        return gson.fromJson(json, this.klass);
    }

    public T[] parseMany(String json) {
        return gson.fromJson(json, this.klassMany);
    }

    public String stringify(T item) {
        return this.gson.toJson(item);
    }

    @Override
    public String stringifyMany(T[] items) {
        List<T> itemsList = Arrays.asList(items);
        return this.stringifyMany(itemsList);
    }

    @Override
    public String stringifyMany(Collection<T> items) {
        return this.gson.toJson(items);
    }

}
