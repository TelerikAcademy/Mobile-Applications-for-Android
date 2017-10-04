package com.minkov.demos.mvp.PersonDetails;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.minkov.demos.mvp.BaseActivity;
import com.minkov.demos.mvp.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Implementation of {@link com.minkov.demos.mvp.PersonDetails.PersonDetailsContacts.View}
 */
public class PersonDetailsActivity extends BaseActivity {
    /**
     * Value for setting values in intents
     */
    public static final String EXTRA_PERSON_KEY = "EXTRA_PERSON_ID";

    @Inject
    PersonDetailsContacts.Presenter mPresenter;

    PersonDetailsFragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        String id = getIntent().getStringExtra(EXTRA_PERSON_KEY);

        mView = PersonDetailsFragment.newInstance();
        mPresenter.setPersonId(id);
        mView.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, mView)
                .commit();

        setupDrawer();
    }

    @Override
    protected Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }
}
