package com.minkov.navigationdemos.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.minkov.navigationdemos.R;
import com.minkov.navigationdemos.fragments.tabs.TabFragment;

import java.util.ArrayList;

public class TabsNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_navigation);

        ViewPager pager = (ViewPager) findViewById(R.id.tabs_pager);
        pager.setAdapter(new TabsNavigationAdapter(getSupportFragmentManager()));

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
    }

    public class TabsNavigationAdapter extends FragmentStatePagerAdapter {
        public TabsNavigationAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:


            }

            return TabFragment.createFragment(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return String.format("Tab %d", position);
        }
    }
}
