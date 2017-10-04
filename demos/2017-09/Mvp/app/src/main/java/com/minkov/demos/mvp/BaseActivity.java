package com.minkov.demos.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.minkov.demos.mvp.PersonsLists.PersonsListActivity;
import com.minkov.demos.mvp.Profile.ProfileActivity;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Base activity for providing drawer functionality
 */
public abstract class BaseActivity extends DaggerAppCompatActivity implements Drawer.OnDrawerItemClickListener {

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
//                .withHeader(new LoadingView(this))
//                .addDrawerItems(mItems)

                .addDrawerItems(new PrimaryDrawerItem()
                                .withIdentifier(1)
                                .withName("Persons List"),
                        new PrimaryDrawerItem()
                                .withIdentifier(3)
                                .withName("Persons List")
                                .withIcon(android.R.drawable.ic_btn_speak_now),
                        new SectionDrawerItem()
                                .withName("Secondary")
                                .withSubItems(
                                        new PrimaryDrawerItem()
                                                .withIdentifier(4)
                                                .withName("Persons List"),
                                        new PrimaryDrawerItem()
                                                .withIdentifier(5)
                                                .withName("Persons List"),
                                        new SecondaryDrawerItem()
                                                .withIdentifier(6)
                                                .withName("Persons List"),
                                        new PrimaryDrawerItem()
                                                .withIdentifier(7)
                                                .withName("Persons List")
                                )
                )
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
