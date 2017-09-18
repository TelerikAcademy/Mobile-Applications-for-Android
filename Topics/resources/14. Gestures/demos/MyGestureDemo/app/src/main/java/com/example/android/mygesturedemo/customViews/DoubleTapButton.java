package com.example.android.mygesturedemo.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

public class DoubleTapButton extends Button {
  public String value;
  private GestureDetector gestureDetector;

  public DoubleTapButton(final Context context, AttributeSet attrs) {
    super(context, attrs);
    this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
      @Override
      public boolean onDown(MotionEvent e) {

        Toast.makeText(getContext(), "on Btn Down", Toast.LENGTH_SHORT).show();
        return false;
      }
    });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return gestureDetector.onTouchEvent(event);
  }

  public abstract class DoubleTapButtonGestureListener
          extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onDown(MotionEvent event) {
      Toast.makeText(getContext(), "on btn Down", Toast.LENGTH_SHORT).show();
      return true;
    }

    abstract boolean onMyDoubleTap(MotionEvent event);
  }


  private DoubleTapButtonGestureListener getDefaultDoubleTapListener() {
    return new DoubleTapButtonGestureListener() {
      boolean onMyDoubleTap(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        String message = String.format("Double tapped @ {%s, %s}", x, y);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

        return true;
      }
    };
  }
}