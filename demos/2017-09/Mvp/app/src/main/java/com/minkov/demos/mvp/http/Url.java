package com.minkov.demos.mvp.http;

/**
 * Created by minkov on 9/27/17.
 */

public class Url<T> {
  private final String mUrl;

  public Url(String url) {
    mUrl = url;
  }

  public String getUrl() {
    return mUrl;
  }
}
