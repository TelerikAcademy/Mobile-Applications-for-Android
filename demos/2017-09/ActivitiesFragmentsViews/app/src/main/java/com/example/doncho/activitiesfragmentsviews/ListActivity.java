package com.example.doncho.activitiesfragmentsviews;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.doncho.activitiesfragmentsviews.fragments.DetailsFragment;
import com.example.doncho.activitiesfragmentsviews.fragments.ListFragment;
import com.example.doncho.activitiesfragmentsviews.models.Person;
import com.example.doncho.activitiesfragmentsviews.nav.OnShowDetailsListener;
import com.example.doncho.activitiesfragmentsviews.models.utils.ModelUtils;

public class ListActivity extends Activity implements OnShowDetailsListener<Person> {

    private static final int PEOPLE_COUNT = 50;
    private ListFragment mListFragment;
    private DetailsFragment mDetailsFragment;

    private Person[] mPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mPeople = ModelUtils.getRandomPeople(PEOPLE_COUNT);

        mListFragment = new ListFragment();

        FragmentTransaction trans = getFragmentManager()
                .beginTransaction();

        trans.replace(R.id.frame_list, mListFragment);

        if (checkIfTablet()) {
            mDetailsFragment = new DetailsFragment();
            trans.replace(R.id.frame_details, mDetailsFragment);
        }

        trans.commit();
    }

    @Override
    public void OnShowDetails(Person obj) {
        if(checkIfTablet()) {
            mDetailsFragment.setObject(obj);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(DetailsActivity.PARAM_NAME, obj);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListFragment.setList(mPeople);
        mListFragment.setOnShowDetailsListener(this);
        if (mPeople.length > 0 && checkIfTablet()) {
            mDetailsFragment.setObject(mPeople[0]);
        }
    }

    private boolean checkIfTablet() {
        return findViewById(R.id.frame_details) != null;
    }
}
