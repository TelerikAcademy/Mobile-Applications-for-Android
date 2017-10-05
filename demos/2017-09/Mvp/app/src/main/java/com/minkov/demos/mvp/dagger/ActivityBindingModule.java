package com.minkov.demos.mvp.dagger;

import com.minkov.demos.mvp.Location.LocationActivity;
import com.minkov.demos.mvp.Location.LocationModule;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsActivity;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsModule;
import com.minkov.demos.mvp.PersonsLists.PersonsListActivity;
import com.minkov.demos.mvp.PersonsLists.PersonsListModule;
import com.minkov.demos.mvp.Profile.ProfileActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Module for setup of activities and their dependent modules
 * Created by minkov on 9/27/17.
 */

@Module
public abstract class ActivityBindingModule {

    /**
     * Config {@link PersonsListActivity}
     *
     * @return Dagger initialized activity
     */

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            PersonsListModule.class,
            PersonDetailsModule.class,
    })
    abstract PersonsListActivity personsListActivity();

    /**
     * Config {@link PersonDetailsActivity}
     *
     * @return Dagger initialized activity
     */
    @ActivityScoped
    @ContributesAndroidInjector(modules = PersonDetailsModule.class)
    abstract PersonDetailsActivity personDetailsActivity();

    /**
     * Config {@link ProfileActivity}
     *
     * @return Dagger initialized activity
     */
    @ActivityScoped
    @ContributesAndroidInjector(modules = {
    })
    abstract ProfileActivity profileActivity();

    /**
     * Config {@link LocationActivity}
     *
     * @return Dagger initialized activity
     */
    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            LocationModule.class
    })
    abstract LocationActivity locationActivity();
}
