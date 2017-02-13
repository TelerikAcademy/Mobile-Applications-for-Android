package com.minkov.mvpdemos.views.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.mvpdemos.MvpApplication;
import com.minkov.mvpexplore2.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainContracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MvpApplication) getApplication())
                .getComponent()
                .inject(this);

        Fragment fragment = (Fragment) this.presenter.getView();

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_content, fragment)
                .commit();
    }
}
