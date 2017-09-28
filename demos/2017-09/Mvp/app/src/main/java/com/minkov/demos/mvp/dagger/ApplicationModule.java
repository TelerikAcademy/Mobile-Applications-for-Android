package com.minkov.demos.mvp.dagger;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public abstract class ApplicationModule {
    /**
     * Binding the application context
     * @param application the application
     * @return the ApplicationContext
     */
    @Binds
    abstract Context bindContext(Application application);
}