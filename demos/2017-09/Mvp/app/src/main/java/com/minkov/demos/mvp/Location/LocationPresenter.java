package com.minkov.demos.mvp.Location;

import com.minkov.demos.mvp.providers.LocationProvider;
import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;

import io.reactivex.functions.Consumer;

/**
 * Created by doncho on 10/5/17.
 */

public class LocationPresenter implements LocationContracts.Presenter {
    private final LocationProvider mLocationProvider;
    private final BaseSchedulerProvider mSchedulerProvider;
    private LocationContracts.View mView;

    public LocationPresenter(LocationProvider locationProvider, BaseSchedulerProvider schedulerProvider) {
        mLocationProvider = locationProvider;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(LocationContracts.View view) {
        mView = view;
        mLocationProvider.subsribeToUpdates()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<LocationProvider.Location>() {
                    @Override
                    public void accept(LocationProvider.Location location) throws Exception {
                        mView.showLocation(location);
                    }
                });
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
