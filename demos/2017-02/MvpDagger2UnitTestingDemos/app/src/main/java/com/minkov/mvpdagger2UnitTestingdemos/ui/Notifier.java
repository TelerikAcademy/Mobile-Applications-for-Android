package com.minkov.mvpdagger2UnitTestingdemos.ui;

import android.content.Context;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;

import javax.inject.Inject;

/**
 * Created by minkov on 2/15/17.
 */

public class Notifier {

    @Inject
    public Notifier(){

    }

    public void notifySuccess(Context context, String text) {
        SuperActivityToast.create(context, new Style(), Style.TYPE_BUTTON)
                .setText(text)
                .setDuration(Style.DURATION_SHORT)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setAnimations(Style.ANIMATIONS_POP)
                .show();
    }
}
