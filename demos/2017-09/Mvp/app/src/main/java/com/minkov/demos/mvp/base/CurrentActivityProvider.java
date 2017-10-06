package com.minkov.demos.mvp.base;

import android.app.Activity;

public interface CurrentActivityProvider {
    void setCurrentActivity(BaseActivity activity);
    BaseActivity getCurrentActivity();
}
