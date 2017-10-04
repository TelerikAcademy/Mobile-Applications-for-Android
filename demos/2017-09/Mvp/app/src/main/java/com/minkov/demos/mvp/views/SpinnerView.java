package com.minkov.demos.mvp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;

public class SpinnerView extends View {
    private static final String DEFAULT_COLOR = "#ff0000";
    private static final float ANGLE_OFFSET = 270;
    private Paint mPaint;

    private RectF mBounds;
    private String mColor;

    private float mAngle;

    public SpinnerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mColor = DEFAULT_COLOR;
        mBounds = new RectF(
                0.0f,
                0.0f,
                0.0f,
                0.0f
        );
        mAngle = 0.0f;
        setUpPaint();
    }

    private void setUpPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(55);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor(mColor));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float fromAngle = mAngle;
        float toAngle = fromAngle + ANGLE_OFFSET;
        toAngle %= 360;

        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.drawArc(mBounds, fromAngle, toAngle, false, mPaint);

        // continue animation
        mAngle += 5;
        mAngle %= 360;
        postInvalidateDelayed(20);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float actualWidth = w - getPaddingLeft() - getPaddingRight();
        float actualHeight = w - getPaddingTop() - getPaddingBottom();
        float d = Math.min(actualHeight, actualWidth);

        float offset = 55;

        mBounds = new RectF(
                0.0f + offset,
                0.0f + offset,
                d - offset,
                d - offset
        );


    }

    public void setColor(String color) {
        this.mColor = color;
        mPaint.setColor(Color.parseColor(mColor));
    }
}

/*
Custom drawing
1. Canvas -> it draws
2. Paint -> How to draw
3. Size
 */