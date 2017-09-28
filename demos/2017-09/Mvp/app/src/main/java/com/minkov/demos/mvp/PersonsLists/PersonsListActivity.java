package com.minkov.demos.mvp.PersonsLists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.minkov.demos.mvp.PersonDetails.PersonDetailsActivity;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsContacts;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsFragment;
import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.ui.base.ICanNavigate;
import com.minkov.demos.mvp.ui.base.NavigationHandlerBase;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PersonsListActivity extends DaggerAppCompatActivity implements ICanNavigate<Person> {
  private PersonsListFragment mListView;

  @Inject
  PersonsListContracts.Presenter mListPresenter;

  @Inject
  NavigationHandlerBase mNavigation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_persons_list);

    mListView = PersonsListFragment.newInstance(this);

    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.frame_list, mListView)
            .commit();
  }

  @Override
  protected void onResume() {
    mListView.setPresenter(mListPresenter);
    super.onResume();
  }

  @Override
  public void navigateWith(Person obj) {
    Intent intent = new Intent(this, PersonDetailsActivity.class);
    intent.putExtra(PersonDetailsActivity.EXTRA_PERSON_KEY, obj.getId());
    mNavigation.navigateTo(intent);
  }
}
