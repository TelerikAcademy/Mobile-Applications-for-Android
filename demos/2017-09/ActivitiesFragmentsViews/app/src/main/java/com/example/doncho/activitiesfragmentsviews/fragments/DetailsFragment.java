package com.example.doncho.activitiesfragmentsviews.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doncho.activitiesfragmentsviews.R;
import com.example.doncho.activitiesfragmentsviews.models.Person;

public class DetailsFragment extends Fragment {
    private Person mPerson;
    private TextView mTvName;
    private TextView mTvAge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_details, container, false);

        mTvName = root.findViewById(R.id.tv_name);
        mTvAge = root.findViewById(R.id.tv_age);

        return root;
    }

    public void setObject(Person obj) {
        mPerson = obj;
        updateUi();
    }

    private void updateUi() {
        mTvName.setText(mPerson.getName());
        mTvAge.setText(mPerson.getAge() + "");
    }
}
