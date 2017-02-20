package com.minkov.notificationsdemo.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v4.app.NotificationCompat;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 2/16/17.
 */

public class NotificationsFactory {
    private final Context context;
    private final NotificationManager manager;

    public NotificationsFactory(Context context) {
        this.context = context;
        this.manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    private NotificationCompat.Builder getNotificationCompatBuilder(String title, String text, int icon) {
        return new NotificationCompat.Builder(this.context)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(icon);
    }

    public void notifyProgress(String title, String text, int icon) {
        this.notifyProgress(title, text, icon, null);
    }

    public void notifyProgress(String title, String text, int icon, final Intent intent) {
        final NotificationCompat.Builder builder = this.getNotificationCompatBuilder(title, text, icon);

        builder.setProgress(100, 0, true);

        builder.setContentText("Download started");

        manager.notify(1, builder.build());

        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                        int count = 100;
                        for (int i = 1; i <= count; i += 3) {
                            Thread.sleep(100);
                            e.onNext(i);
                        }
                        Thread.sleep(200);
                        e.onComplete();
                    }
                })
                .delay(2, TimeUnit.SECONDS)
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        builder.setContentText("Download completed");
                        if (intent != null) {
                            PendingIntent pendingIntent =
                                    PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                            builder.setContentIntent(pendingIntent);
                        }

                        manager.notify(1, builder.build());
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer progress) throws Exception {
                        builder
                                .setContentText("Progress at " + progress + "%")
                                .setProgress(100, progress, false);
                        Notification notification = builder.build();
                        notification.flags |= Notification.FLAG_NO_CLEAR;

                        manager.notify(1, notification);
                    }
                });
    }

    public Notification notify(String title, String text, int icon, Intent intent) {
        NotificationCompat.Builder builder = this.getNotificationCompatBuilder(title, text, icon);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        final Notification notification = builder.build();

        Observable
                .just(5)
                .delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        manager.notify(1, notification);
                    }
                });


        return notification;
    }

    public Notification notify(String title, String text, int icon) {
        NotificationCompat.Builder builder = this.getNotificationCompatBuilder(title, text, icon);

        final Notification notification = builder.build();

        Observable
                .just(5)
                .delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        manager.notify(1, notification);
                    }
                });
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) throws Exception {
//                        manager.notify(1, notification);
//                        return integer;
//                    }
//                })
//                .delay(2, TimeUnit.SECONDS)
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        manager.cancel(1);
//                    }
//                });
        return notification;
    }
}
