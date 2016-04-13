package com.example.android.deviceapisdemo.fragments;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.deviceapisdemo.R;

public class LocationFragment extends Fragment {
  private View rootView;
  private LocationManager locationManager;
  private LocationListener locationListener;

  @TargetApi(Build.VERSION_CODES.M)
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_location, container, false);
    locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


    locationListener = new DemoLocationListener();
    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
        ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        getActivity().requestPermissions(new String[] {
              Manifest.permission.ACCESS_FINE_LOCATION,
              Manifest.permission.ACCESS_COARSE_LOCATION },
              getTargetRequestCode());
    }
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

    ((Button) rootView.findViewById(R.id.btn_stop_location))
            .setOnClickListener(new LocationOnClickListener());

    return rootView;
  }

  private void askForPermissions() {

  }

  private class LocationOnClickListener implements View.OnClickListener {
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
      if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
              ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        return;
      }

      locationManager.removeUpdates(locationListener);
    }
  }

  private class DemoLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {

      ((TextView) rootView.findViewById(R.id.tv_location))
              .setText(location.toString());
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
