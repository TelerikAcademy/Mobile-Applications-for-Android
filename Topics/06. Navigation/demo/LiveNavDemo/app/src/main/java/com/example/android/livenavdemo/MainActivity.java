package com.example.android.livenavdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.livenavdemo.fragments.StepOneFragment;
import com.example.android.livenavdemo.fragments.StepThreeFragment;
import com.example.android.livenavdemo.fragments.StepTwoFragment;

public class MainActivity extends AppCompatActivity {
  ViewPager viewPager;
  ImageView imageView;
  PagerTitleStrip pagerTitleStrip;
  int myRequestCode = 1234;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView = (ImageView) this.findViewById(R.id.photo_taken);
    viewPager = (ViewPager) findViewById(R.id.viewPager);
    MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
    viewPager.setAdapter(adapter);

    ListView listView = (ListView) findViewById(R.id.left_drawer);
    ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
            this, R.layout.drawer_listview_item,
            getResources().getStringArray(R.array.planets));
    listView.setAdapter(listAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        viewPager.setCurrentItem(position);
      }
    });
  }

  public void navigateToFragment(View view) {
    switch (view.getId()) {
      case R.id.btn_fragment_2:
        viewPager.setCurrentItem(1);
        break;
      case R.id.btn_fragment_3:
        viewPager.setCurrentItem(2);
        break;
    }
  }

  public void takePhoto(View view) {
    Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePhotoIntent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(takePhotoIntent, myRequestCode);
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == myRequestCode && resultCode == RESULT_OK) {
      Bundle extras = data.getExtras();
      Bitmap imageBitmap = (Bitmap) extras.get("data");

      imageView = (ImageView) this.findViewById(R.id.photo_taken);
      imageView.setImageBitmap(imageBitmap);
    }
  }

  public void goToSecond(View view) {
    Intent intent = new Intent(this, SecondActivity.class);
    startActivity(intent);
  }

  public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public int getCount() {
      return 3;
    }

    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          Fragment fragment = new StepOneFragment();
          Bundle args = new Bundle();

          args.putString(StepOneFragment.TEXT, "Ala Bala");
          args.putInt(StepOneFragment.STEP_NUMBER, 1);

          fragment.setArguments(args);
          return fragment;
        case 1:
          return new StepTwoFragment();
        case 2:
          return new StepThreeFragment();
        default:
          return null;
      }
    }

    @Override
    public CharSequence getPageTitle(int position) {
      switch (position) {
        case 0: return "asdsfa";
        case 1: return "asdsfa";
        case 2: return "asdsfa";
        default: return "non";
      }
    }
  }
}
