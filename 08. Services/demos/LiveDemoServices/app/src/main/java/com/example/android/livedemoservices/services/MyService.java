package com.example.android.livedemoservices.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();

    return START_STICKY;
  }

  @Override
  public void onDestroy() {
    Toast.makeText(this, "Service stoped", Toast.LENGTH_SHORT).show();
  }
}
