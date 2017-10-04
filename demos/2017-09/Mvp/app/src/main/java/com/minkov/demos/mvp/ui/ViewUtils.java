package com.minkov.demos.mvp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.minkov.demos.mvp.views.LoadingView;

public class ViewUtils {
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

    public static void hideLoadingScreen(
            View contentContainer,
            ViewGroup loadingContainer) {
        contentContainer.setVisibility(View.VISIBLE);
        loadingContainer.setVisibility(View.GONE);
    }
}
