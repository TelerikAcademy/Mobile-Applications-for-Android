package com.example.android.mygesturedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.android.mygesturedemo.customViews.DoubleTapButton;
import com.example.android.mygesturedemo.customViews.DtButton;

public class SimpleGestureActivity
        extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
                    GestureDetector.OnDoubleTapListener{
  GestureDetector detector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_gesture);

    this.detector = new GestureDetector(this, this);

    DtButton btn = (DtButton) findViewById(R.id.double_tap_button);
    btn.setDtListener(new DtButton.DtGestureListener() {

    });

  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    this.detector.onTouchEvent(event);
    return super.onTouchEvent(event);
  }

  @Override
  public boolean onDown(MotionEvent e) {
    Toast.makeText(this, "on Activity Down", Toast.LENGTH_SHORT).show();

    return true;
  }

  @Override
  public void onShowPress(MotionEvent e) {

  }

  @Override
  public boolean onSingleTapUp(MotionEvent e) {
    return false;
  }

  @Override
  public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    return false;
  }

  @Override
  public void onLongPress(MotionEvent e) {

  }

  @Override
  public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    return false;
  }

  @Override
  public boolean onSingleTapConfirmed(MotionEvent e) {
    return false;
  }

  @Override
  public boolean onDoubleTap(MotionEvent e) {
    Toast.makeText(this, "Activity Double tapped", Toast.LENGTH_SHORT).show();
    return true;
  }

  @Override
  public boolean onDoubleTapEvent(MotionEvent e) {
    return false;
  }
}
