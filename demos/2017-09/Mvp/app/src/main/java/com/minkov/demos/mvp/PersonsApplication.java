package com.minkov.demos.mvp;

import com.minkov.demos.mvp.dagger.AppComponent;
import com.minkov.demos.mvp.dagger.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonsApplication extends DaggerApplication {
  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
    appComponent.inject(this);
    return appComponent;
  }
}
