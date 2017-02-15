package com.minkov.mvpdagger2demos.views.details;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.mvpdagger2demos.MvpDagger2Application;
import com.minkov.mvpdagger2demos.R;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity {

    @Inject
    public DetailsContracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String name = this.getIntent().getStringExtra("details");

        this.inject();

        this.presenter.setId(name);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_content,
                        (Fragment) this.presenter.getView())
                .commit();
    }

    private void inject() {
        ((MvpDagger2Application) this.getApplication())
                .getComponent()
                .inject(this);
    }
}
