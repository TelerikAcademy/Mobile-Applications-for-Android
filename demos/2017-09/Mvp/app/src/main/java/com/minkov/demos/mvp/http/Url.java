package com.minkov.demos.mvp.http;

/**
 * Wrapper for Urls, only purpose is to inject urls
 * @param <T> model type
 * Created by minkov on 9/27/17.
 */

public class Url<T> {
    private final String mUrl;

    /**
     * @param url the wrapper url
     */
    public Url(String url) {
        mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }
}
