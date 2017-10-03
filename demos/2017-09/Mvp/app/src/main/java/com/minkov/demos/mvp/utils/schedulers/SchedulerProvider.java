package com.minkov.demos.mvp.utils.schedulers;

import android.support.annotation.NonNull;

import javax.annotation.Nullable;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * SchedulerProvider for providing {@link Scheduler} instances, based on need
 * Created by doncho on 9/28/17.
 */

public final class SchedulerProvider implements BaseSchedulerProvider {

    @Nullable
    private static SchedulerProvider instance;

    private SchedulerProvider() {
    }

    /**
     * Getter for singleton instance of {@link SchedulerProvider}
     *
     * @return the Singleton instance
     */
    public static synchronized SchedulerProvider getInstance() {
        if (instance == null) {
            instance = new SchedulerProvider();
        }

        return instance;
    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}