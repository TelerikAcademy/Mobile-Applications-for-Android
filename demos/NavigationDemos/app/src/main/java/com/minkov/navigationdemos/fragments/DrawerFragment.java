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
import com.minkov.navigationdemos.R;

import java.util.ArrayList;

public class DrawerFragment extends Fragment {
    private Drawer.OnDrawerItemClickListener onDrawerItemClickListener;


    public DrawerFragment() {
        // Required empty public constructor
    }

    public static DrawerFragment createFragment(ArrayList<DrawerItemInfo> drawerItems,
                                                Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        DrawerFragment drawerFragment = new DrawerFragment();
        Bundle args = new Bundle();
        drawerFragment.setOnDrawerItemClickListener(onDrawerItemClickListener);

        args.putSerializable("drawerItems", drawerItems);
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

        PrimaryDrawerItem item1 = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName(R.string.drawer_item_home);

        SecondaryDrawerItem item2 = new SecondaryDrawerItem()
                .withIdentifier(2)
                .withName(R.string.drawer_item_tabs);

        Drawer result = new DrawerBuilder()
                .withActivity(this.getActivity())
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2
                )
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


    public class DrawerItemInfo {
        public String title;
        public int id;
    }

}
