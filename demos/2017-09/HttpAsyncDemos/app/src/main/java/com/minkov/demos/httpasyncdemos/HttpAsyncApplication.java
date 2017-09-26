package com.minkov.demos.httpasyncdemos;

import android.app.Application;

import com.minkov.demos.httpasyncdemos.http.HttpRequester;

/**
 * Created by minkov on 9/25/17.
 */

public class HttpAsyncApplication extends Application {
  public static final String BASE_URL = "http://192.168.201.77:3001/api/people";
  private HttpRequester httpRequester;

  public HttpRequester getHttpRequester() {
    if(httpRequester == null) {
      httpRequester = new HttpRequester();
    }

    return httpRequester;
  }
}
