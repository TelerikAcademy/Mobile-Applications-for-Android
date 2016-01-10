package com.example.android.mygesturedemo;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView listView = (ListView) findViewById(R.id.listView);
    listView.setOnTouchListener(getListViewOnTouchListener());
    listView.getTouchDelegate();
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    event.getAction();
    int action = MotionEventCompat.getActionMasked(event);

    switch(action) {
      case (MotionEvent.ACTION_DOWN) :
        Toast.makeText(this, "ACTION DOWN", Toast.LENGTH_SHORT).show();
        return true;
      case (MotionEvent.ACTION_MOVE) :
        // Toast.makeText(this, "ACTION MOVE", Toast.LENGTH_SHORT).show();
        return true;
      case (MotionEvent.ACTION_UP) :
        Toast.makeText(this, "ACTION UP", Toast.LENGTH_SHORT).show();
        return true;
      case (MotionEvent.ACTION_CANCEL) :
        Toast.makeText(this, "ACTION CANCEL", Toast.LENGTH_SHORT).show();
        return true;
      case (MotionEvent.ACTION_OUTSIDE) :
        Toast.makeText(this, "Movement occurred outside bounds of current screen element", Toast.LENGTH_SHORT).show();
        return true;
      default :
        return super.onTouchEvent(event);
    }
  }

  private View.OnTouchListener getListViewOnTouchListener() {
    return new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {


        return true;
      }
    };
  }
}
