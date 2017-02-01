package com.minkov.httpdemos.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpTaskWithSingleResult<T> extends HttpTask<T> {
    public HttpTaskWithSingleResult(Class<T> klass, OnPostCreateFinished<T> onPostCreateFinished) {
        super(klass, onPostCreateFinished);
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);

        Gson gson = new Gson();

        T result = gson.fromJson(json, this.getKlass());

        this.getOnPostCreateFinished()
                .call(result);
    }

}
