package com.minkov.notificationsdemo.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.minkov.notificationsdemo.R;
import com.minkov.notificationsdemo.ui.NotificationsFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 2/16/17.
 */

public class BackgroundService extends IntentService {

    private NotificationsFactory notificationFactory;

    public BackgroundService() {
        this("DEFAULT_NAME");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BackgroundService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int index = intent.getIntExtra("index", 0);
        notificationFactory = new NotificationsFactory(this.getBaseContext());
        final Context context = this;
        Observable
                .just(index)
                .delay(150, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer index) throws Exception {
                        Toast.makeText(context, "It works", Toast.LENGTH_SHORT)
                                .show();
                        notificationFactory.notify("NEW", "Index " + index, R.drawable.ic_superhero_notification);
                        Intent nextIntent = new Intent(context, BackgroundService.class);
                        nextIntent.putExtra("index", index + 1);
                        startService(nextIntent);
                    }
                });
    }
}
