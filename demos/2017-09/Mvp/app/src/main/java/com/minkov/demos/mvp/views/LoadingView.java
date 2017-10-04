package com.minkov.demos.mvp.views;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.minkov.demos.mvp.R;

/**
 * LoadingScreen view
 * Has a header and loading text
 */
public class LoadingView extends RelativeLayout {
    private ViewGroup mBackground;
    private ViewGroup mLoadingPane;
    private int mPaneHeight;

    /**
     * Initializes an instance
     *
     * @param context application context
     */
    public LoadingView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaneHeight = 300;
        initBackground();
        initLoadingPane();
    }

    private void initBackground() {
        mBackground = new RelativeLayout(getContext());

        ImageView imageView = new ImageView(getContext());

        imageView.setImageResource(R.drawable.loading_screen);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mBackground.addView(imageView);

        View dimView = new View(getContext());
        dimView.setBackgroundColor(Color.parseColor("#000000"));
        dimView.getBackground()
                .setAlpha(40);

        mBackground.addView(dimView);

        LayoutParams lp = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        lp.addRule(ALIGN_PARENT_TOP);
        lp.addRule(ALIGN_PARENT_LEFT);
        lp.addRule(ALIGN_PARENT_START);
        lp.addRule(ALIGN_PARENT_BOTTOM);
        lp.addRule(ALIGN_PARENT_RIGHT);
        lp.addRule(ALIGN_PARENT_END);

        imageView.setLayoutParams(lp);
        dimView.setLayoutParams(lp);
        mBackground.setLayoutParams(lp);
        addView(mBackground);
    }

    private void initLoadingPane() {
        mLoadingPane = new LinearLayout(getContext());
        mLoadingPane.setBackgroundColor(Color.parseColor("#000000"));
        mLoadingPane.getBackground()
                .setAlpha(70);

        LayoutParams lp = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                mPaneHeight);

        lp.addRule(ALIGN_PARENT_LEFT);
        lp.addRule(ALIGN_PARENT_START);
        lp.addRule(ALIGN_PARENT_BOTTOM);
        lp.addRule(ALIGN_PARENT_RIGHT);
        lp.addRule(ALIGN_PARENT_END);
        mLoadingPane.setLayoutParams(lp);

        SpinnerView spinner = new SpinnerView(getContext());
//        spinner.setLoaderType(SpinnerView.LoaderType.Pacman);
        TextView label = new TextView(getContext());
        label.setText("Loading...");
        label.setTextColor(Color.parseColor("#ffffff"));
        label.setTextSize(18);

        ViewGroup.LayoutParams lpChildren = new ViewGroup.LayoutParams(
                mPaneHeight,
                mPaneHeight
        );

        spinner.setLayoutParams(lpChildren);
        label.setLayoutParams(lpChildren);

        mLoadingPane.addView(spinner);
        mLoadingPane.addView(label);

        addView(mLoadingPane);
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        mPaneHeight = h / 10;
////        initLoadingPane();
//        LayoutParams lp = new LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                mPaneHeight);
//
//        lp.addRule(ALIGN_PARENT_LEFT);
//        lp.addRule(ALIGN_PARENT_START);
//        lp.addRule(ALIGN_PARENT_BOTTOM);
//        lp.addRule(ALIGN_PARENT_RIGHT);
//        lp.addRule(ALIGN_PARENT_END);
//        mLoadingPane.setLayoutParams(lp);
//
//    }
}
