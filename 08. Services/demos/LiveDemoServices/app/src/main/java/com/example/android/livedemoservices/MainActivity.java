package com.example.android.livedemoservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.livedemoservices.services.MyService;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void starService(View view) {
    Intent serviceIntent = new Intent(this, MyService.class);
    this.startService(serviceIntent);
  }

  public void stopService(View view) {
    Intent serviceIntent = new Intent(this, MyService.class);
    this.stopService(serviceIntent);
  }
}
