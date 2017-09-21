package com.minkov.notificationsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.minkov.notificationsdemo.ui.NotificationsFactory;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private NotificationsFactory notificationsFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) this.findViewById(R.id.tv);
        notificationsFactory = new NotificationsFactory(this);
//        Intent intent = new Intent(this, NextActivity.class);
//        Notification notification = notificationsFactory.notify(
//                "NEW title",
//                new Date().toString(),
//                R.drawable.ic_superhero_notification);

//        notificationsFactory.notifyProgress(
//                "NEW title",
//                new Date().toString(),
//                R.drawable.ic_superhero_notification,
//                intent);


        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(new Date().getTime() + "");
                        notificationsFactory.notify(
                                "Update",
                                new Date().getTime() + "",
                                R.drawable.ic_superhero_notification);
                    }
                });

            }
        }, 0, 150, TimeUnit.MILLISECONDS);


//        Intent serviceIntent = new Intent(this, BackgroundService.class);
//
//        serviceIntent.putExtra("index", 1);
//
//        startService(serviceIntent);
    }
}
