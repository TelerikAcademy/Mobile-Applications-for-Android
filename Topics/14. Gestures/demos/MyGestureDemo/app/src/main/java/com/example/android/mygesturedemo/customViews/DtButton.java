package com.example.android.mygesturedemo.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;

public class DtButton extends Button {
  private GestureDetector detector;

  public DtButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    detector = new GestureDetector(getContext(), getDefaultDtListener());
  }

  public void setDtListener(DtGestureListener listener) {
    detector = new GestureDetector(getContext(), listener);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return detector.onTouchEvent(event);
  }

  public GestureDetector.OnGestureListener getDefaultDtListener() {
    return new DtGestureListener() {

      @Override
      boolean onCustomDoubleTap() {
        return true;
      }
    };
  }

  public abstract class DtGestureListener extends GestureDetector.SimpleOnGestureListener {
    protected abstract boolean onCustomDoubleTap();
  }
}