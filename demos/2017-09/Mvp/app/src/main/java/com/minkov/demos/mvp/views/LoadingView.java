package com.minkov.demos.mvp.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    private TextView mLabel;
    private SpinnerView mSpinner;

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
        mLoadingPane = new RelativeLayout(getContext());
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

        mSpinner = buildSpinner();
        mLabel = buildLoadingTextView();

        mLoadingPane.addView(mSpinner);
        mLoadingPane.addView(mLabel);

        addView(mLoadingPane);
    }

    private TextView buildLoadingTextView() {
        TextView label = new TextView(getContext());
        label.setText("Loading...");
        label.setTextColor(Color.parseColor("#ffffff"));
        label.setTextSize(18);
        label.setPadding(25, 0, 0, 0);

        LayoutParams lp = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        lp.addRule(RIGHT_OF, R.id.spinner);
        label.setLayoutParams(lp);
        return label;
    }

    private SpinnerView buildSpinner() {
        SpinnerView spinner = new SpinnerView(getContext());
        spinner.setId(R.id.spinner);
//        spinner.setLoaderType(SpinnerView.LoaderType.Pacman);
        spinner.setColor("#FFE100");

        LayoutParams lp = new LayoutParams(
                mPaneHeight,
                mPaneHeight);

        lp.addRule(ALIGN_PARENT_START);
        lp.addRule(ALIGN_PARENT_LEFT);

        spinner.setLayoutParams(lp);

        return spinner;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mPaneHeight = h / 8;

        ViewGroup.LayoutParams lp = mLoadingPane.getLayoutParams();
        lp.height = mPaneHeight;
        mLoadingPane.setLayoutParams(lp);

        ViewGroup.LayoutParams lp2 = mSpinner.getLayoutParams();
        lp2.height = mPaneHeight;
        lp2.width = mPaneHeight;
        mSpinner.setLayoutParams(lp2);

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                requestLayout();
                mSpinner.requestLayout();
            }
        });
    }

    /**
     * Sets the color of the spinner
     *
     * @param color a #RRGGBB value
     */
    public void setColor(String color) {
        mSpinner.setColor(color);
    }

    /**
     * Sets the text of the label
     *
     * @param text a {@link String}
     */
    public void setText(String text) {
        mLabel.setText(text);
    }
}
