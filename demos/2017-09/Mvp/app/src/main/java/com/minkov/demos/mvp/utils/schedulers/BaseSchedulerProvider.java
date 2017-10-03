package com.minkov.demos.mvp.utils.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by doncho on 9/28/17.
 */

public interface BaseSchedulerProvider {
    /**
     * Provides computation Scheduler
     * @return computation Scheduler
     */
    @NonNull
    Scheduler computation();

    /**
     * Provides Input/Output Scheduler
     * @return Input/Output Scheduler
     */
    @NonNull
    Scheduler io();


    /**
     * Provides ui tread scheduler
     * @return Provides ui tread scheduler
     */
    @NonNull
    Scheduler ui();
}
