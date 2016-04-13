package com.example.android.livenavdemo.customeViews;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class NoSwipeViewPager extends ViewPager {
  public NoSwipeViewPager(Context context) {
    super(context);
  }

  public NoSwipeViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent event) {
    // Never allow swiping to switch between pages
    return false;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    // Never allow swiping to switch between pages
    return false;
  }
}