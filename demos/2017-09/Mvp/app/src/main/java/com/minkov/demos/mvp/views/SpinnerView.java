package com.minkov.demos.mvp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;

/**
 * A loading view
 * Supports some types of loading ({@link LoaderType}):
 * <ul>
 * <li>Pacman</li>
 * <li>Circle</li>
 * </ul>
 */
public class SpinnerView extends View {
    private static final String DEFAULT_COLOR = "#ff0000";
    private static final float ANGLE_OFFSET = 270;

    private Paint mCirclePaint;
    private Paint mPacmanPaint;

    private LoaderType mLoaderType;
    private boolean mIsFirst;

    private RectF mBounds;
    private String mColor;

    private float mCircleAngle;
    private boolean mIsPacmanOpen;
    private RectF mFoodBounds;

    /**
     * Creates an instance
     *
     * @param context application context
     */
    public SpinnerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mColor = DEFAULT_COLOR;
        mLoaderType = LoaderType.Circle;
        mBounds = new RectF(
                0.0f,
                0.0f,
                0.0f,
                0.0f
        );
        mCircleAngle = 0.0f;
        setUpPaint();
    }

    private void setUpPaint() {
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStrokeWidth(25);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(Color.parseColor(mColor));

        mPacmanPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPacmanPaint.setColor(Color.parseColor(mColor));
        mPacmanPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mIsFirst) {
            mCircleAngle = 0;
            mIsPacmanOpen = true;
        }

        mIsFirst = false;

//        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        switch (mLoaderType) {
            case Pacman:
                drawPacman(canvas);
                postInvalidateDelayed(400);
                break;
            case Circle:
            default:
                drawCircle(canvas);
                postInvalidateDelayed(20);
                break;
        }
    }

    private void drawCircle(Canvas canvas) {
        float fromAngle = mCircleAngle;
        float toAngle = fromAngle + ANGLE_OFFSET;
        toAngle %= 360;

        canvas.drawArc(mBounds, fromAngle, toAngle, false, mCirclePaint);

        // continue animation
        mCircleAngle += 5;
        mCircleAngle %= 360;
    }

    private void drawPacman(Canvas canvas) {
        float fromAngle = 0.0f;
        float toAngle = 360.0f;

        if (mIsPacmanOpen) {
            fromAngle = 30.0f;
            toAngle = 360 - 2 * fromAngle;
        }

        if (mIsPacmanOpen) {
            canvas.drawOval(mFoodBounds, mPacmanPaint);
        }

        canvas.drawArc(mBounds, fromAngle, toAngle, true, mPacmanPaint);

        mIsPacmanOpen = !mIsPacmanOpen;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float actualWidth = w - getPaddingLeft() - getPaddingRight();
        float actualHeight = w - getPaddingTop() - getPaddingBottom();
        float d = Math.min(actualHeight, actualWidth);

        float offset = 30;

        mBounds = new RectF(
                0.0f + offset,
                0.0f + offset,
                d - offset,
                d - offset
        );

        float foodRadius = d / 15;
        mFoodBounds = new RectF(
                d - 1.5f * offset - foodRadius,
                mBounds.centerY() - foodRadius,
                d - 1.5f * offset + foodRadius,
                mBounds.centerY() + foodRadius
        );
    }

    /**
     * Sets the color of the loader
     *
     * @param color a string in #RRGGBB format
     */
    public void setColor(String color) {
        this.mColor = color;
        mCirclePaint.setColor(Color.parseColor(mColor));
        mPacmanPaint.setColor(Color.parseColor(mColor));
    }

    /**
     * Sets the loader type
     *
     * @param loaderType {@link LoaderType} value
     */
    public void setLoaderType(LoaderType loaderType) {
        if (mLoaderType != loaderType) {
            mIsFirst = true;
        }

        mLoaderType = loaderType;
    }

    public enum LoaderType {
        /**
         * Shows an eating pacman
         */
        Pacman,
        /**
         * Shows a rotating circle
         */
        Circle,
    }
}

/*
Custom drawing
1. Canvas -> it draws
2. Paint -> How to draw
3. Size
 */