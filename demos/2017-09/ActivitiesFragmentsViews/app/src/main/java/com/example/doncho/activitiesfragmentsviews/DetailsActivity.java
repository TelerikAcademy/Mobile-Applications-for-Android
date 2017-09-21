package com.example.doncho.activitiesfragmentsviews;

import android.app.Activity;
import android.os.Bundle;

import com.example.doncho.activitiesfragmentsviews.fragments.DetailsFragment;
import com.example.doncho.activitiesfragmentsviews.models.Person;

public class DetailsActivity extends Activity {

    public static final String PARAM_NAME = "EXTRA_PERSON_PARAM";
    private DetailsFragment mDetailsFragment;
    private Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mDetailsFragment = new DetailsFragment();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_details, mDetailsFragment)
                .commit();

        mPerson = (Person) getIntent().getSerializableExtra(PARAM_NAME);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDetailsFragment.setObject(mPerson);
    }
}
