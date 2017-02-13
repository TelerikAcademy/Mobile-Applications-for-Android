package com.minkov.mvpdemos.http.base;

import io.reactivex.Observable;

/**
 * Created by minkov on 2/13/17.
 */

public interface IHttpRequester {
    Observable<String> get(String url);

    Observable<String> post(String url, String bodyString);
}
