package com.minkov.demos.mvp.ui;

import android.content.Context;

import com.minkov.demos.mvp.ui.base.NavigationHandlerBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class UiModule {
  @Provides
  @Singleton
  NavigationHandlerBase providesNavigationHandler(Context context) {
    return new NavigationHandler(context);
  }
}
