package com.minkov.httpdemos.tasks;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class HttpTask<T> extends AsyncTask<String, Boolean, String> {
    private final OnPostCreateFinished<T> onPostCreateFinished;
    private final OkHttpClient okHttpClient;
    private final Class<T> klass;

    public HttpTask(Class<T> klass, HttpTaskWithArrayResult.OnPostCreateFinished<T> onPostCreateFinished) {
        this.onPostCreateFinished = onPostCreateFinished;
        this.okHttpClient = new OkHttpClient();
        this.klass = klass;
    }

    @Override
    protected String doInBackground(String... params) {
        String url = params[0];
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = this.okHttpClient.newCall(request)
                    .execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected OnPostCreateFinished<T> getOnPostCreateFinished() {
        return onPostCreateFinished;
    }

    protected Class<T> getKlass() {
        return klass;
    }

    public interface OnPostCreateFinished<T> {
        void call(T value);
    }

}
