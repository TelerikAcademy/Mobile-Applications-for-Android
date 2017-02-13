package com.minkov.dagger2demos.data;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by minkov on 2/10/17.
 */

public class ApiUrl<T> {
    private String apiBaseUrl;
    private String suffix;

    public ApiUrl(String apiBaseUrl, String suffix) {
        this.apiBaseUrl = apiBaseUrl;
        this.setSuffix(suffix);
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getUrl() {
        return this.apiBaseUrl + this.suffix;
    }
}
