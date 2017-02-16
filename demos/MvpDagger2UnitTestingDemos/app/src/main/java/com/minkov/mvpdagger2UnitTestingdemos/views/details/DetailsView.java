package com.minkov.mvpdagger2UnitTestingdemos.views.details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minkov.mvpdagger2UnitTestingdemos.R;
import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsView extends Fragment implements DetailsContracts.View {
    private TextView tvName;
    private DetailsContracts.Presenter presenter;

    public DetailsView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details_view, container, false);

        this.tvName = (TextView) root.findViewById(R.id.tvName);

        this.presenter.start();

        return root;
    }

    @Override
    public void setDetails(Superhero detail) {
        this.tvName.setText(detail.getName());
    }

    @Override
    public void setPresenter(DetailsContracts.Presenter presenter) {
        this.presenter = presenter;
    }
}
