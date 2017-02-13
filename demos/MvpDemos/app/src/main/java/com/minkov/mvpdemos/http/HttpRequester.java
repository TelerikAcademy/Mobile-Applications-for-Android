package com.minkov.mvpdemos.http;

import com.minkov.mvpdemos.http.base.IHttpRequester;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpRequester implements IHttpRequester {
    private OkHttpClient client;
    private String mediaTypeJson;

    @Inject
    public HttpRequester() {
        this.client = new OkHttpClient();
        this.mediaTypeJson = "application/json";
    }

    public Observable<String> get(final String url) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Request req = new Request.Builder()
                        .url(url)
                        .build();

                Response res = client.newCall(req).execute();
                String body = res.body().string();
                e.onNext(body);
            }
        });
    }

    public Observable<String> post(final String url, final String bodyString) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                RequestBody body = RequestBody.create(MediaType.parse(mediaTypeJson), bodyString);

                Request req = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();

                Response res = client.newCall(req).execute();
                String resultBody = res.body().string();
                e.onNext(resultBody);
            }
        });
    }
}
