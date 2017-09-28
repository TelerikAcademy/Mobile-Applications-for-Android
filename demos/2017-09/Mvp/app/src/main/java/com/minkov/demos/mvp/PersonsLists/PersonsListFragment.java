package com.minkov.demos.mvp.PersonsLists;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.models.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonsListFragment extends Fragment
        implements PersonsListContracts.View, AdapterView.OnItemClickListener {
    private ListView mListViewPersons;
    private ArrayAdapter<Person> mPersonsAdapter;
    private PersonsListContracts.Presenter mPresenter;

    /**
     * Empty constructor is mandatory for fragments
     */
    public PersonsListFragment() {
    }

    /**
     * Factory method for creating a new instance of {@link PersonsListFragment}
     *
     * @return the instance
     */
    public static PersonsListFragment newInstance() {
        PersonsListFragment fragment = new PersonsListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_persons_list, container, false);

        mPersonsAdapter = new ArrayAdapter<Person>(getContext(), android.R.layout.simple_list_item_1) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = null;

                if (convertView == null || !(convertView instanceof TextView)) {
                    LayoutInflater viewInflater
                            = (LayoutInflater) getContext()
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    view = (TextView) viewInflater.inflate(android.R.layout.simple_list_item_1, null);
                } else {
                    view = (TextView) convertView;
                }

                view.setText(getItem(position).getName());

                return view;
            }
        };

        mListViewPersons = root.findViewById(R.id.lv_persons);
        mListViewPersons.setAdapter(mPersonsAdapter);
        mListViewPersons.setOnItemClickListener(this);

        return root;
    }

    /**
     * Sets the data to visualize
     *
     * @param persons array of objects to visualize
     */
    public void setPersons(Person[] persons) {
        mPersonsAdapter.clear();
        mPersonsAdapter.addAll(persons);
    }

    @Override
    public void onResume() {
        mPresenter.subscribe(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mPresenter.unsubscribe();
        super.onPause();
    }

    @Override
    public void onDestroy() {
//    mPersonsListPresenter = null;
        super.onDestroy();
        mPresenter.unsubscribe();
        mPresenter = null;
    }

    @Override
    public void setPresenter(PersonsListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mPresenter.onPersonSelect(i);
    }
}
