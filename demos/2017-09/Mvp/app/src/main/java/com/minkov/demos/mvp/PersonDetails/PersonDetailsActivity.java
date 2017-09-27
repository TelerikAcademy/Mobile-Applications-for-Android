package com.minkov.demos.mvp.PersonDetails;

import android.os.Bundle;

import com.minkov.demos.mvp.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PersonDetailsActivity extends DaggerAppCompatActivity {
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
  }
}
