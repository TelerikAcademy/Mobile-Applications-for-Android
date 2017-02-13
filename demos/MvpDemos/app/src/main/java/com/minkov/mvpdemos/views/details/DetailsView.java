package com.minkov.mvpdemos.views.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minkov.mvpexplore2.R;
import com.minkov.mvpdemos.models.Superhero;
import com.minkov.mvpdemos.views.base.BaseViewFragment;

/**
 * Created by minkov on 2/13/17.
 */

public class DetailsView extends BaseViewFragment
        implements DetailsContracts.View {
    private DetailsContracts.Presenter presenter;
    private TextView tvName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details_view, container, false);

        this.tvName = (TextView) root.findViewById(R.id.tvName);

        Object id = this.getSuperheroId();
        this.presenter.start(id);
        return root;
    }

    @Override
    public void setPresenter(DetailsContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setItemDetails(Superhero details) {
        this.tvName.setText(details.getName());
    }

    public Object getSuperheroId() {
        return ((Superhero) getActivity().getIntent().getSerializableExtra("sh"))
                .getId();
    }
}
