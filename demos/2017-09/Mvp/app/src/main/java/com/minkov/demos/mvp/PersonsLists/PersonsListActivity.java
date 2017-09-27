package com.minkov.demos.mvp.PersonsLists;

import android.os.Bundle;

import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.models.Person;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PersonsListActivity extends DaggerAppCompatActivity {
  private PersonsListFragment mView;

  @Inject
  PersonsListContracts.Presenter mPresenter;

  @Inject
  BaseRepository<Person> data;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_persons_list);

    // mPresenter = new PersonsListPresenter();

    mView = PersonsListFragment.newInstance();

    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.frame_content, mView)
            .commit();
  }

  @Override
  protected void onResume() {
    mView.setPresenter(mPresenter);
    super.onResume();
  }
}
