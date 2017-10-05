package com.minkov.demos.mvp.base;

import android.app.Activity;

import com.minkov.demos.mvp.PersonsApplication;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by doncho on 10/5/17.
 */

public class BaseActivity extends DaggerAppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        getPersonsApplication().setCurrentActivity(this);
    }

    @Override
    protected void onPause() {
        clearReferences();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences() {
        Activity currActivity = getPersonsApplication()
                .getCurrentActivity();
        if (this.equals(currActivity))
            getPersonsApplication().setCurrentActivity(null);
    }

    private PersonsApplication getPersonsApplication() {
        return (PersonsApplication) getApplicationContext();
    }
}
