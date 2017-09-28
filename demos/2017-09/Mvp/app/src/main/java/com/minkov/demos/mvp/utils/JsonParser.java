package com.minkov.demos.mvp.utils;

import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Created by minkov on 9/27/17.
 *
 * @param <T> the model type
 **/
public class JsonParser<T> {
    private final Gson mGson;
    private final Class<T> mKlass;
    private final Class<T[]> mKlassArray;

    /**
     * Creates a JsonParser object
     *
     * @param klass      the type of <T> to parse
     * @param klassArray the type of <T[]> to parse
     */
    @Inject
    public JsonParser(Class<T> klass, Class<T[]> klassArray) {
        mGson = new Gson();
        mKlass = klass;
        mKlassArray = klassArray;
    }

    /**
     * Deserializes JSON string to array of T
     *
     * @param json a valid JSON array string
     * @return Array of <T>
     */
    public T[] parseArrayFromJson(String json) {
        return mGson.fromJson(json, mKlassArray);
    }

    /**
     * Deserializes JSON string to T
     *
     * @param json a valid JSON string
     * @return An <T> object
     */
    public T parseFromJson(String json) {
        return mGson.fromJson(json, mKlass);
    }

    /**
     * Serialize a <T> object to JSON string
     *
     * @param object object to serialize
     * @return A valid JSON string
     */
    public String toJson(T object) {
        return mGson.toJson(object);
    }

    /**
     * Serialize an array of <T> objects to JSON array string
     *
     * @param objects objects to serialize
     * @return A valid JSON array string
     */
    public String toJson(T[] objects) {
        return mGson.toJson(objects);
    }
}
