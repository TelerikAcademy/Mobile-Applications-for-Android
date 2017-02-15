package com.minkov.mvpdemos.views.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.mvpdemos.R;

public class MainActivity extends AppCompatActivity {
    public MainContracts.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainView mainView = new MainView();
        this.mainPresenter = new MainPresenter(mainView);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_content,
                        (Fragment) this.mainPresenter.getView()
                )
                .commit();
    }
}
