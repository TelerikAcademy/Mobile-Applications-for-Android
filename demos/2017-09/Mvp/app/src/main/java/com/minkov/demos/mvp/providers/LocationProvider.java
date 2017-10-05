package com.minkov.demos.mvp.providers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.minkov.demos.mvp.base.CurrentActivityManager;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;


/**
 * Wrapper for providing locations
 */
public class LocationProvider {
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private final Context mContext;
    private final FusedLocationProviderClient mFusedLocationClient;
    private final CurrentActivityManager mCurrentActivityManager;

    @Inject
    public LocationProvider(Context context, CurrentActivityManager currentActivityManager) {
        mContext = context;
        mCurrentActivityManager = currentActivityManager;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext);
    }

    public Observable<Location> subsribeToUpdates() {
        LocationRequest locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setNumUpdates(5)
                .setInterval(100);

        ReactiveLocationProvider locationProvider = new ReactiveLocationProvider(mContext);

        checkLocationPermission();
        return locationProvider.getUpdatedLocation(locationRequest)
                .map(new Function<android.location.Location, Location>() {
                    @Override
                    public Location apply(@NonNull android.location.Location location) throws Exception {
                        return new Location(location.getLatitude(), location.getLongitude(), location.getAltitude());
                    }
                });
    }

    public Observable<Location> subsribeToUpdates2() {
        final LocationRequest locationRequest = createLocationRequest();
        final Activity activity = mCurrentActivityManager.getCurrentActivity();
        return Observable.create(new ObservableOnSubscribe<Location>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<Location> e) throws Exception {
                checkLocationPermission();
                mFusedLocationClient.requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        android.location.Location androidLocation = locationResult.getLastLocation();
                        Location location = new Location(androidLocation.getLatitude(), androidLocation.getLongitude(), androidLocation.getAltitude());

                        e.onNext(location);
                    }
                }, null);
            }
        });
    }

    private LocationRequest createLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();

        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return locationRequest;
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(mContext,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(mCurrentActivityManager.getCurrentActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(mCurrentActivityManager.getCurrentActivity())
                        .setTitle("Want location")
                        .setMessage("Enable location")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(mCurrentActivityManager.getCurrentActivity(),
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                ActivityCompat.requestPermissions(mCurrentActivityManager.getCurrentActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    public class Location {

        private double mLatitude;
        private double mLongitude;
        private double mAltitude;

        public Location(double latitude, double longitude, double altitude) {
            setLatitude(latitude);
            setLongitude(longitude);
            setAltitude(altitude);
        }

        public double getLatitude() {
            return mLatitude;
        }

        public void setLatitude(double latitude) {
            this.mLatitude = latitude;
        }

        public double getLongitude() {
            return mLongitude;
        }

        public void setLongitude(double longitude) {
            this.mLongitude = longitude;
        }

        public double getAltitude() {
            return mAltitude;
        }

        public void setAltitude(double altitude) {
            this.mAltitude = altitude;
        }

        @Override
        public String toString() {
            return String.format("%f, %f, %f", mLatitude, mLongitude, mAltitude);
        }
    }
}
