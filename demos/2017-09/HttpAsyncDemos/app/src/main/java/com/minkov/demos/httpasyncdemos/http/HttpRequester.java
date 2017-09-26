package com.minkov.demos.httpasyncdemos.http;

import android.os.AsyncTask;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by minkov on 9/25/17.
 */

public class HttpRequester {
  private final OkHttpClient mClient;

  public HttpRequester() {
    mClient = new OkHttpClient();
  }

  public void post(final String url, String bodyString, final OnResponseListener onGetFinishedListener) {
    RequestBody body = RequestBody.create(
            MediaType.parse("application/json"), bodyString);

    Request req = new Request.Builder()
            .post(body)
            .url(url)
            .build();

    makeRequest(req, onGetFinishedListener, HttpMethod.POST);

  }

  public void get(final String url, final OnResponseListener onGetFinishedListener) {
    Request req = new Request.Builder()
            .get()
            .url(url)
            .build();
    makeRequest(req, onGetFinishedListener, HttpMethod.GET);
  }

  public Observable<String> get(final String url) {
    return Observable.create(new ObservableOnSubscribe<String>() {
      @Override
      public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
        Request req = new Request.Builder()
                .get()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        try {
          Response res = client.newCall(req)
                  .execute();

          String bodyString = res.body().string();

          e.onNext(bodyString);
          e.onComplete();
        } catch (IOException ex) {
          e.onError(ex);
        }
      }
    });
  }

  private void makeRequest(final Request req, final OnResponseListener onGetFinishedListener, final HttpMethod method) {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();

        try {
          Response res = client.newCall(req)
                  .execute();

          String bodyString = res.body().string();

          //IF GET
          onGetFinishedListener.onResponse(bodyString, method);

          //ELSE POST

        } catch (IOException e) {
          e.printStackTrace();
        }

        return null;
      }
    }.execute((Void) null);
  }

  public interface OnResponseListener {
    void onResponse(String body, HttpMethod method);
  }

  public enum HttpMethod {
    GET, POST,
  }
}
