package com.example.android.mygesturedemo;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.TextView;
import android.widget.Toast;

public class GestureActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
                   GestureDetector.OnDoubleTapListener {
  private static final String DEBUG_TAG = "Velocity";

  private GestureDetectorCompat gestureDetector;
  private VelocityTracker mVelocityTracker = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gesture);

    this.gestureDetector = new GestureDetectorCompat(this, this);
    this.gestureDetector.setOnDoubleTapListener(this);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    this.gestureDetector.onTouchEvent(event);

//    int index = event.getActionIndex();
//    int action = event.getActionMasked();
//    int pointerId = event.getPointerId(index);
//
//    switch(action) {
//      case MotionEvent.ACTION_DOWN:
//        if(mVelocityTracker == null) {
//          // Retrieve a new VelocityTracker object to watch the velocity of a motion.
//          mVelocityTracker = VelocityTracker.obtain();
//        }
//        else {
//          // Reset the velocity tracker back to its initial state.
//          mVelocityTracker.clear();
//        }
//        // Add a user's movement to the tracker.
//        mVelocityTracker.addMovement(event);
//        break;
//      case MotionEvent.ACTION_MOVE:
//        mVelocityTracker.addMovement(event);
//        // When you want to determine the velocity, call
//        // computeCurrentVelocity(). Then call getXVelocity()
//        // and getYVelocity() to retrieve the velocity for each pointer ID.
//        mVelocityTracker.computeCurrentVelocity(1000);
//        // Log velocity of pixels per second
//        // Best practice to use VelocityTrackerCompat where possible.
//        Log.d("", "X velocity: " + VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId));
//        Log.d("", "Y velocity: " + VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId));
//        break;
//      case MotionEvent.ACTION_UP:
//      case MotionEvent.ACTION_CANCEL:
//        // Return a VelocityTracker object back to be re-used by others.
//        mVelocityTracker.recycle();
//        break;
//    }
//    return true;
    return super.onTouchEvent(event);
  }

  @Override
  public boolean onSingleTapConfirmed(MotionEvent e) {
    Toast.makeText(this, "Single Tap Confirmed", Toast.LENGTH_SHORT).show();
    return true;
  }

  @Override
  public boolean onDoubleTap(MotionEvent e) {
    Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
    return true;
  }

  @Override
  public boolean onDoubleTapEvent(MotionEvent e) {
    Toast.makeText(this, "Double Tap Event", Toast.LENGTH_SHORT).show();
    return true;
  }

  @Override
  public boolean onDown(MotionEvent e) {
    Toast.makeText(this, "Down", Toast.LENGTH_SHORT).show();
    return false;
  }

  @Override
  public void onShowPress(MotionEvent e) {

  }

  @Override
  public boolean onSingleTapUp(MotionEvent e) {
    Toast.makeText(this, "Single Tap Up", Toast.LENGTH_SHORT).show();
    return true;
  }

  @Override
  public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    // Toast.makeText(this, "Scroll", Toast.LENGTH_SHORT).show();
    return true;
  }

  @Override
  public void onLongPress(MotionEvent e) {

  }

  @Override
  public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    Toast.makeText(this, "Fling", Toast.LENGTH_SHORT).show();
    return true;
  }
}
