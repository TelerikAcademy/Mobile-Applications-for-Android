package com.minkov.demos.mvp.Locations;

import com.minkov.demos.mvp.apiproviders.LocationApiProvider;
import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;

import io.reactivex.functions.Consumer;

public class LocationsPresenter implements LocationsContracts.Presenter {
    private final LocationApiProvider mLocationApiProvider;
    private final BaseSchedulerProvider mSchedulerProvider;
    private LocationsContracts.View mView;

    public LocationsPresenter(
            LocationApiProvider locationApiProvider, BaseSchedulerProvider schedulerProvider) {
        mLocationApiProvider = locationApiProvider;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(LocationsContracts.View view) {
        mView = view;
        mLocationApiProvider.subscribeToUpdates()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<LocationApiProvider.Location>() {
                    @Override
                    public void accept(LocationApiProvider.Location location) throws Exception {
                        mView.showLocation(location);
                    }
                });
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
