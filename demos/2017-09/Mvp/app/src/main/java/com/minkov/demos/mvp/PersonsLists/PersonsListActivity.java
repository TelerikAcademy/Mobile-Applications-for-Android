package com.minkov.demos.mvp.PersonsLists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.minkov.demos.mvp.base.BaseDrawerActivity;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsActivity;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsContacts;
import com.minkov.demos.mvp.PersonDetails.PersonDetailsFragment;
import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.ui.ActivityUtils;

import java.io.Serializable;

import javax.inject.Inject;

/**
 * The implementation of the {@link com.minkov.demos.mvp.PersonsLists.PersonsListContracts.View} class
 */
public class PersonsListActivity extends BaseDrawerActivity implements PersonsListContracts.Router {
    private static final String EXTRA_VIEW_STATE_KEY = "VIEW_STATE_KEY_LIST";
    // CHECKSTYLE:OFF
    @SuppressWarnings("CheckStyle")
    @Inject
    PersonsListContracts.Presenter mPersonsListPresenter;
    // CHECKSTYLE:ON

    @SuppressWarnings("CheckStyle")
    @Inject
    PersonDetailsContacts.Presenter mPersonDetailsPresenter;

    private PersonsListFragment mPersonsListView;
    private PersonDetailsFragment mPersonDetailsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_persons_list);
        super.onCreate(savedInstanceState);

        mPersonsListView = PersonsListFragment.newInstance();
        PersonsListContracts.ViewState viewState = getViewState(savedInstanceState);
        mPersonsListPresenter.setViewState(viewState);

        ActivityUtils.attachFragment(getSupportFragmentManager(), R.id.frame_list, mPersonsListView);

        if (isTablet()) {
            mPersonDetailsView = PersonDetailsFragment.newInstance();
            mPersonDetailsView.setPresenter(mPersonDetailsPresenter);
            ActivityUtils.attachFragment(getSupportFragmentManager(), R.id.frame_details, mPersonDetailsView);
        }
    }

    private PersonsListContracts.ViewState getViewState(Bundle bundle) {
        if (bundle == null || bundle.containsKey(EXTRA_VIEW_STATE_KEY) == false) {
            return new PersonsListViewState();
        } else {
            Serializable serializable = bundle.getSerializable(EXTRA_VIEW_STATE_KEY);
            return (PersonsListContracts.ViewState) serializable;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_VIEW_STATE_KEY, mPersonsListPresenter.getViewState());
    }

    @Override
    protected void onResume() {
        mPersonsListPresenter.setRouter(this);
        mPersonsListView.setPresenter(mPersonsListPresenter);
        super.onResume();
    }

    @Override
    public void showDetails(Person obj) {
        if (isTablet()) {
            mPersonDetailsPresenter.setPersonId(obj.getId());
        } else {
            Intent intent = new Intent(this, PersonDetailsActivity.class);
            intent.putExtra(PersonDetailsActivity.EXTRA_PERSON_KEY, obj.getId());
            startActivity(intent);
        }
    }

    private boolean isTablet() {
        return ActivityUtils.containsView(this, R.id.frame_details);
    }

    @Override
    protected Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }
}
