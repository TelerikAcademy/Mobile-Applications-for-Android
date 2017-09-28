package com.minkov.demos.mvp.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by doncho on 9/28/17.
 */

public final class ActivityUtils {
    private ActivityUtils() {

    }

    /**
     * Attaches a fragment to provided FragmentManager
     * @param fragmentManager the fragment manager used to insertion
     * @param resouceId the id of the resource
     * @param fragment the fragment
     */
    public static void attachFragment(FragmentManager fragmentManager, int resouceId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(resouceId, fragment)
                .commit();
    }

    /**
     * @param activity the activity
     * @param resourceId the resourceId to check
     * @return true if the view exists, false in it does not exist
     */
    public static boolean containsView(Activity activity, int resourceId) {
        return activity.findViewById(resourceId) != null;
    }
}
