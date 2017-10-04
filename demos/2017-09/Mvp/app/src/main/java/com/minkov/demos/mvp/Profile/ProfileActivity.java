package com.minkov.demos.mvp.Profile;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.minkov.demos.mvp.BaseActivity;
import com.minkov.demos.mvp.R;

/**
 * Activity for show user profile
 */
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_profile);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }
}
