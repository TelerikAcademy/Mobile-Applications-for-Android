package com.minkov.demos.mvp.base;

import android.app.Activity;

/**
 * Created by doncho on 10/5/17.
 */

public interface CurrentActivityManager {
    Activity getCurrentActivity();
    void setCurrentActivity(Activity activity);
}
