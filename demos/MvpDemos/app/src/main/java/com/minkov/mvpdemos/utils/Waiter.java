package com.minkov.mvpdemos.utils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by minkov on 2/13/17.
 */

public class Waiter {

    @Inject
    public Waiter(){}

    public <T> Observable<T> wait(int milliseconds) {
        return Observable.just((T) new Object())
                .delay(milliseconds, TimeUnit.MILLISECONDS);
    }
}
