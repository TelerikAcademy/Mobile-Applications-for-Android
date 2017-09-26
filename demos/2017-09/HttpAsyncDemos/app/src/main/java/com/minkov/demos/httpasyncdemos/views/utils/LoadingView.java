package com.minkov.demos.httpasyncdemos.views.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * Created by minkov on 9/25/17.
 */
//
//public interface LoadingView {
//  int getContentContainerId();
//
//  int getLoadingContainerId();

//  Context getContext();
//
//  View getView();

//  default void showLoading() {
//    ProgressBar spinner = new ProgressBar(getContext());
//
//    // check if is ViewGroup
//    ViewGroup loadingContainer = (ViewGroup) getView().findViewById(getLoadingContainerId());
//    loadingContainer.removeAllViews();
//    loadingContainer.addView(spinner);
//
//    View contentContainer = getView().findViewById(getContentContainerId());
//
//    loadingContainer.setVisibility(View.VISIBLE);
//    contentContainer.setVisibility(View.GONE);
//  }
//
//  default void hideLoading() {
//    View loadingContainer = getView().findViewById(getLoadingContainerId());
//    View contentContainer = getView().findViewById(getContentContainerId());
//
//    loadingContainer.setVisibility(View.GONE);
//    contentContainer.setVisibility(View.VISIBLE);
//  }
//}
