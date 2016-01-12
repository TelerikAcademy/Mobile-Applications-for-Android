package com.example.android.datademo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.datademo.fragments.AccessingNetworkDataFragment;
import com.example.android.datademo.fragments.InternalStorageFragment;
import com.example.android.datademo.fragments.SQLiteFragment;
import com.example.android.datademo.fragments.SharedPreferencesFragment;

public class MainActivity extends AppCompatActivity {
  ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewPager = (ViewPager) findViewById(R.id.view_pager);
    PagerAdapter adapter = new DataStorageDemoAdapter(getSupportFragmentManager());

    viewPager.setAdapter(adapter);
  }

  private class DataStorageDemoAdapter extends FragmentPagerAdapter {
    public DataStorageDemoAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      Fragment fragment = null;
      switch (position) {
        case 0:
          fragment = new SharedPreferencesFragment();
          break;
        case 1:
          fragment = new InternalStorageFragment();
          break;
        case 2:
          fragment = new SQLiteFragment();
          break;
        case 3:
          fragment = new AccessingNetworkDataFragment();
          break;
      }

      return fragment;
    }

    @Override
    public int getCount() {
      return 4;
    }
  }
}
