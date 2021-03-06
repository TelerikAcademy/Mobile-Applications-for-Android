package com.minkov.demos.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.minkov.demos.mvp.Locations.LocationsActivity;
import com.minkov.demos.mvp.PersonsLists.PersonsListActivity;
import com.minkov.demos.mvp.Profile.ProfileActivity;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Base activity for providing drawer functionality
 */
public abstract class BaseDrawerActivity extends BaseActivity implements Drawer.OnDrawerItemClickListener {

    private static final String EXTRA_IDENTIFIER = "EXTRA_IDENTIFIER";
    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDrawer();
    }

    private void setupDrawer() {
        Intent intent = getIntent();
        long currentIdentifier = intent.getLongExtra(EXTRA_IDENTIFIER, 1);

        Toolbar toolbar = getToolbar();
        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(new PrimaryDrawerItem()
                        .withIdentifier(1)
                        .withName("Persons List")
                )
                .addDrawerItems(new ExpandableDrawerItem()
                        .withName("APIs")
                        .withSubItems(
                                new SecondaryDrawerItem()
                                        .withIdentifier(3)
                                        .withName("Location")
                        ))
                .addStickyDrawerItems(
                        new PrimaryDrawerItem()
                                .withIdentifier(2)
                                .withName("Profile")
                )
                .withSelectedItem(currentIdentifier)
                .withOnDrawerItemClickListener(this)
                .build();

    }

    /**
     * Method for providing toolbar for drawer button
     *
     * @return the toolbar element of the view
     */
    protected abstract Toolbar getToolbar();

    @Override
    public boolean onItemClick(
            View view,
            int position,
            IDrawerItem drawerItem) {

        Intent intent = null;
        switch ((int) drawerItem.getIdentifier()) {
            case 1:
                intent = new Intent(this, PersonsListActivity.class);
                break;
            case 2:
                intent = new Intent(this, ProfileActivity.class);
                break;
            case 3:
                intent = new Intent(this, LocationsActivity.class);
                break;
            default:
                return false;
        }

        intent.putExtra(EXTRA_IDENTIFIER, drawerItem.getIdentifier());

        startActivity(intent);
        return true;
    }

    public Drawer getDrawer() {
        return mDrawer;
    }
}
