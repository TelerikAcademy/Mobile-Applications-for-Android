package com.minkov.mvpdemos.ui;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.minkov.mvpexplore2.R;
import com.minkov.mvpdemos.models.Superhero;

import javax.inject.Inject;

/**
 * Created by minkov on 2/13/17.
 */

public class ModalFactory {
    @Inject
    public ModalFactory() {

    }

    public Dialog getAddSuperheroModal(Context context, final ModalFactory.OnClickCallback callback) {
        return new MaterialDialog.Builder(context)
                .title(R.string.model_add_title)
                .customView(R.layout.modal_add, true)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        String name = ((EditText) dialog.findViewById(R.id.etName))
                                .getText()
                                .toString();
                        Superhero superhero = new Superhero(null, name);
                        callback.onClick(superhero);
                    }
                })
                .build();
    }

    public interface OnClickCallback<T> {
        void onClick(T result);
    }
}