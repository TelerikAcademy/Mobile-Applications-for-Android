package com.minkov.demos.mvp.utils;

import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;
import com.minkov.demos.mvp.utils.schedulers.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Utils module
 * Created by doncho on 9/28/17.
 */

@Module
public class UtilsModule {
    @Provides
    BaseSchedulerProvider provideBaseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
