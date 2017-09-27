package com.minkov.demos.mvp.PersonsLists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.demos.mvp.R;

public class PersonsListActivity extends AppCompatActivity {
  private PersonsListFragment mView;
  private PersonsListContracts.Presenter mPresenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_persons_list);

    mPresenter = new PersonsListPresenter();

    mView = PersonsListFragment.newInstance();
    mView.setPresenter(mPresenter);

    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.frame_content, mView)
            .commit();
  }
}
