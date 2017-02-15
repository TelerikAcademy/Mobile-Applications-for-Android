package com.minkov.mvpdagger2demos.views.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.mvpdagger2demos.MvpDagger2Application;
import com.minkov.mvpdagger2demos.R;
import com.minkov.mvpdagger2demos.ui.ModalFactory;
import com.minkov.mvpdagger2demos.ui.Notifier;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    public MainContracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inject();

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_content,
                        (Fragment) this.presenter.getView()
                )
                .commit();
    }

    private void inject() {
        ((MvpDagger2Application)this.getApplication())
                .getComponent()
                .inject(this);
    }
}
