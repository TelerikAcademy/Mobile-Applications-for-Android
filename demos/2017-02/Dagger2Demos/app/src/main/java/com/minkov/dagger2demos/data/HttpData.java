package com.minkov.dagger2demos.data;

import com.google.gson.Gson;
import com.minkov.dagger2demos.data.base.BaseData;
import com.minkov.dagger2demos.models.Superhero;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpData<T> extends BaseData<T> {
    private final OkHttpClient client;
    private final Gson gson;
    private final ApiUrl<T> apiUrl;
    private Class<T> klass;
    private Class<T[]> klassArray;

    @Inject
    public HttpData(ApiUrl<T> apiUrl, Class<T> klass, Class<T[]> klassArray) {
        this.apiUrl = apiUrl;
        this.client = new OkHttpClient();
        this.gson = new Gson();
        this.klass = klass;
        this.klassArray = klassArray;
    }

    @Override
    public Observable<T[]> getAll() {
        return Observable
                .create(new ObservableOnSubscribe<T[]>() {
                    @Override
                    public void subscribe(ObservableEmitter<T[]> e) throws Exception {
                        Request req = new Request.Builder()
                                .url(apiUrl.getUrl())
                                .build();

                        Response res = client.newCall(req).execute();

                        String json = res.body().string();

                        T[] result = gson.fromJson(json, klassArray);

                        e.onNext(result);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<T> getById(Object id) {
        return null;
    }

    @Override
    public Observable<T> add(T item) {
        return null;
    }
}
