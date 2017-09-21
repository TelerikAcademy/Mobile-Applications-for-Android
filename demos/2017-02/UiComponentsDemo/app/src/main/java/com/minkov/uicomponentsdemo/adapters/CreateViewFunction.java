package com.minkov.uicomponentsdemo.adapters;

import android.view.View;

public interface CreateViewFunction<T> {
    View apply(T item, View view);
}
