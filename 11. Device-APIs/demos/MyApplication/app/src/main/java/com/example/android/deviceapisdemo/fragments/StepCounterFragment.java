package com.example.android.deviceapisdemo.fragments;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.deviceapisdemo.R;

public class StepCounterFragment extends Fragment {
  View rootView;
  private SensorManager sensorManager;
  private Sensor sensor;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = (View) inflater.inflate(R.layout.fragment_step_count, container, false);

    sensorManager = (SensorManager) getContext()
            .getSystemService(getContext().SENSOR_SERVICE);
    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

    return rootView;
  }
}
