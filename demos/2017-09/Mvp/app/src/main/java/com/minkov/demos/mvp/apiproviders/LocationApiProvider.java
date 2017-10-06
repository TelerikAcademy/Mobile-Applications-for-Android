package com.minkov.demos.mvp.apiproviders;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.minkov.demos.mvp.base.BaseActivity;
import com.minkov.demos.mvp.base.CurrentActivityProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;

public class LocationApiProvider {
    private static final int REQUEST_CHECK_SETTINGS = 0x123;
    private final Context mContext;
    private final CurrentActivityProvider mCurrentActivityProvider;

    @Inject
    public LocationApiProvider(
            Context context,
            CurrentActivityProvider currentActivityProvider) {
        mContext = context;
        mCurrentActivityProvider = currentActivityProvider;
    }

    public Observable<Location> subscribeToUpdates() {
        final Activity currentActivity = mCurrentActivityProvider.getCurrentActivity();

        final LocationRequest locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setNumUpdates(5)
                .setInterval(100);
        final ReactiveLocationProvider locationProvider =
                new ReactiveLocationProvider(mContext);

        checkPermissions();
        return locationProvider.getUpdatedLocation(locationRequest)
                .map(new Function<android.location.Location, Location>() {
                    @Override
                    public Location apply(@NonNull android.location.Location androidLocation) throws Exception {
                        Location location = new Location(androidLocation.getLatitude(), androidLocation.getLongitude());
                        return location;
                    }
                });
    }

    private boolean checkPermissions() {
        BaseActivity activity = mCurrentActivityProvider.getCurrentActivity();
//        activity.setOnRequestPermissionResultLister(this);
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CHECK_SETTINGS);
            }
        }
        return true;
    }

    public class Location {
        private double mLatitude;
        private double mLongitude;

        public Location(double latitude, double longitude) {
            setLatitude(latitude);
            setLongitude(longitude);
        }

        public void setLatitude(double latitude) {
            this.mLatitude = latitude;
        }

        public double getLatitude() {
            return mLatitude;
        }

        public void setLongitude(double longitude) {
            this.mLongitude = longitude;
        }

        public double getLongitude() {
            return mLongitude;
        }

        @Override
        public String toString() {
            return String.format("%f, %f", getLatitude(), getLongitude());
        }
    }
}
