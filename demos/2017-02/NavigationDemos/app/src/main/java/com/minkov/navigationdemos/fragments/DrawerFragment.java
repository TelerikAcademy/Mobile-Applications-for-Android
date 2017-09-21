package com.minkov.navigationdemos.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private GestureDetector detector;
    private Drawer drawer;

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

        this.drawer = new DrawerBuilder()
                .withActivity(this.getActivity())
                .withToolbar(toolbar)
                .withDrawerItems(new ArrayList<>(items))
                .withOnDrawerItemClickListener(this.onDrawerItemClickListener)
                .build();


        detector = new GestureDetector(this.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                float xDiff = Math.abs(e1.getX() - e2.getX());
                float yDiff = Math.abs(e1.getY() - e2.getY());

                if (xDiff > yDiff) {
                    if (e1.getX() < e2.getX()) {
                        drawer.openDrawer();
                    } else {
                        drawer.closeDrawer();
                    }
                } else {

                }

                return super.onFling(e1, e2, velocityX, velocityY);
            }

        });

    }

    public void setOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        this.onDrawerItemClickListener = onDrawerItemClickListener;
    }
}
