package com.minkov.demos.mvp.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public abstract class ApplicationModule {
  @Binds
  abstract Context bindContext(Application application);
}