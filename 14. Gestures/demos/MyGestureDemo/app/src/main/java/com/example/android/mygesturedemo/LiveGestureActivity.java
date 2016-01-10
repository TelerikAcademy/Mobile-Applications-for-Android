package com.example.android.mygesturedemo;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class LiveGestureActivity
        extends AppCompatActivity {

  private GestureDetectorCompat detector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_live_gesture);

    detector = new GestureDetectorCompat(this, new MyGestureListener());
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    detector.onTouchEvent(event);
    return false;
  }

  private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onDoubleTap(MotionEvent e) {
      Toast.makeText(getBaseContext(), "Double Tap", Toast.LENGTH_SHORT).show();
      return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
      Toast.makeText(getBaseContext(), "Double Tap Event", Toast.LENGTH_SHORT).show();
      return super.onDoubleTapEvent(e);
    }
  }
}
