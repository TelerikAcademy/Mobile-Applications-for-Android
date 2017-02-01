package com.minkov.navigationdemos.fragments.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minkov.navigationdemos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {


    public TabFragment() {
        // Required empty public constructor
    }

    public static TabFragment createFragment(int position) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab, container, false);

        int position = this.getArguments().getInt("position");

        ((TextView) root.findViewById(R.id.tv_text))
                .setText(String.format("Position %d", position));

        return root;
    }

}
