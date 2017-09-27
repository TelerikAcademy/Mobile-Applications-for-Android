package com.minkov.demos.mvp.dagger;

import com.minkov.demos.mvp.PersonDetails.PersonDetailsActivity;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsModule;
import com.minkov.demos.mvp.PersonsLists.PersonsListActivity;
import com.minkov.demos.mvp.PersonsLists.PersonsListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public abstract class ActivityBindingModule {
  @ActivityScoped
  @ContributesAndroidInjector(modules = PersonsListModule.class)
  abstract PersonsListActivity personsListActivity();

  @ActivityScoped
  @ContributesAndroidInjector(modules = PersonDetailsModule.class)
  abstract PersonDetailsActivity personDetailsActivity();
}
