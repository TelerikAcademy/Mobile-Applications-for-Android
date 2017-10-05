package com.minkov.demos.mvp.Location;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.minkov.demos.mvp.base.BaseDrawerActivity;
import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.ui.ActivityUtils;

import javax.inject.Inject;

public class LocationActivity extends BaseDrawerActivity {

    @Inject
    LocationContracts.Presenter mPresenter;

    private LocationFragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_location);
        super.onCreate(savedInstanceState);

        mView = LocationFragment.newInstance();

        ActivityUtils.attachFragment(getSupportFragmentManager(), R.id.frame_content, mView);
    }

    @Override
    protected Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }

    @Override
    protected void onResume() {
        mView.setPresenter(mPresenter);
        super.onResume();
    }
}
