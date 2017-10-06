package com.minkov.demos.mvp.Locations;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.apiproviders.LocationApiProvider;

public class LocationsFragment extends Fragment implements LocationsContracts.View {
    private LocationsContracts.Presenter mPresenter;

    public LocationsFragment() {
        // Required empty public constructor
    }

    public static LocationsFragment newInstance() {
        LocationsFragment fragment = new LocationsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_locations, container, false);
    }

    @Override
    public void setPresenter(LocationsContracts.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.subscribe(this);
    }

    @Override
    public void showLocation(LocationApiProvider.Location location) {
        Toast.makeText(getContext(), location.toString(), Toast.LENGTH_SHORT)
                .show();
    }
}
