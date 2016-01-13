package com.example.android.deviceapisdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.deviceapisdemo.fragments.LocationFragment;
import com.example.android.deviceapisdemo.fragments.MotionSensorsFragment;
import com.example.android.deviceapisdemo.fragments.OrientationFragment;
import com.example.android.deviceapisdemo.fragments.StepCounterFragment;

public class MainActivity extends AppCompatActivity {
  private ViewPager viewPager;
  private DeviceApiPagerAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewPager = (ViewPager) findViewById(R.id.viewPager);
    adapter = new DeviceApiPagerAdapter(getSupportFragmentManager());
    viewPager.setAdapter(adapter);
  }

  public void onButtonClick(View view) {


  }

  public class DeviceApiPagerAdapter extends FragmentPagerAdapter {
    public DeviceApiPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public int getCount() {
      return 3;
    }

    @Override
    public Fragment getItem(int position) {
      Fragment fragment = null;
      switch (position) {
        case 0:
          fragment = new LocationFragment();
          break;
        case 1:
          fragment = new StepCounterFragment();
          break;
        case 2:
          fragment = new MotionSensorsFragment();
          break;
        case 3:
          fragment = new OrientationFragment();
          break;
      }

      return fragment;
    }
  }
}
