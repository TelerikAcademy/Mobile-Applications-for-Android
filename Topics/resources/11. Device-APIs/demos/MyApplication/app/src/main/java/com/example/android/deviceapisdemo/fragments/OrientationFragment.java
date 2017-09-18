package com.example.android.deviceapisdemo.fragments;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.deviceapisdemo.R;

public class OrientationFragment extends Fragment {
  private View rootView;
  private SensorManager sensorManager;

  private float[] lastMagFields = new float[3];
  private float[] lastAccels = new float[3];

  private float[] rotationMatrix = new float[16];
  private float[] orientation  = new float[4];

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_orientation, container, false);

    sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
    calcOrientation();

    return rootView;
  }

  private void calcOrientation() {
    if (SensorManager.getRotationMatrix(rotationMatrix, null,
            lastMagFields, lastAccels)) {
      SensorManager.getOrientation(rotationMatrix, orientation);

      /* 1 radian = 57.2957795 degrees */
      /* [0] : yaw, rotation around z axis
       * [1] : pitch, rotation around x axis
       * [2] : roll, rotation around y axis */
      float yaw = orientation[0] * 57.2957795f;
      float pitch = orientation[1] * 57.2957795f;
      float roll = orientation[2] * 57.2957795f;

      ((TextView) rootView.findViewById(R.id.roll))
              .setText("roll y: " + roll);
      ((TextView) rootView.findViewById(R.id.pitch))
              .setText("pitch x: " + pitch);
      ((TextView) rootView.findViewById(R.id.yaw))
              .setText("azi z: " + yaw);
    }
  }
}
