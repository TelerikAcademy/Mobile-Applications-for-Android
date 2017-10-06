package com.minkov.demos.mvp.Locations;

import com.minkov.demos.mvp.apiproviders.LocationApiProvider;
import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class LocationsModule {

    @Provides
    LocationsContracts.Presenter providesLocationsPresenter(
            LocationApiProvider locationApiProvider,
            BaseSchedulerProvider schedulerProvider) {
        return new LocationsPresenter(locationApiProvider, schedulerProvider);
    }
}
