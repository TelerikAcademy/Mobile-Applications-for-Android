package com.minkov.mvpdemos.data;

import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.http.ApiUrl;
import com.minkov.mvpdemos.http.base.IHttpRequester;
import com.minkov.mvpdemos.utils.base.IParser;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by minkov on 2/13/17.
 */

public class HttpData<T> implements IData<T> {

    private final IHttpRequester httpRequester;
    private final IParser<T> parser;
    private final ApiUrl<T> apiUrl;

    @Inject
    public HttpData(IHttpRequester httpRequester, IParser<T> parser, ApiUrl<T> apiUrl) {
        this.httpRequester = httpRequester;
        this.parser = parser;
        this.apiUrl = apiUrl;
    }

    @Override
    public Observable<T[]> getAll() {
        return httpRequester.get(this.apiUrl.getUrl())
                .map(new Function<String, T[]>() {
                    @Override
                    public T[] apply(String json) throws Exception {
                        return parser.parseMany(json);
                    }
                });
    }

    @Override
    public Observable<T> getById(Object id) {
        return httpRequester.get(this.apiUrl.getUrlWithId(id))
                .map(new Function<String, T>() {
                    @Override
                    public T apply(String json) throws Exception {
                        return parser.parse(json);
                    }
                });
    }

    @Override
    public Observable<T> add(T item) {
        String json = this.parser.stringify(item);
        return httpRequester.post(this.apiUrl.getUrl(), json)
                .map(new Function<String, T>() {
                    @Override
                    public T apply(String json) throws Exception {
                        return parser.parse(json);
                    }
                });
    }
}
