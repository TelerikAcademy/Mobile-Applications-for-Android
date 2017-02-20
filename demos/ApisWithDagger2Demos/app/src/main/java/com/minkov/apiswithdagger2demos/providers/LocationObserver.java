package com.minkov.apiswithdagger2demos.providers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Created by minkov on 2/17/17.
 */

public class LocationObserver {
    private final Context appContext;
    private Activity activityContext;

    private final LocationManager locationManager;

    @Inject
    public LocationObserver(Context appContext) {
        this.appContext = appContext;
        this.locationManager = (LocationManager) appContext.getSystemService(Context.LOCATION_SERVICE);
    }

    public Observable<Location> getLocationObserver() {
        return Observable.create(new ObservableOnSubscribe<Location>() {
            @Override
            public void subscribe(final ObservableEmitter<Location> e) throws Exception {
                LocationListener listener = new LocationListenerWithDefaults() {
                    @Override
                    public void onLocationChanged(Location location) {
                        e.onNext(location);
                    }
                };

                if (ActivityCompat.checkSelfPermission(activityContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(activityContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(activityContext, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);

                    return;
                }

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
            }
        });
    }

    public Observable<Location> getLocationOnce() {
        return Observable.create(new ObservableOnSubscribe<Location>() {
            @Override
            public void subscribe(final ObservableEmitter<Location> e) throws Exception {
                getLocationObserver()
                        .subscribe(new Consumer<Location>() {
                            @Override
                            public void accept(Location location) throws Exception {
                                e.onNext(location);
                                e.onComplete();
                            }
                        });
            }
        });
    }

    public void setActivityContext(Activity activityContext) {
        this.activityContext = activityContext;
    }

    class LocationListenerWithDefaults implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

}