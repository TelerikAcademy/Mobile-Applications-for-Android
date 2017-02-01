package com.minkov.navigationdemos.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.minkov.navigationdemos.R;
import com.minkov.navigationdemos.utis.DrawerItemInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DrawerFragment extends Fragment {

    private static final String ARG_DRAWER_ITEMS_KEY = "item-key";
    private Drawer.OnDrawerItemClickListener onDrawerItemClickListener;

    public DrawerFragment() {
        // Required empty public constructor
    }

    public static DrawerFragment createFragment(ArrayList<DrawerItemInfo> drawerItems,
                                                Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        DrawerFragment drawerFragment = new DrawerFragment();
        Bundle args = new Bundle();
        drawerFragment.setOnDrawerItemClickListener(onDrawerItemClickListener);

        args.putSerializable(ARG_DRAWER_ITEMS_KEY, drawerItems);
        drawerFragment.setArguments(args);

        return drawerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drawer, container, false);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.setupDrawer();
    }

    protected void setupDrawer() {
        View root = this.getView();
        Toolbar toolbar = (Toolbar) (root.findViewById(R.id.drawer_toolbar));

        List<PrimaryDrawerItem> items =
                ((ArrayList<DrawerItemInfo>) this.getArguments().getSerializable(ARG_DRAWER_ITEMS_KEY))
                        .stream()
                        .map(drawerItemInfo ->
                                new PrimaryDrawerItem()
                                        .withIdentifier(drawerItemInfo.getId())
                                        .withName(drawerItemInfo.getTitle())
                        )
                        .collect(Collectors.toList());

        Drawer result = new DrawerBuilder()
                .withActivity(this.getActivity())
                .withToolbar(toolbar)
                .withDrawerItems(new ArrayList<>(items))
                .withOnDrawerItemClickListener(this.onDrawerItemClickListener)
                .build();

//                .withOnDrawerItemClickListener(
//                        (view, position, drawerItem) -> {
//                            if (drawerItem.getIdentifier() == 2) {
//                                Intent intent = new Intent(this.getContext(), TabsNavigationActivity.class);
//                                this.startActivity(intent);
//                            }
//                            return true;
//                        })
    }

    public void setOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        this.onDrawerItemClickListener = onDrawerItemClickListener;
    }
}
