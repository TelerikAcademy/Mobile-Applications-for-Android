package com.example.android.deviceapisdemo.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.deviceapisdemo.R;

public class MotionSensorsFragment extends Fragment {
  private View rootView;
  private SensorManager sensorManager;
  private Sensor vectorSensor;
  private Sensor orientationSensor;
  private Sensor geomagneticSensor;
  private Sensor proximitySensor;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_motion_sensors, container, false);

    sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
    vectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);

    geomagneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    sensorManager.registerListener(new DemoSensorListener(), proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
    sensorManager.registerListener(new DemoSensorListener(), vectorSensor, SensorManager.SENSOR_DELAY_NORMAL);


    return rootView;
  }

  private class DemoSensorListener implements SensorEventListener {

    @Override
    public void onSensorChanged(SensorEvent event) {
      float distance = event.values[0];

      ((TextView) rootView.findViewById(R.id.tv_proximity))
              .setText(String.format("%s", distance));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
      // Do something here if sensor accuracy changes.
    }
  }
}
