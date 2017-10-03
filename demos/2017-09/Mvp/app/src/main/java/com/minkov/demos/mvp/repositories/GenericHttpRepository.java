package com.minkov.demos.mvp.repositories;

import com.minkov.demos.mvp.http.HttpRequester;
import com.minkov.demos.mvp.http.Url;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.JsonParser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Generic repository for creating HTTP requests against a RESTful API
 *
 * @param <T> the model type
 */
public class GenericHttpRepository<T> implements BaseRepository<T> {
    private final HttpRequester mHttpRequester;
    private final JsonParser<T> mJsonParser;
    private final String mUrl;

    /**
     * Initializes a {@link GenericHttpRepository} object
     *
     * @param httpRequester create HTTP requests
     * @param jsonParser    parses strings to <T> objects
     * @param url           the url wrapper
     */
    @Inject
    public GenericHttpRepository(HttpRequester httpRequester,
                                 JsonParser<T> jsonParser,
                                 Url<Person> url) {
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
        mUrl = url.getUrl();
    }

    @Override
    public Observable<List<T>> getAll() {
        return mHttpRequester.get(mUrl)
                .map(new Function<String, List<T>>() {
                    @Override
                    public List<T> apply(@NonNull String personsString) throws Exception {
                        T[] objects = mJsonParser.parseArrayFromJson(personsString);
                        List<T> list = new ArrayList<>();
                        for (T obj : objects) {
                            list.add(obj);
                        }

                        return list;
                    }
                });
    }

    @Override
    public Observable<T> add(T person) {
        String bodyString = mJsonParser.toJson(person);
        return mHttpRequester.post(mUrl, bodyString)
                .map(new Function<String, T>() {
                    @Override
                    public T apply(@NonNull String s) throws Exception {
                        return mJsonParser.parseFromJson(s);
                    }
                });
    }

    @Override
    public Observable<T> getById(String id) {
        return mHttpRequester.get(mUrl + id)
                .map(new Function<String, T>() {
                    @Override
                    public T apply(@NonNull String s) throws Exception {
                        return mJsonParser.parseFromJson(s);
                    }
                });
    }

    @Override
    public void clear() {

    }
}
