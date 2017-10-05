package com.minkov.demos.mvp.Location;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.providers.LocationProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment implements LocationContracts.View {

    private LocationContracts.Presenter mPresenter;

    public LocationFragment() {
        // Required empty public constructor
    }

    public static LocationFragment newInstance() {
        LocationFragment fragment = new LocationFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void setPresenter(LocationContracts.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.subscribe(this);
    }

    @Override
    public void showLocation(LocationProvider.Location location) {
        Toast.makeText(getContext(), location.toString(), Toast.LENGTH_SHORT)
                .show();
    }
}
