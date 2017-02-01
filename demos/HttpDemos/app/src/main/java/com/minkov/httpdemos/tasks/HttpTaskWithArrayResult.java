package com.minkov.httpdemos.tasks;

import com.google.gson.Gson;

public class HttpTaskWithArrayResult<T> extends HttpTask<T[]> {
    public HttpTaskWithArrayResult(Class<T[]> klass, OnPostCreateFinished<T[]> onPostCreateFinished) {
        super(klass, onPostCreateFinished);
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);

        Gson gson = new Gson();

        T[] result = gson.fromJson(json, this.getKlass());

        this.getOnPostCreateFinished()
                .call(result);
    }
}
