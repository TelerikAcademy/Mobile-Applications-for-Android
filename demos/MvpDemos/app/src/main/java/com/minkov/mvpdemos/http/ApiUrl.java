package com.minkov.mvpdemos.http;

public class ApiUrl<T> {
    private final String baseUrl;
    private final String suffixUrl;

    public ApiUrl(String baseUrl, String suffixUrl) {
        this.baseUrl = baseUrl;
        this.suffixUrl = suffixUrl;
    }

    public String getUrl() {
        return this.baseUrl + "/" + this.suffixUrl;
    }

    public String getUrlWithId(Object id) {
        return this.getUrl() + "/" + id;
    }
}
