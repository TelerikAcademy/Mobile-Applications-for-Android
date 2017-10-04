package com.minkov.demos.mvp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.minkov.demos.mvp.views.LoadingView;

/**
 * Contains utils methods for views
 */
public final class ViewUtils {
    private ViewUtils() {
    }

    /**
     * Shows a loading screen
     *
     * @param context          application context
     * @param contentContainer the container that must be hidden
     * @param loadingContainer the container where the loader should appear
     */
    public static void showLoadingScreen(
            Context context,
            View contentContainer,
            ViewGroup loadingContainer) {

//        View spinner = new ProgressBar(context);
        View spinner = new LoadingView(context);
        loadingContainer.removeAllViews();
        loadingContainer.addView(spinner);

        contentContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.VISIBLE);
    }

    /**
     * Shows a loading screen
     *
     * @param contentContainer the container that must be shown
     * @param loadingContainer the container where the loader should hidden
     */
    public static void hideLoadingScreen(
            View contentContainer,
            ViewGroup loadingContainer) {
        contentContainer.setVisibility(View.VISIBLE);
        loadingContainer.setVisibility(View.GONE);
    }
}
