package com.example.doncho.activitiesfragmentsviews.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doncho.activitiesfragmentsviews.R;
import com.example.doncho.activitiesfragmentsviews.models.Person;
import com.example.doncho.activitiesfragmentsviews.nav.OnShowDetailsListener;

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private Person[] mPeople;

    private ListView mLvPeople;
    private ArrayAdapter<Person> mPeopleAdapter;
    private OnShowDetailsListener<Person> mOnShowDetailsListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        mPeopleAdapter = new ArrayAdapter<Person>(getContext(), android.R.layout.simple_list_item_1) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = null;
                if(convertView == null || !(convertView instanceof TextView)) {
                    LayoutInflater viewInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = (TextView) viewInflater.inflate(android.R.layout.simple_list_item_1, null);
                } else {
                    view = (TextView) convertView;
                }

                view.setText(getItem(position).getName());

                return view;
            }

        };

        mLvPeople = root.findViewById(R.id.lv_people);
        mLvPeople.setAdapter(mPeopleAdapter);
        mLvPeople.setOnItemClickListener(this);

        return root;
    }

    public void setList(Person[] list) {
        mPeople = list;
        updateUI();
    }

    private void updateUI() {
        mPeopleAdapter.clear();
        mPeopleAdapter.addAll(mPeople);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mOnShowDetailsListener.OnShowDetails((Person) adapterView.getItemAtPosition(i));
    }

    public void setOnShowDetailsListener(OnShowDetailsListener<Person> onShowDetailsListener) {
        mOnShowDetailsListener = onShowDetailsListener;
    }
}
