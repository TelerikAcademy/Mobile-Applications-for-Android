package com.minkov.demos.mvp.Locations;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.minkov.demos.mvp.base.BaseDrawerActivity;
import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.ui.ActivityUtils;

import javax.inject.Inject;

public class LocationsActivity extends BaseDrawerActivity {

    @Inject
    LocationsContracts.Presenter mPresenter;

    LocationsFragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_locations);
        super.onCreate(savedInstanceState);

        mView = LocationsFragment.newInstance();

        ActivityUtils.attachFragment(getSupportFragmentManager(), R.id.frame_content, mView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mView.setPresenter(mPresenter);
    }

    @Override
    protected Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }
}
