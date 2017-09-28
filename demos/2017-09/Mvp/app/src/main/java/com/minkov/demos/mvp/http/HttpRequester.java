package com.minkov.demos.mvp.http;

import javax.inject.Inject;

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
 * Created by minkov on 9/27/17.
 */

public class HttpRequester {

    private final OkHttpClient mClient;

    /**
     * Creates a {@link HttpRequester} object
     */
    @Inject
    public HttpRequester() {
        mClient = new OkHttpClient();
    }

    private Observable<String> makeRequest(final Request req) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Response res = mClient.newCall(req)
                        .execute();

                String bodyString = res.body().string();
                e.onNext(bodyString);
                e.onComplete();
            }
        });
    }

    /**
     * Performs a HTTP get
     *
     * @param url the endpoint
     * @return RxObservable to handle the requests
     */
    public Observable<String> get(String url) {
        Request req = new Request.Builder()
                .get()
                .url(url)
                .build();

        return makeRequest(req);
    }

    /**
     * Performs a HTTP post
     *
     * @param url        the endpoint
     * @param bodyString the body of the request
     * @return RxObservable to handle the requests
     */
    public Observable<String> post(String url, String bodyString) {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                bodyString
        );

        Request req = new Request.Builder()
                .post(body)
                .url(url)
                .build();

        return makeRequest(req);
    }
}
