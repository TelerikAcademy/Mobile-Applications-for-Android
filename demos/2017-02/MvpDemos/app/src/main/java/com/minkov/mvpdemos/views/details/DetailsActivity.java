package com.minkov.mvpdemos.views.details;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.mvpdemos.R;
import com.minkov.mvpdemos.views.main.MainContracts;

public class DetailsActivity extends AppCompatActivity {


    private DetailsContracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String name = this.getIntent().getStringExtra("details");
        DetailsContracts.View detailsView = new DetailsView();

        this.presenter = new DetailsPresenter(detailsView);
        this.presenter.setName(name);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_content,
                        (Fragment) this.presenter.getView())
                .commit();
    }
}
