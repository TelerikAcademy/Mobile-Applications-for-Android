package com.minkov.mvpdemos.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.minkov.mvpexplore2.R;

import javax.inject.Inject;

/**
 * Created by minkov on 2/12/17.
 */

public class Notifier {
    private final Context context;

    @Inject
    public Notifier(Context context) {
        this.context = context;
    }

    public void notifySuccess(Activity activity, String message) {
        SuperActivityToast.create(activity, new Style(), Style.TYPE_BUTTON)
                .setProgressBarColor(Color.WHITE)
                .setText(message)
                .setDuration(Style.DURATION_SHORT)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE))
                .setAnimations(Style.ANIMATIONS_POP)
                .show();
    }
}
