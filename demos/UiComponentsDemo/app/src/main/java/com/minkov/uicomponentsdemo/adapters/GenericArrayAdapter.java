package com.minkov.uicomponentsdemo.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class GenericArrayAdapter<T> extends ArrayAdapter<T> {
    private final CreateViewFunction<T> createViewFunction;
    private final int resource;

    public GenericArrayAdapter(Context context, @LayoutRes int resource, List<T> items, CreateViewFunction<T> createViewFunction) {
        super(context, resource, items);
        this.resource = resource;
        this.createViewFunction = createViewFunction;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(this.resource, parent, false);
        }

        T item = this.getItem(position);
        return this.createViewFunction.apply(item, view);
    }
}
