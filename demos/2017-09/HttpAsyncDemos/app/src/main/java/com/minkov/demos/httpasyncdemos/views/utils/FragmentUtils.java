package com.minkov.demos.httpasyncdemos.views.utils;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by minkov on 9/25/17.
 */

public class FragmentUtils {
  public static void showLoading(LoadingView fragment) {
//    View spinner = new ProgressBar(fragment.getContext());

    AVLoadingIndicatorView spinner = new AVLoadingIndicatorView(fragment.getContext());
    spinner.setIndicator("PacmanIndicator");
    spinner.setIndicatorColor(4);
    spinner.show();

    ViewGroup.LayoutParams layoutParams =
            new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);

    spinner.setLayoutParams(layoutParams);

    fragment.getLoadingContainer().removeAllViews();
    fragment.getLoadingContainer().addView(spinner);

    fragment.getLoadingContainer().setVisibility(View.VISIBLE);
    fragment.getContentContainer().setVisibility(View.GONE);
  }

  public static void hideLoading(LoadingView fragment) {
    fragment.getLoadingContainer().setVisibility(View.GONE);
    fragment.getContentContainer().setVisibility(View.VISIBLE);
  }

  public interface LoadingView {
    View getContentContainer();
    ViewGroup getLoadingContainer();
    Context getContext();

    void showLoading();
    void hideLoading();
  }
}
