package com.minkov.demos.mvp.Location;

import com.minkov.demos.mvp.providers.LocationProvider;
import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Module for Dagger
 */
@Module
public class LocationModule {

    /**
     * Provide s a {@link com.minkov.demos.mvp.Location.LocationContracts.Presenter} instance
     *
     * @return a {@link LocationPresenter} instance
     */
    @Provides
    LocationContracts.Presenter provideLocationPresenter(LocationProvider locationProvider, BaseSchedulerProvider schedulerProvider) {
        return new LocationPresenter(locationProvider, schedulerProvider);
    }
}
