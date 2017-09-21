package com.minkov.httpdemos.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpTask<T> extends AsyncTask<String, Boolean, String> {
    private final OnHttpTaskResult<T> onHttpTaskResult;
    private final OkHttpClient okHttpClient;
    private final Class<T> klass;
    private Exception exception;

    public HttpTask(Class<T> klass, OnHttpTaskResult<T> onHttpTaskResult) {
        this.onHttpTaskResult = onHttpTaskResult;
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
            this.setException(e);
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        Gson gson = new Gson();

        T result = gson.fromJson(json, this.getKlass());

        this.getOnHttpTaskResult()
                .call(this.getException(), result);
    }


    protected OnHttpTaskResult<T> getOnHttpTaskResult() {
        return onHttpTaskResult;
    }

    protected Class<T> getKlass() {
        return klass;
    }

    protected void setException(Exception exception) {
        this.exception = exception;
    }

    protected Exception getException() {
        return this.exception;
    }

    public interface OnHttpTaskResult<T> {
        void call(Exception ex, T result);
    }

}
